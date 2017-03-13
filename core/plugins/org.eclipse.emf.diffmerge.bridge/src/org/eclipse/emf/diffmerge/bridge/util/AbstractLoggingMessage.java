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
package org.eclipse.emf.diffmerge.bridge.util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * An abstract logging message with default formatting
 */
public abstract class AbstractLoggingMessage {
  
  /**
   * An internal mapping from objects to their labels
   */
  private LinkedHashMap<Object, String> _objectToLabel = new LinkedHashMap<Object, String>();
  
  /**
   * Default constructor
   * 
   * @param object_p (non-null) the object to be serialized
   */
  protected AbstractLoggingMessage(Object object_p) {
    // by default map object to its default serialization unless a label
    // provider is used through mapObjectToLabel(object, label)
    _objectToLabel.put(object_p, object_p.toString());
  }

  /**
   * Returns the logging message prefix
   * 
   * @return (non-null) possibly empty string
   */
  protected abstract String getPrefix();

  /**
   * Returns the logging message additional info as suffix
   * 
   * @return (non-null) possibly empty string
   */
  protected abstract String getAdditionalInfo();
  
  /**
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return getPrefix() + getMessageBody() + getAdditionalInfo();
  }

  /**
   * Returns the message boy, this is where objects are serialized.
   * 
   * @return the (non-null) message body
   */
  protected abstract String getMessageBody();

  /**
   * Returns the object to label map
   * 
   * @return the (non-null) object to label map
   */
  protected Map<Object, String> getObjectToLabel() {
    return _objectToLabel;
  }
  
  /**
   * Maps an object to a label
   * 
   * @param object_p the (non-null) object to map
   * @param objectLabel_p the (non-null) object label
   */
  public void mapObjectToLabel(Object object_p, String objectLabel_p) {
    _objectToLabel.put(object_p, objectLabel_p);
  }
  
  /**
   * Returns the label mapped to the object given as input
   * 
   * @param object_p the (non-null) object
   * @return the (non-null) source label
   */
  protected String getObjectLabel(Object object_p) {
    if(_objectToLabel.containsKey(object_p))
        return _objectToLabel.get(object_p);
    return object_p.toString();
  }
}