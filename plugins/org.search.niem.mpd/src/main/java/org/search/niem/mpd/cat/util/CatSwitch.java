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
package org.search.niem.mpd.cat.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.search.niem.mpd.cat.AuthoritativeSourceType;
import org.search.niem.mpd.cat.CatPackage;
import org.search.niem.mpd.cat.CatalogType;
import org.search.niem.mpd.cat.DocumentRoot;
import org.search.niem.mpd.cat.FileSetType;
import org.search.niem.mpd.cat.FileType;
import org.search.niem.mpd.cat.FolderType;
import org.search.niem.mpd.cat.MetadataType;
import org.search.niem.mpd.cat.POCType;
import org.search.niem.mpd.cat.RelationshipType;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call
 * {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the inheritance hierarchy until a non-null result is
 * returned, which is the result of the switch. <!-- end-user-doc -->
 * 
 * @see org.search.niem.mpd.cat.CatPackage
 * @generated
 */
public class CatSwitch<T> extends Switch<T> {
    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static CatPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public CatSwitch() {
        if (modelPackage == null) {
            modelPackage = CatPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @parameter ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(final EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch(final int classifierID, final EObject theEObject) {
        switch (classifierID) {
        case CatPackage.AUTHORITATIVE_SOURCE_TYPE: {
            final AuthoritativeSourceType authoritativeSourceType = (AuthoritativeSourceType) theEObject;
            T result = caseAuthoritativeSourceType(authoritativeSourceType);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case CatPackage.CATALOG_TYPE: {
            final CatalogType catalogType = (CatalogType) theEObject;
            T result = caseCatalogType(catalogType);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case CatPackage.DOCUMENT_ROOT: {
            final DocumentRoot documentRoot = (DocumentRoot) theEObject;
            T result = caseDocumentRoot(documentRoot);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case CatPackage.FILE_SET_TYPE: {
            final FileSetType fileSetType = (FileSetType) theEObject;
            T result = caseFileSetType(fileSetType);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case CatPackage.FILE_TYPE: {
            final FileType fileType = (FileType) theEObject;
            T result = caseFileType(fileType);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case CatPackage.FOLDER_TYPE: {
            final FolderType folderType = (FolderType) theEObject;
            T result = caseFolderType(folderType);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case CatPackage.METADATA_TYPE: {
            final MetadataType metadataType = (MetadataType) theEObject;
            T result = caseMetadataType(metadataType);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case CatPackage.POC_TYPE: {
            final POCType pocType = (POCType) theEObject;
            T result = casePOCType(pocType);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case CatPackage.RELATIONSHIP_TYPE: {
            final RelationshipType relationshipType = (RelationshipType) theEObject;
            T result = caseRelationshipType(relationshipType);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        default:
            return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Authoritative Source Type</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Authoritative Source Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAuthoritativeSourceType(final AuthoritativeSourceType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Catalog Type</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Catalog Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCatalogType(final CatalogType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Document Root</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Document Root</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDocumentRoot(final DocumentRoot object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>File Set Type</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>File Set Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFileSetType(final FileSetType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>File Type</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>File Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFileType(final FileType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Folder Type</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Folder Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFolderType(final FolderType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Metadata Type</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Metadata Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMetadataType(final MetadataType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>POC Type</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>POC Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePOCType(final POCType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Relationship Type</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Relationship Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRelationshipType(final RelationshipType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase(final EObject object) {
        return null;
    }

} // CatSwitch
