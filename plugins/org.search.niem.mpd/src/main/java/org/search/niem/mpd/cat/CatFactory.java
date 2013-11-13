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
package org.search.niem.mpd.cat;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of the
 * model. <!-- end-user-doc -->
 * 
 * @see org.search.niem.mpd.cat.CatPackage
 * @generated
 */
public interface CatFactory extends EFactory {
    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    CatFactory eINSTANCE = org.search.niem.mpd.cat.impl.CatFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Authoritative Source Type</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Authoritative Source Type</em>'.
     * @generated
     */
    AuthoritativeSourceType createAuthoritativeSourceType();

    /**
     * Returns a new object of class '<em>Catalog Type</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Catalog Type</em>'.
     * @generated
     */
    CatalogType createCatalogType();

    /**
     * Returns a new object of class '<em>Document Root</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Document Root</em>'.
     * @generated
     */
    DocumentRoot createDocumentRoot();

    /**
     * Returns a new object of class '<em>File Set Type</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>File Set Type</em>'.
     * @generated
     */
    FileSetType createFileSetType();

    /**
     * Returns a new object of class '<em>File Type</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>File Type</em>'.
     * @generated
     */
    FileType createFileType();

    /**
     * Returns a new object of class '<em>Folder Type</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Folder Type</em>'.
     * @generated
     */
    FolderType createFolderType();

    /**
     * Returns a new object of class '<em>Metadata Type</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Metadata Type</em>'.
     * @generated
     */
    MetadataType createMetadataType();

    /**
     * Returns a new object of class '<em>POC Type</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>POC Type</em>'.
     * @generated
     */
    POCType createPOCType();

    /**
     * Returns a new object of class '<em>Relationship Type</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Relationship Type</em>'.
     * @generated
     */
    RelationshipType createRelationshipType();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the package supported by this factory.
     * @generated
     */
    CatPackage getCatPackage();

} // CatFactory
