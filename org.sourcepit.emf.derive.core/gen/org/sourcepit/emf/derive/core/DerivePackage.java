/**
 */

package org.sourcepit.emf.derive.core;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.sourcepit.emf.derive.core.DeriveFactory
 * @model kind="package"
 * @generated
 */
public interface DerivePackage extends EPackage {
   /**
    * The package name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   String eNAME = "derive";

   /**
    * The package namespace URI.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   String eNS_URI = "http://www.sourcepit.org/emf/derive/1.0";

   /**
    * The package namespace name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   String eNS_PREFIX = "derive";

   /**
    * The singleton instance of the package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   DerivePackage eINSTANCE = org.sourcepit.emf.derive.core.impl.DerivePackageImpl.init();

   /**
    * The meta object id for the '{@link org.sourcepit.emf.derive.core.DerivationConfiguration <em>Derivation
    * Configuration</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see org.sourcepit.emf.derive.core.DerivationConfiguration
    * @see org.sourcepit.emf.derive.core.impl.DerivePackageImpl#getDerivationConfiguration()
    * @generated
    */
   int DERIVATION_CONFIGURATION = 0;

   /**
    * The feature id for the '<em><b>Origin</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int DERIVATION_CONFIGURATION__ORIGIN = 0;

   /**
    * The number of structural features of the '<em>Derivation Configuration</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int DERIVATION_CONFIGURATION_FEATURE_COUNT = 1;

   /**
    * The number of operations of the '<em>Derivation Configuration</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int DERIVATION_CONFIGURATION_OPERATION_COUNT = 0;


   /**
    * Returns the meta object for class '{@link org.sourcepit.emf.derive.core.DerivationConfiguration <em>Derivation
    * Configuration</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for class '<em>Derivation Configuration</em>'.
    * @see org.sourcepit.emf.derive.core.DerivationConfiguration
    * @generated
    */
   EClass getDerivationConfiguration();

   /**
    * Returns the meta object for the reference '{@link org.sourcepit.emf.derive.core.DerivationConfiguration#getOrigin
    * <em>Origin</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for the reference '<em>Origin</em>'.
    * @see org.sourcepit.emf.derive.core.DerivationConfiguration#getOrigin()
    * @see #getDerivationConfiguration()
    * @generated
    */
   EReference getDerivationConfiguration_Origin();

   /**
    * Returns the factory that creates the instances of the model.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the factory that creates the instances of the model.
    * @generated
    */
   DeriveFactory getDeriveFactory();

   /**
    * <!-- begin-user-doc -->
    * Defines literals for the meta objects that represent
    * <ul>
    * <li>each class,</li>
    * <li>each feature of each class,</li>
    * <li>each operation of each class,</li>
    * <li>each enum,</li>
    * <li>and each data type</li>
    * </ul>
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   interface Literals {
      /**
       * The meta object literal for the '{@link org.sourcepit.emf.derive.core.DerivationConfiguration <em>Derivation
       * Configuration</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @see org.sourcepit.emf.derive.core.DerivationConfiguration
       * @see org.sourcepit.emf.derive.core.impl.DerivePackageImpl#getDerivationConfiguration()
       * @generated
       */
      EClass DERIVATION_CONFIGURATION = eINSTANCE.getDerivationConfiguration();

      /**
       * The meta object literal for the '<em><b>Origin</b></em>' reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @generated
       */
      EReference DERIVATION_CONFIGURATION__ORIGIN = eINSTANCE.getDerivationConfiguration_Origin();

   }

} // DerivePackage
