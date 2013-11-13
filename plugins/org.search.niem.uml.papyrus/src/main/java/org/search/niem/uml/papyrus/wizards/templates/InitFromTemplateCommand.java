/*
 * This program and the accompanying materials are made available
 * under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   SEARCH Group, Incorporated - initial API and implementation
 *
 */
package org.search.niem.uml.papyrus.wizards.templates;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableMap;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModelUtils;
import org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;
import org.search.niem.uml.papyrus.Activator;

/**
 * Modified from {@link #.eclipse.papyrus.uml.diagram.wizards.template.InitFromTemplateCommand(TransactionalEditingDomain,
 * DiResourceSet, String, String, String, String)}
 */
public class InitFromTemplateCommand extends RecordingCommand {

    private static final URI TEMPLATE_LOCATION = URI.createPlatformPluginURI("/" + Activator.PLUGIN_ID
            + "/template/template", true);
    private static final URI UML_TEMPLATE = TEMPLATE_LOCATION.appendFileExtension("uml");
    private static final URI DI_TEMPLATE = TEMPLATE_LOCATION.appendFileExtension("di");
    private static final URI NOTATION_TEMPLATE = TEMPLATE_LOCATION.appendFileExtension("notation");

    private static final Pattern parameterPattern = Pattern.compile("(\\$\\{\\w+})", Pattern.DOTALL);

    private static final Iterable<String> parameterizedStereotypeFeatures = asList("ExchangePartnerName", "targetNamespace",
            "mpdBaseURI", "descriptionText");

    private static final Iterable<? extends EStructuralFeature> parameterizedStructuralFeatures = asList(
            UMLPackage.Literals.NAMED_ELEMENT__NAME, UMLPackage.Literals.COMMENT__BODY,
            NotationPackage.Literals.DIAGRAM__NAME, EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY__VALUE);

    private final Resource uml;
    private final Resource diagram;
    private final Resource notation;

    public InitFromTemplateCommand(final ModelSet modelSet) {
        super(modelSet.getTransactionalEditingDomain());
        uml = UmlUtils.getUmlResource(modelSet);
        diagram = DiModelUtils.getDiResource(modelSet);
        notation = NotationUtils.getNotationResource(modelSet);
    }

    private void replace(final EObject e, final String featureName, final Map<String, String> context) {
        replace(e, e.eClass().getEStructuralFeature(featureName), context);
    }

    private void replace(final EObject e, final EStructuralFeature feature, final Map<String, String> context) {
        if (feature != null && feature.getEContainingClass().isInstance(e) && e.eIsSet(feature)) {
            final Object oldValue = e.eGet(feature);
            final Object newValue;
            if (feature.isMany()) {
                @SuppressWarnings("unchecked")
                final List<String> oldValues = (List<String>) oldValue;
                final List<String> newValues = new ArrayList<>(oldValues.size());
                for (final String s : oldValues) {
                    newValues.add(replace(s, context));
                }
                newValue = newValues;
            } else {
                newValue = replace((String) oldValue, context);
            }
            e.eSet(feature, newValue);
        }
    }

    private String replace(final String s, final Map<String, String> context) {
        final Matcher m = parameterPattern.matcher(s);
        final StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, context.get(m.group()));
        }
        m.appendTail(sb);
        return sb.toString();
    }

    private Map<String, String> createContext(final String modelName) {
        final Map<String, String> context = new HashMap<>();
        context.put("${exchange_partner_name}",
                Activator.INSTANCE.getString("_Template_Model_exchangePartnerName", new Object[] { modelName }));
        context.put("${model_name}", modelName);
        context.put("${author}", System.getProperty("user.name"));
        context.put("${current_date_time}", new SimpleDateFormat("M/d/yyyy h:mm a").format(new Date()));
        context.put("${title}", modelName);
        context.put("${comment}", Activator.INSTANCE.getString("_Template_Model_comment", new Object[] { modelName }));
        return unmodifiableMap(context);
    }

    private void replaceVariables(final Collection<EObject> eObjects, final String modelName) {
        final TreeIterator<Object> contents = EcoreUtil.getAllProperContents(eObjects, true);
        final Map<String, String> context = createContext(modelName);
        while (contents.hasNext()) {
            final Object next = contents.next();
            if (next instanceof DynamicEObjectImpl) {
                for (final String feature : parameterizedStereotypeFeatures) {
                    replace((EObject) next, feature, context);
                }
            } else if (next instanceof EObject) {
                for (final EStructuralFeature feature : parameterizedStructuralFeatures) {
                    replace((EObject) next, feature, context);
                }
            }
        }
    }

    @Override
    protected void doExecute() {
        final ResourceSet resourceSet = UMLResourcesUtil.init(new ResourceSetImpl());

        final Resource templateUmlResource = resourceSet.getResource(UML_TEMPLATE, true);
        final Resource templateDiResource = resourceSet.getResource(DI_TEMPLATE, true);
        final Resource templateNotationResource = resourceSet.getResource(NOTATION_TEMPLATE, true);

        List<EObject> toCopy = new ArrayList<EObject>();
        toCopy = templateUmlResource.getContents();
        EcoreUtil.resolveAll(resourceSet);
        toCopy.addAll(templateNotationResource.getContents());
        toCopy.addAll(templateDiResource.getContents());

        final List<EObject> copies = new ArrayList<EObject>(EcoreUtil.copyAll(toCopy));

        replaceVariables(copies, uml.getURI().trimFileExtension().lastSegment());

        final Collection<Diagram> diagrams = EcoreUtil.<Diagram> getObjectsByType(copies, NotationPackage.Literals.DIAGRAM);
        final Collection<SashWindowsMngr> sashWindowsMngrs = EcoreUtil.<SashWindowsMngr> getObjectsByType(copies,
                DiPackage.Literals.SASH_WINDOWS_MNGR);
        copies.removeAll(diagrams);
        copies.removeAll(sashWindowsMngrs);

        uml.getContents().clear();
        diagram.getContents().clear();
        notation.getContents().clear();

        uml.getContents().addAll(copies);
        diagram.getContents().addAll(sashWindowsMngrs);
        notation.getContents().addAll(diagrams);
    }
}
