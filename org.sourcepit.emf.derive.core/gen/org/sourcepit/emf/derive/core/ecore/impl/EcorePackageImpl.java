/**
 */

package org.sourcepit.emf.derive.core.ecore.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.sourcepit.emf.derive.core.DerivePackage;
import org.sourcepit.emf.derive.core.ecore.EcoreDerivationConfiguration;
import org.sourcepit.emf.derive.core.ecore.EcoreFactory;
import org.sourcepit.emf.derive.core.ecore.EcorePackage;
import org.sourcepit.emf.derive.core.impl.DerivePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class EcorePackageImpl extends EPackageImpl implements EcorePackage {
   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   private EClass ecoreDerivationConfigurationEClass = null;

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
    * @see org.sourcepit.emf.derive.core.ecore.EcorePackage#eNS_URI
    * @see #init()
    * @generated
    */
   private EcorePackageImpl() {
      super(eNS_URI, EcoreFactory.eINSTANCE);
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
    * This method is used to initialize {@link EcorePackage#eINSTANCE} when that field is accessed.
    * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see #eNS_URI
    * @see #createPackageContents()
    * @see #initializePackageContents()
    * @generated
    */
   public static EcorePackage init() {
      if (isInited)
         return (EcorePackage) EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

      // Obtain or create and register package
      EcorePackageImpl theEcorePackage = (EcorePackageImpl) (EPackage.Registry.INSTANCE
         .get(eNS_URI) instanceof EcorePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EcorePackageImpl());

      isInited = true;

      // Obtain or create and register interdependencies
      DerivePackageImpl theDerivePackage = (DerivePackageImpl) (EPackage.Registry.INSTANCE
         .getEPackage(DerivePackage.eNS_URI) instanceof DerivePackageImpl
            ? EPackage.Registry.INSTANCE.getEPackage(DerivePackage.eNS_URI)
            : DerivePackage.eINSTANCE);

      // Create package meta-data objects
      theEcorePackage.createPackageContents();
      theDerivePackage.createPackageContents();

      // Initialize created meta-data
      theEcorePackage.initializePackageContents();
      theDerivePackage.initializePackageContents();

      // Mark meta-data to indicate it can't be changed
      theEcorePackage.freeze();


      // Update the registry and return the package
      EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, theEcorePackage);
      return theEcorePackage;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public EClass getEcoreDerivationConfiguration() {
      return ecoreDerivationConfigurationEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public EcoreFactory getEcoreFactory() {
      return (EcoreFactory) getEFactoryInstance();
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
      ecoreDerivationConfigurationEClass = createEClass(ECORE_DERIVATION_CONFIGURATION);
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
      DerivePackage theDerivePackage = (DerivePackage) EPackage.Registry.INSTANCE.getEPackage(DerivePackage.eNS_URI);

      // Create type parameters

      // Set bounds for type parameters

      // Add supertypes to classes
      EGenericType g1 = createEGenericType(theDerivePackage.getDerivationConfiguration());
      EGenericType g2 = createEGenericType(ecorePackage.getEPackage());
      g1.getETypeArguments().add(g2);
      ecoreDerivationConfigurationEClass.getEGenericSuperTypes().add(g1);

      // Initialize classes, features, and operations; add parameters
      initEClass(ecoreDerivationConfigurationEClass, EcoreDerivationConfiguration.class, "EcoreDerivationConfiguration",
         !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
   }

} // EcorePackageImpl
