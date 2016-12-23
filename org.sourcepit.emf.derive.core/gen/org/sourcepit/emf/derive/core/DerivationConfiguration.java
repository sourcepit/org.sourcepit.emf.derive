/**
 */

package org.sourcepit.emf.derive.core;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Derivation Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.sourcepit.emf.derive.core.DerivationConfiguration#getOrigin <em>Origin</em>}</li>
 * </ul>
 *
 * @see org.sourcepit.emf.derive.core.DerivePackage#getDerivationConfiguration()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface DerivationConfiguration<T> extends EObject {
   /**
    * Returns the value of the '<em><b>Origin</b></em>' reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Origin</em>' reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Origin</em>' reference.
    * @see #setOrigin(Object)
    * @see org.sourcepit.emf.derive.core.DerivePackage#getDerivationConfiguration_Origin()
    * @model kind="reference" required="true"
    * @generated
    */
   T getOrigin();

   /**
    * Sets the value of the '{@link org.sourcepit.emf.derive.core.DerivationConfiguration#getOrigin <em>Origin</em>}'
    * reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @param value the new value of the '<em>Origin</em>' reference.
    * @see #getOrigin()
    * @generated
    */
   void setOrigin(T value);

} // DerivationConfiguration
