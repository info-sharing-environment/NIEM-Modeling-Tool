org.search.niem.uml.papyrus.textedit.property.xtext.ui
========================================================================

Make sure to configure this project for Xtext after import in the generated .project file:

<code lang="xml">
<?xml version="1.0" encoding="UTF-8"?>
&lt;projectDescription&gt;
    ....
    &lt;buildSpec&gt;
        ....
        &lt;buildCommand&gt;
            &lt;name&gt;org.eclipse.xtext.ui.shared.xtextBuilder&lt;/name&gt;
            &lt;arguments&gt;
            &lt;/arguments&gt;
        &lt;/buildCommand&gt;
    &lt;/buildSpec&gt;
    &lt;natures&gt;
        ....
        &lt;nature&gt;org.eclipse.xtext.ui.shared.xtextNature&lt;/nature&gt;
    &lt;/natures&gt;
&lt;/projectDescription&gt;
</code>
