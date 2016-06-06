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
package org.eclipse.emf.diffmerge.bridge.mapping.impl;

import org.eclipse.emf.diffmerge.bridge.api.ISymbolFunction;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IQuery;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IRule;


/**
 * A base implementation of IRule.
 * @param <S> the type of source data
 * @param <T> the type of target data
 * @see IRule
 * @author Olivier Constant
 */
public abstract class Rule<S, T>
implements IRule<S, T> {
  
  /** The non-null identifier of the rule */
  private final RuleIdentifier<S, T> _identifier;
  
  /** The non-null query providing input data */
  private IQuery<?, ? extends S> _query;
  
  
  /**
   * Default constructor for a randomly generated ID
   * @param provider_p a non-null input provider
   */
  public Rule(IQuery<?, ? extends S> provider_p) {
    this(provider_p, new RuleIdentifier<S, T>());
  }
  
  /**
   * Constructor
   * @param provider_p a non-null input provider
   * @param id_p the non-null identifier of the rule
   */
  public Rule(IQuery<?, ? extends S> provider_p, String id_p) {
    this(provider_p, new RuleIdentifier<S, T>(id_p));
  }
  
  /**
   * Constructor
   * @param provider_p a non-null input provider
   * @param id_p the non-null identifier of the rule
   */
  public Rule(IQuery<?, ? extends S> provider_p, RuleIdentifier<S, T> id_p) {
    _query = provider_p;
    _query.accept(this);
    _identifier = id_p;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.bridge.api.IIdentifiedWithType#getID()
   */
  public RuleIdentifier<S, T> getID() {
    return _identifier;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.bridge.mapping.api.IRule#getInputProvider()
   */
  public IQuery<?, ? extends S> getInputProvider() {
    return _query;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.bridge.api.ISymbolProvider#getSymbol(org.eclipse.emf.diffmerge.bridge.api.ISymbolFunction)
   */
  public Object getSymbol(ISymbolFunction function_p) {
    return function_p.getSymbol(getID());
  }
  
}