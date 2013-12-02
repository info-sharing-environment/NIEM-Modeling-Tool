#!/usr/bin/ruby

require 'nokogiri'

XmlResource = Struct.new(:path, :doc, :changed)

class Normalizer

  def initialize(xml_resources)
    @xml_resources = xml_resources
  end

  def define_type_for(tag_name, xml_resource)
    typed_elements = xml_resource.doc.xpath("//#{tag_name}[@href]")
    unless typed_elements.nil?
      typed_elements.each do |typed_element|
        href = typed_element['href']
        old_type = typed_element['xmi:type']
        if href.match(/^http:\/\/www\.omg\.org\/spec\/NIEM-UML\/20120501\/XmlPrimitiveTypes#XMLPrimitiveTypes/)
          new_type = "uml:PrimitiveType"
        else
          resource_name, xmi_id = href.match(/http:\/\/www\.omg\.org\/spec\/NIEM-UML\/20120501\/NIEM-Reference\/(.*)#(.*)/).captures
          element = @xml_resources[resource_name].doc.xpath("//*[@xmi:id='#{xmi_id}']").first
          new_type = element['xmi:type']
        end
        if(old_type != new_type)
          puts "  Changing #{typed_element['xmi:id']} #{tag_name} from #{old_type} to #{new_type}"
          typed_element['xmi:type'] = new_type
          xml_resource.changed = true
        end
      end
    end
  end
  
  def normalize_types(xml_resource)
    ['supplier', 'type', 'general'].each do |tag_name|
      define_type_for(tag_name, xml_resource)
    end
  end
  
  def normalize_path(xml_resource)
    old_path = xml_resource.path
    new_path = xml_resource.path.gsub(/\.xmi$/, '.uml')
    if(old_path != new_path)
      puts "  Changing path from #{old_path} to #{new_path}"
      xml_resource.path = new_path
      xml_resource.changed = true
    end
  end
  
  def normalize_header(xml_resource)
    xmi_header = xml_resource.doc.xpath("//xmi:XMI").first
    old_schemaLocation = xmi_header['xsi:schemaLocation']
    new_schemaLocation = 'http://www.omg.org/spec/UML/20110701 http://www.eclipse.org/uml2/4.0.0/UML http://www.omg.org/spec/NIEM-UML/20120501/NIEM_Common_Profile http://www.omg.org/spec/NIEM-UML/20120501/NIEM_UML_Profile#NIEM_UML_Profile-NIEM_Common_Profile-ePackage http://www.omg.org/spec/NIEM-UML/20120501/Model_Package_Description_Profile http://www.omg.org/spec/NIEM-UML/20120501/NIEM_UML_Profile#NIEM_UML_Profile-Model_Package_Description_Profile-ePackage http://www.omg.org/spec/NIEM-UML/20120501/NIEM_PIM_Profile http://www.omg.org/spec/NIEM-UML/20120501/NIEM_UML_Profile#NIEM_UML_Profile-NIEM_PIM_Profile-ePackage http://www.omg.org/spec/NIEM-UML/20120501/NIEM_PSM_Profile http://www.omg.org/spec/NIEM-UML/20120501/NIEM_UML_Profile#NIEM_UML_Profile-NIEM_PSM_Profile-ePackage'
    if(old_schemaLocation != new_schemaLocation)
      puts "  Changing xsi:schemaLocation from #{old_schemaLocation} to #{new_schemaLocation}"
      xmi_header['xsi:schemaLocation'] = new_schemaLocation
      xml_resource.changed = true
    end
  end
    
  def normalize
    @xml_resources.each do |resource_name, xml_resource|
      puts "Processing file #{resource_name}:"
      normalize_path(xml_resource)
      normalize_header(xml_resource)
      normalize_types(xml_resource)
      puts "\n"
    end
  end
end

class XmlResourceReader  
  def read(file_names)
    file_names.inject({}) do |memo, file|
      resource_name = File.basename(file, File.extname(file))
      xml_resource = XmlResource.new(file, Nokogiri::XML(File.read(file)), false)
      memo[resource_name] = xml_resource
      memo
    end
  end
end

class XmlResourceWriter
  def write(xml_resources)
    xml_resources.each do |resource_name, xml_resource|
      if(xml_resource.changed)
        puts "Writing changed file #{xml_resource.path}"
        File.write(xml_resource.path, xml_resource.doc.to_xml)
      end
    end
  end
end


xml_resources = XmlResourceReader.new().read(ARGV)

Normalizer.new(xml_resources).normalize

XmlResourceWriter.new().write(xml_resources)
