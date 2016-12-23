/**
 */

package org.sourcepit.emf.derive.core.ecore;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.sourcepit.emf.derive.core.DerivePackage;

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
 * @see org.sourcepit.emf.derive.core.ecore.EcoreFactory
 * @model kind="package"
 * @generated
 */
public interface EcorePackage extends EPackage {
   /**
    * The package name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   String eNAME = "ecore";

   /**
    * The package namespace URI.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   String eNS_URI = "http://www.sourcepit.org/emf/derive/ecore/1.0";

   /**
    * The package namespace name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   String eNS_PREFIX = "ecore";

   /**
    * The singleton instance of the package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   EcorePackage eINSTANCE = org.sourcepit.emf.derive.core.ecore.impl.EcorePackageImpl.init();

   /**
    * The meta object id for the '{@link org.sourcepit.emf.derive.core.ecore.impl.EcoreDerivationConfigurationImpl
    * <em>Derivation Configuration</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see org.sourcepit.emf.derive.core.ecore.impl.EcoreDerivationConfigurationImpl
    * @see org.sourcepit.emf.derive.core.ecore.impl.EcorePackageImpl#getEcoreDerivationConfiguration()
    * @generated
    */
   int ECORE_DERIVATION_CONFIGURATION = 0;

   /**
    * The feature id for the '<em><b>Origin</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int ECORE_DERIVATION_CONFIGURATION__ORIGIN = DerivePackage.DERIVATION_CONFIGURATION__ORIGIN;

   /**
    * The number of structural features of the '<em>Derivation Configuration</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int ECORE_DERIVATION_CONFIGURATION_FEATURE_COUNT = DerivePackage.DERIVATION_CONFIGURATION_FEATURE_COUNT + 0;

   /**
    * The number of operations of the '<em>Derivation Configuration</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    * @ordered
    */
   int ECORE_DERIVATION_CONFIGURATION_OPERATION_COUNT = DerivePackage.DERIVATION_CONFIGURATION_OPERATION_COUNT + 0;


   /**
    * Returns the meta object for class '{@link org.sourcepit.emf.derive.core.ecore.EcoreDerivationConfiguration
    * <em>Derivation Configuration</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the meta object for class '<em>Derivation Configuration</em>'.
    * @see org.sourcepit.emf.derive.core.ecore.EcoreDerivationConfiguration
    * @generated
    */
   EClass getEcoreDerivationConfiguration();

   /**
    * Returns the factory that creates the instances of the model.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @return the factory that creates the instances of the model.
    * @generated
    */
   EcoreFactory getEcoreFactory();

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
       * The meta object literal for the
       * '{@link org.sourcepit.emf.derive.core.ecore.impl.EcoreDerivationConfigurationImpl <em>Derivation
       * Configuration</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * 
       * @see org.sourcepit.emf.derive.core.ecore.impl.EcoreDerivationConfigurationImpl
       * @see org.sourcepit.emf.derive.core.ecore.impl.EcorePackageImpl#getEcoreDerivationConfiguration()
       * @generated
       */
      EClass ECORE_DERIVATION_CONFIGURATION = eINSTANCE.getEcoreDerivationConfiguration();

   }

} // EcorePackage
