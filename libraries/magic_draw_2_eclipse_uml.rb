#!/usr/bin/ruby

require 'nokogiri'
require 'securerandom'

XmlResource = Struct.new(:path, :doc, :changed)

class Normalizer

  def initialize(xml_resource, niem_reference_dir)
    @xml_resource = xml_resource
    @niem_reference_dir = niem_reference_dir
  end

  def normalize_pocs
    poc_classifiers = @xml_resource.doc.xpath("//classifier[@href='http://www.omg.org/spec/NIEM-UML/20120501/NIEM_UML_Profile#NIEM_UML_Profile-Model_Package_Description_Profile-POCType']")
    unless poc_classifiers.nil?
      poc_classifiers.each do |poc_classifier|
        parent = poc_classifier.parent()
        poc_phone_numbers = []										
        poc_emails = []										
        poc_name = parent.xpath("//slot/value[@name='POCName']").first()['value']
        parent.xpath("//slot/value[@name='POCTelephone']").each { |phone| poc_phone_numbers << phone['value'] }
        parent.xpath("//slot/value[@name='POCEmail']").each { |email| poc_emails << email['value'] }
        poc = Nokogiri::XML::Node.new "POC", @xml_resource.doc
        poc['xmi:type'] = 'Model_Package_Description_Profile:POCType'
        poc['xmi:id'] = SecureRandom.uuid
        poc['POCName'] = poc_name
        puts "  Inlining poc with name #{poc_name}"
        poc_phone_numbers.each do |phone|
        puts "    Adding phone number #{phone}"
          poc_telephone = Nokogiri::XML::Node.new "POCTelephone", @xml_resource.doc
          poc_telephone.content = phone
          poc << poc_telephone
        end
        poc_emails.each do |email|
        puts "    Adding email #{email}"
          poc_email = Nokogiri::XML::Node.new "POCEmail", @xml_resource.doc
          poc_email.content = email
          poc << poc_email
        end
        mpd = @xml_resource.doc.xpath("//Model_Package_Description_Profile:ModelPackageDescription").first
        mpd << poc
        mpd.remove_attribute('POC')
        parent.remove
        @xml_resource.changed = true
      end
    end
  end

  def normalize_hrefs
    href_elements = @xml_resource.doc.xpath("//*[@href]")
    unless href_elements.nil?
      href_elements.each do |href_element|
        old_href = href_element['href']
        new_href = old_href.gsub("NIEM-UML-Profile\.xmi#", 'NIEM_UML_Profile#').gsub("\.xmi#", '#')
        if (old_href != new_href)
          puts "  Changing href from #{old_href} to #{new_href}"
          href_element['href'] = new_href
          @xml_resource.changed = true
        end
      end
    end
  end

  def define_type_for(tag_name)
    typed_elements = @xml_resource.doc.xpath("//#{tag_name}[@href]")
    unless typed_elements.nil?
      typed_elements.each do |typed_element|
        href = typed_element['href']
        old_type = typed_element['xmi:type']
        if href.match(/^http:\/\/www\.omg\.org\/spec\/NIEM-UML\/20120501\/XmlPrimitiveTypes/)
          new_type = "uml:PrimitiveType"
        else
          reference_matcher = href.match(/http:\/\/www\.omg\.org\/spec\/NIEM-UML\/20120501\/NIEM-Reference\/([\w-]+)(?:\.xmi)?#(.*)/)
          if reference_matcher
            resource_name, xmi_id = reference_matcher.captures
            external_resource_doc = Nokogiri::XML(File.read("#{@niem_reference_dir}#{File::SEPARATOR}#{resource_name}.uml"))
            element = external_resource_doc.xpath("//*[@xmi:id='#{xmi_id}']").first
            new_type = element['xmi:type']
          else
            puts "  Unrecognized external reference #{href}"
          end
        end
        if (old_type != new_type)
          puts "  Changing #{typed_element['xmi:id']} #{tag_name} from #{old_type} to #{new_type}"
          typed_element['xmi:type'] = new_type
          @xml_resource.changed = true
        end
      end
    end
  end
  
  def normalize_types
    ['supplier', 'type', 'general'].each do |tag_name|
      define_type_for tag_name
    end
  end
  
  def normalize_path
    old_path = @xml_resource.path
    dir = File.dirname(@xml_resource.path)
    mpd = @xml_resource.doc.xpath("//Model_Package_Description_Profile:ModelPackageDescription").first
    as_name = mpd['ASName']
    new_path = "#{dir}#{File::SEPARATOR}#{as_name}.uml"
    if(old_path != new_path)
      puts "  Changing path from #{old_path} to #{new_path}"
      @xml_resource.path = new_path
      @xml_resource.changed = true
    end
  end
  
  def normalize_header
    xmi_header = @xml_resource.doc.xpath("//xmi:XMI").first
    old_schemaLocation = xmi_header['xsi:schemaLocation']
    new_schemaLocation = 'http://www.omg.org/spec/UML/20110701 http://www.eclipse.org/uml2/4.0.0/UML http://www.omg.org/spec/NIEM-UML/20120501/NIEM_Common_Profile http://www.omg.org/spec/NIEM-UML/20120501/NIEM_UML_Profile#NIEM_UML_Profile-NIEM_Common_Profile-ePackage http://www.omg.org/spec/NIEM-UML/20120501/Model_Package_Description_Profile http://www.omg.org/spec/NIEM-UML/20120501/NIEM_UML_Profile#NIEM_UML_Profile-Model_Package_Description_Profile-ePackage http://www.omg.org/spec/NIEM-UML/20120501/NIEM_PIM_Profile http://www.omg.org/spec/NIEM-UML/20120501/NIEM_UML_Profile#NIEM_UML_Profile-NIEM_PIM_Profile-ePackage http://www.omg.org/spec/NIEM-UML/20120501/NIEM_PSM_Profile http://www.omg.org/spec/NIEM-UML/20120501/NIEM_UML_Profile#NIEM_UML_Profile-NIEM_PSM_Profile-ePackage'
    if(old_schemaLocation != new_schemaLocation)
      puts "  Changing xsi:schemaLocation from #{old_schemaLocation} to #{new_schemaLocation}"
      xmi_header['xsi:schemaLocation'] = new_schemaLocation
      @xml_resource.changed = true
    end       
  end         
      
  def remove_magicdraw_references
    exporter = @xml_resource.doc.xpath("//xmi:Documentation/xmi:exporter/text()").first
    exporterVersion = @xml_resource.doc.xpath("//xmi:Documentation/xmi:exporterVersion/text()").first
    extender = "#{exporter || 'MagicDraw UML'} #{exporterVersion || '17.0.2'}"
    ["//xmi:Extension[@extender='#{extender}']", "//*[namespace-uri()='http://www.omg.org/spec/UML/20110701/MagicDrawProfile']", "//*[namespace-uri()='http://www.magicdraw.com/schemas/Validation_Profile.xmi']", "//*[namespace-uri()='http://www.magicdraw.com/schemas/DSL_Customization.xmi']", "//*[namespace-uri()='http://www.magicdraw.com/schemas/Traceability_customization.xmi']"].each do |xpath|
      elements = @xml_resource.doc.xpath(xpath)
      unless(elements.nil?)
        elements.each do |element|
          puts "  Removing #{element.node_name}"
          element.remove
          @xml_resource.changed = true
        end
      end
    end
    
    ['//xmi:Documentation/xmi:exporter', '//xmi:Documentation/xmi:exporterVersion'].each do |element_name|
      nodes = @xml_resource.doc.xpath(element_name)
      unless nodes.nil?
        puts "  Removing parent of #{element_name}"
        nodes.each { |node| node.parent().remove; @xml_resource.changed = true }        
      end
    end
  end
  
  def normalize
    puts "Processing file #{@xml_resource.path}:"
    normalize_path
    normalize_header
    remove_magicdraw_references
    normalize_hrefs
    normalize_pocs
    normalize_types
    puts "\n"
  end
end

class XmlResourceReader  
  def read(file_name)
    XmlResource.new(file_name, Nokogiri::XML(File.read(file_name)), false)
  end
end

class XmlResourceWriter
  def write(xml_resource)
    if(xml_resource.changed)
      puts "Writing changed file #{xml_resource.path}"
      File.write(xml_resource.path, xml_resource.doc.to_xml)
    end
  end
end

xml_resource = XmlResourceReader.new().read(ARGV[0])
niem_reference_dir = ARGV[1]

Normalizer.new(xml_resource, niem_reference_dir).normalize

XmlResourceWriter.new().write(xml_resource)
