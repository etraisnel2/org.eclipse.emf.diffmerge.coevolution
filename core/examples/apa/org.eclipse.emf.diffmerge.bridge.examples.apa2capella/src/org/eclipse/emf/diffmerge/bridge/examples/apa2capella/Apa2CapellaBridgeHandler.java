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
package org.eclipse.emf.diffmerge.bridge.examples.apa2capella;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.diffmerge.bridge.examples.apa.AScope;
import org.eclipse.emf.diffmerge.bridge.examples.apa2capella.messages.Messages;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.polarsys.capella.common.platform.sirius.ted.SemanticEditingDomainFactory;

/**
 * The incremental bridge command handler. This command handler is invoked when
 * the user right clicks from the Project Explorer on an APA model and selects
 * APA-to-Capella Bridge from the contextual menu. An APA model is a resource
 * with the extension "apa".
 * 
 * @author Amine Lajmi
 *
 */
public class Apa2CapellaBridgeHandler extends AbstractHandler {

  /**
   * 
   * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
   */
  public Object execute(ExecutionEvent event_p) throws ExecutionException {
    IFile file = unwrap(event_p, IFile.class);
    if (file != null) {
      IPath fullPath = file.getFullPath();

      // load source resource
      SemanticEditingDomainFactory factory = new SemanticEditingDomainFactory();
      EditingDomain editingDomain = factory.createEditingDomain();
      ResourceSet resourceSet = editingDomain.getResourceSet();
      URI sourceURI = URI.createPlatformResourceURI(fullPath.toOSString(),
          false);
      Resource resource = resourceSet.getResource(sourceURI, true);

      AScope context = (AScope) resource.getContents().get(0);
      if (context != null) {
        Apa2CapellaBridgeJob apa2CapellaBridgeJob = new Apa2CapellaBridgeJob(context);
        apa2CapellaBridgeJob.schedule();
      } else {
        throw new ExecutionException(Messages.Apa2CapellaBridgeCommandHandler_ExecutionContextNotFound);
      }

    }
    return null;
  }

  /**
   * Unwraps the object given the type given as input
   * 
   * @param <T>
   * 
   * @param object_p (non-null)
   *          the object to unwrap
   * @param type_p (non-null)
   *          the type to cast
   * @return the (possibly null) unwrapped object
   */
  <T> T unwrap(Object object_p, Class<T> type_p) {
    Object current = object_p;
    if (current instanceof ExecutionEvent) {
      current = HandlerUtil.getCurrentSelection((ExecutionEvent) current);
    }
    if (current instanceof IStructuredSelection) {
      current = ((IStructuredSelection) current).getFirstElement();
    }
    if (current instanceof IAdaptable) {
      current = ((IAdaptable) current).getAdapter(type_p);
    }
    if (type_p.isInstance(current)) {
      return type_p.cast(current);
    }
    return null;
  }
}