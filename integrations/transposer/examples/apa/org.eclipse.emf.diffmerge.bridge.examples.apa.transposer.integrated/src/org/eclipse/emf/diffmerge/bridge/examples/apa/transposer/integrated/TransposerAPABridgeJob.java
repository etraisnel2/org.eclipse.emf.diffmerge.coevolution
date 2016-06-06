/**
 * <copyright>
 * 
 * Copyright (c) 2014 Thales Global Services S.A.S.
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
package org.eclipse.emf.diffmerge.bridge.examples.apa.transposer.integrated;

import org.eclipse.emf.diffmerge.api.scopes.IEditableModelScope;
import org.eclipse.emf.diffmerge.bridge.examples.apa.ApaPackage;
import org.eclipse.emf.diffmerge.bridge.integration.transposer.TransposerBridge;
import org.eclipse.emf.diffmerge.bridge.interactive.BridgeJob;
import org.eclipse.emf.diffmerge.bridge.interactive.EMFInteractiveBridge;
import org.eclipse.emf.diffmerge.impl.policies.ConfigurableDiffPolicy;
import org.polarsys.capella.core.data.pa.PhysicalArchitecture;


/**
 * A variant of TransposerAPABridgeJob based on a Transposer mapping.
 * @author Olivier Constant
 */
public class TransposerAPABridgeJob extends BridgeJob<PhysicalArchitecture> {
  
	/**
	 * Constructor
	 * @param context_p a non-null physical architecture
	 */
	public TransposerAPABridgeJob(PhysicalArchitecture context_p) {
	  super("Capella2APA", context_p, //$NON-NLS-1$
	      context_p.eResource().getURI().trimFileExtension().appendFileExtension(ApaPackage.eNAME));
	}
	
	/**
	 * @see org.eclipse.emf.diffmerge.bridge.interactive.BridgeJob#getBridge()
	 */
	@Override
	protected EMFInteractiveBridge<PhysicalArchitecture, IEditableModelScope> getBridge() {
    final TransposerBridge<PhysicalArchitecture> mapping =
        new TransposerBridge<PhysicalArchitecture>(
            "org.eclipse.emf.diffmerge.bridge.examples.apa.transposer.purpose", //$NON-NLS-1$
            "org.eclipse.emf.diffmerge.bridge.examples.apa.transposer.mapping"); //$NON-NLS-1$
    ConfigurableDiffPolicy diffPolicy = new ConfigurableDiffPolicy();
    diffPolicy.setIgnoreOrders(true); // Ignore orders because of Transposer's non-determinism
    EMFInteractiveBridge<PhysicalArchitecture, IEditableModelScope> result = 
        new EMFInteractiveBridge<PhysicalArchitecture, IEditableModelScope>(
            mapping, diffPolicy, null, null);
    return result;
	}
	
}