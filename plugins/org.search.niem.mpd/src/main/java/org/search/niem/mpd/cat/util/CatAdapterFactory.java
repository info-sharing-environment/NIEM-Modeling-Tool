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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
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
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code> method for
 * each class of the model. <!-- end-user-doc -->
 * 
 * @see org.search.niem.mpd.cat.CatPackage
 * @generated
 */
public class CatAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static CatPackage modelPackage;

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public CatAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = CatPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object. <!-- begin-user-doc --> This implementation
     * returns <code>true</code> if the object is either the model's package or is an instance object of the model. <!--
     * end-user-doc -->
     * 
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(final Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject) object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected CatSwitch<Adapter> modelSwitch = new CatSwitch<Adapter>() {
        @Override
        public Adapter caseAuthoritativeSourceType(final AuthoritativeSourceType object) {
            return createAuthoritativeSourceTypeAdapter();
        }

        @Override
        public Adapter caseCatalogType(final CatalogType object) {
            return createCatalogTypeAdapter();
        }

        @Override
        public Adapter caseDocumentRoot(final DocumentRoot object) {
            return createDocumentRootAdapter();
        }

        @Override
        public Adapter caseFileSetType(final FileSetType object) {
            return createFileSetTypeAdapter();
        }

        @Override
        public Adapter caseFileType(final FileType object) {
            return createFileTypeAdapter();
        }

        @Override
        public Adapter caseFolderType(final FolderType object) {
            return createFolderTypeAdapter();
        }

        @Override
        public Adapter caseMetadataType(final MetadataType object) {
            return createMetadataTypeAdapter();
        }

        @Override
        public Adapter casePOCType(final POCType object) {
            return createPOCTypeAdapter();
        }

        @Override
        public Adapter caseRelationshipType(final RelationshipType object) {
            return createRelationshipTypeAdapter();
        }

        @Override
        public Adapter defaultCase(final EObject object) {
            return createEObjectAdapter();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param target
     *            the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(final Notifier target) {
        return modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class '{@link org.search.niem.mpd.cat.AuthoritativeSourceType
     * <em>Authoritative Source Type</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can
     * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
     * -->
     * 
     * @return the new adapter.
     * @see org.search.niem.mpd.cat.AuthoritativeSourceType
     * @generated
     */
    public Adapter createAuthoritativeSourceTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.search.niem.mpd.cat.CatalogType <em>Catalog Type</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to ignore
     * a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.search.niem.mpd.cat.CatalogType
     * @generated
     */
    public Adapter createCatalogTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.search.niem.mpd.cat.DocumentRoot <em>Document Root</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.search.niem.mpd.cat.DocumentRoot
     * @generated
     */
    public Adapter createDocumentRootAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.search.niem.mpd.cat.FileSetType <em>File Set Type</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.search.niem.mpd.cat.FileSetType
     * @generated
     */
    public Adapter createFileSetTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.search.niem.mpd.cat.FileType <em>File Type</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to ignore
     * a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.search.niem.mpd.cat.FileType
     * @generated
     */
    public Adapter createFileTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.search.niem.mpd.cat.FolderType <em>Folder Type</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to ignore
     * a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.search.niem.mpd.cat.FolderType
     * @generated
     */
    public Adapter createFolderTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.search.niem.mpd.cat.MetadataType <em>Metadata Type</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.search.niem.mpd.cat.MetadataType
     * @generated
     */
    public Adapter createMetadataTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.search.niem.mpd.cat.POCType <em>POC Type</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to ignore
     * a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.search.niem.mpd.cat.POCType
     * @generated
     */
    public Adapter createPOCTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.search.niem.mpd.cat.RelationshipType
     * <em>Relationship Type</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
     * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.search.niem.mpd.cat.RelationshipType
     * @generated
     */
    public Adapter createRelationshipTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case. <!-- begin-user-doc --> This default implementation returns null. <!--
     * end-user-doc -->
     * 
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} // CatAdapterFactory
