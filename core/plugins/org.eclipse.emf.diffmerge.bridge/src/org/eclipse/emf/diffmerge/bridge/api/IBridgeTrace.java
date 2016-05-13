/**
 * <copyright>
 * 
 * Copyright (c) 2014-2016 Thales Global Services S.A.S.
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
package org.eclipse.emf.diffmerge.bridge.api;


/**
 * A trace model that, for every target data element, identifies the cause of its presence.
 * @author Olivier Constant
 */
public interface IBridgeTrace {
  
  /**
   * Return an object that uniquely identifies the cause of the presence
   * of the given target data element. The cause may be an ICause or
   * an abstract/simplified variant.
   * @param target_p a potentially null object
   * @return a potentially null object
   */
  Object getCause(Object target_p);
  
  
  /**
   * A bridge trace that can be modified.
   */
  interface Editable extends IBridgeTrace {
    /**
     * Register the given cause as the cause of the presence of the given target data element.
     * The cause may be an ICause or an abstract/simplified variant.
     * @param cause_p a non-null object
     * @param target_p a non-null object
     * @return a potentially null object which was previously registered as cause
     */
    Object putCause(Object cause_p, Object target_p);
    
    /**
     * Remove trace information related to the given target data element and return the cause
     * that was previously registered for it, if any.
     * The cause may be an ICause or an abstract/simplified variant.
     * @param target_p a non-null object
     * @return a potentially null object
     */
    Object removeTarget(Object target_p);
  }
  
}
