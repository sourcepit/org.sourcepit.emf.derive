/**
 */

package org.sourcepit.emf.derive.core.ecore.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.sourcepit.emf.derive.core.ecore.EcoreDerivationConfiguration;
import org.sourcepit.emf.derive.core.ecore.EcorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Derivation Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.sourcepit.emf.derive.core.ecore.impl.EcoreDerivationConfigurationImpl#getOrigin <em>Origin</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EcoreDerivationConfigurationImpl extends MinimalEObjectImpl.Container
   implements
      EcoreDerivationConfiguration {
   /**
    * The cached value of the '{@link #getOrigin() <em>Origin</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @see #getOrigin()
    * @generated
    * @ordered
    */
   protected EPackage origin;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   protected EcoreDerivationConfigurationImpl() {
      super();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   @Override
   protected EClass eStaticClass() {
      return EcorePackage.Literals.ECORE_DERIVATION_CONFIGURATION;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public EPackage getOrigin() {
      if (origin != null && ((EObject) origin).eIsProxy()) {
         InternalEObject oldOrigin = (InternalEObject) origin;
         origin = (EPackage) eResolveProxy(oldOrigin);
         if (origin != oldOrigin) {
            if (eNotificationRequired())
               eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                  EcorePackage.ECORE_DERIVATION_CONFIGURATION__ORIGIN, oldOrigin, origin));
         }
      }
      return origin;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public EPackage basicGetOrigin() {
      return origin;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setOrigin(EPackage newOrigin) {
      EPackage oldOrigin = origin;
      origin = newOrigin;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, EcorePackage.ECORE_DERIVATION_CONFIGURATION__ORIGIN,
            oldOrigin, origin));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   @Override
   public Object eGet(int featureID, boolean resolve, boolean coreType) {
      switch (featureID) {
         case EcorePackage.ECORE_DERIVATION_CONFIGURATION__ORIGIN :
            if (resolve)
               return getOrigin();
            return basicGetOrigin();
      }
      return super.eGet(featureID, resolve, coreType);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   @Override
   public void eSet(int featureID, Object newValue) {
      switch (featureID) {
         case EcorePackage.ECORE_DERIVATION_CONFIGURATION__ORIGIN :
            setOrigin((EPackage) newValue);
            return;
      }
      super.eSet(featureID, newValue);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   @Override
   public void eUnset(int featureID) {
      switch (featureID) {
         case EcorePackage.ECORE_DERIVATION_CONFIGURATION__ORIGIN :
            setOrigin((EPackage) null);
            return;
      }
      super.eUnset(featureID);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   @Override
   public boolean eIsSet(int featureID) {
      switch (featureID) {
         case EcorePackage.ECORE_DERIVATION_CONFIGURATION__ORIGIN :
            return origin != null;
      }
      return super.eIsSet(featureID);
   }

} // EcoreDerivationConfigurationImpl
