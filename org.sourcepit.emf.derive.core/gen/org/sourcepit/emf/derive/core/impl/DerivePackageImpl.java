/**
 */

package org.sourcepit.emf.derive.core.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.sourcepit.emf.derive.core.DerivationConfiguration;
import org.sourcepit.emf.derive.core.DeriveFactory;
import org.sourcepit.emf.derive.core.DerivePackage;
import org.sourcepit.emf.derive.core.ecore.EcorePackage;
import org.sourcepit.emf.derive.core.ecore.impl.EcorePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class DerivePackageImpl extends EPackageImpl implements DerivePackage {
   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   private EClass derivationConfigurationEClass = null;

   /**
    * Creates an instance of the model <b>Package</b>, registered with
    * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
    * package URI value.
    * <p>
    * Note: the correct way to create the package is via the static
    * factory method {@link #init init()}, which also performs
    * initialization of the package, or returns the registered package,
    * if one already exists.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see org.eclipse.emf.ecore.EPackage.Registry
    * @see org.sourcepit.emf.derive.core.DerivePackage#eNS_URI
    * @see #init()
    * @generated
    */
   private DerivePackageImpl() {
      super(eNS_URI, DeriveFactory.eINSTANCE);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   private static boolean isInited = false;

   /**
    * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
    * 
    * <p>
    * This method is used to initialize {@link DerivePackage#eINSTANCE} when that field is accessed.
    * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see #eNS_URI
    * @see #createPackageContents()
    * @see #initializePackageContents()
    * @generated
    */
   public static DerivePackage init() {
      if (isInited)
         return (DerivePackage) EPackage.Registry.INSTANCE.getEPackage(DerivePackage.eNS_URI);

      // Obtain or create and register package
      DerivePackageImpl theDerivePackage = (DerivePackageImpl) (EPackage.Registry.INSTANCE
         .get(eNS_URI) instanceof DerivePackageImpl
            ? EPackage.Registry.INSTANCE.get(eNS_URI)
            : new DerivePackageImpl());

      isInited = true;

      // Obtain or create and register interdependencies
      EcorePackageImpl theEcorePackage = (EcorePackageImpl) (EPackage.Registry.INSTANCE
         .getEPackage(EcorePackage.eNS_URI) instanceof EcorePackageImpl
            ? EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI)
            : EcorePackage.eINSTANCE);

      // Create package meta-data objects
      theDerivePackage.createPackageContents();
      theEcorePackage.createPackageContents();

      // Initialize created meta-data
      theDerivePackage.initializePackageContents();
      theEcorePackage.initializePackageContents();

      // Mark meta-data to indicate it can't be changed
      theDerivePackage.freeze();


      // Update the registry and return the package
      EPackage.Registry.INSTANCE.put(DerivePackage.eNS_URI, theDerivePackage);
      return theDerivePackage;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public EClass getDerivationConfiguration() {
      return derivationConfigurationEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public EReference getDerivationConfiguration_Origin() {
      return (EReference) derivationConfigurationEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public DeriveFactory getDeriveFactory() {
      return (DeriveFactory) getEFactoryInstance();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   private boolean isCreated = false;

   /**
    * Creates the meta-model objects for the package. This method is
    * guarded to have no affect on any invocation but its first.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public void createPackageContents() {
      if (isCreated)
         return;
      isCreated = true;

      // Create classes and their features
      derivationConfigurationEClass = createEClass(DERIVATION_CONFIGURATION);
      createEReference(derivationConfigurationEClass, DERIVATION_CONFIGURATION__ORIGIN);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   private boolean isInitialized = false;

   /**
    * Complete the initialization of the package and its meta-model. This
    * method is guarded to have no affect on any invocation but its first.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public void initializePackageContents() {
      if (isInitialized)
         return;
      isInitialized = true;

      // Initialize package
      setName(eNAME);
      setNsPrefix(eNS_PREFIX);
      setNsURI(eNS_URI);

      // Obtain other dependent packages
      EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

      // Add subpackages
      getESubpackages().add(theEcorePackage);

      // Create type parameters
      ETypeParameter derivationConfigurationEClass_T = addETypeParameter(derivationConfigurationEClass, "T");

      // Set bounds for type parameters

      // Add supertypes to classes

      // Initialize classes, features, and operations; add parameters
      initEClass(derivationConfigurationEClass, DerivationConfiguration.class, "DerivationConfiguration", IS_ABSTRACT,
         IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      EGenericType g1 = createEGenericType(derivationConfigurationEClass_T);
      initEReference(getDerivationConfiguration_Origin(), g1, null, "origin", null, 1, 1, DerivationConfiguration.class,
         !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
         !IS_DERIVED, IS_ORDERED);

      // Create resource
      createResource(eNS_URI);
   }

} // DerivePackageImpl
