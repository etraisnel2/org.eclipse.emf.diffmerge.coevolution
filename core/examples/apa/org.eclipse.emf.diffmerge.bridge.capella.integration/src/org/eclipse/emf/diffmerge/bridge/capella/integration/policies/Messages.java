/*******************************************************************************
 * Copyright (c) 2006, 2015 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.diffmerge.bridge.capella.integration.policies;

import org.eclipse.osgi.util.NLS;


/**
 * Message management.
 */
@SuppressWarnings("javadoc")
public class Messages extends NLS {
  private static final String BUNDLE_NAME = "org.eclipse.emf.diffmerge.bridge.capella.integration.policies.messages"; //$NON-NLS-1$

  public static String ConfigurableMatchPolicy_Semantics_DefaultContents_Description;
  public static String ConfigurableMatchPolicy_Semantics_DefaultContents_Name;
  public static String ConfigurableMatchPolicy_Structure_Children_Description;
  public static String ConfigurableMatchPolicy_Structure_Children_Name;
  public static String ConfigurableMatchPolicy_Structure_Roots_Description;
  public static String ConfigurableMatchPolicy_Structure_Roots_Name;
  public static String ConfigurableMatchPolicy_Structure_UniqueChildren_Description;
  public static String ConfigurableMatchPolicy_Structure_UniqueChildren_Name;
  public static String DecoratedCapellaComparisonMethodFactory_TechnicalElements_Name;
  public static String DecoratedCapellaComparisonMethodFactory_TechnicalElements_Description;
  public static String DecoratedCapellaComparisonMethodFactory_Links_Name;
  public static String DecoratedCapellaComparisonMethodFactory_Links_Description;
  
  static {
    // initialize resource bundle
    NLS.initializeMessages(BUNDLE_NAME, Messages.class);
  }
  
  /**
   * Constructor
   */
  private Messages() {
    // Nothing needed
  }
}