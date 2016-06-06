/**
 * <copyright>
 * 
 * Copyright (c) 2015 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.emf.diffmerge.bridge.examples.apa.impl;

import org.eclipse.emf.diffmerge.bridge.examples.apa.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ApaFactoryImpl extends EFactoryImpl implements ApaFactory {
	/**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static ApaFactory init() {
    try {
      ApaFactory theApaFactory = (ApaFactory)EPackage.Registry.INSTANCE.getEFactory(ApaPackage.eNS_URI);
      if (theApaFactory != null) {
        return theApaFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ApaFactoryImpl();
  }

	/**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ApaFactoryImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
      case ApaPackage.ASCOPE: return createAScope();
      case ApaPackage.ANODE: return createANode();
      case ApaPackage.ABEHAVIOR: return createABehavior();
      case ApaPackage.AFUNCTION: return createAFunction();
      case ApaPackage.AEXCHANGE: return createAExchange();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public AScope createAScope() {
    AScopeImpl aScope = new AScopeImpl();
    return aScope;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ANode createANode() {
    ANodeImpl aNode = new ANodeImpl();
    return aNode;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ABehavior createABehavior() {
    ABehaviorImpl aBehavior = new ABehaviorImpl();
    return aBehavior;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public AFunction createAFunction() {
    AFunctionImpl aFunction = new AFunctionImpl();
    return aFunction;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public AExchange createAExchange() {
    AExchangeImpl aExchange = new AExchangeImpl();
    return aExchange;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ApaPackage getApaPackage() {
    return (ApaPackage)getEPackage();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
	@Deprecated
	public static ApaPackage getPackage() {
    return ApaPackage.eINSTANCE;
  }

} //ApaFactoryImpl