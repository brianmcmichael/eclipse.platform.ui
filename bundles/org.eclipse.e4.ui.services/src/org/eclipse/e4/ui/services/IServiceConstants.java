/*******************************************************************************
 * Copyright (c) 2009, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.e4.ui.services;

public interface IServiceConstants {

	public final static String ACTIVE_SELECTION = "selection"; //$NON-NLS-1$

	/**
	 * Due to the possibly misleading nature of this field's name, it has been
	 * replaced with {@link #ACTIVE_SELECTION}. All clients of this API should
	 * change their references to <code>ACTIVE_SELECTION</code>.
	 */
	@Deprecated
	public final static String SELECTION = ACTIVE_SELECTION;

	/**
	 * 
	 */
	public static final String ACTIVE_CONTEXTS = "activeContexts"; //$NON-NLS-1$

	/**
	 * The part active in a given context.
	 * <p>
	 * This value can be <code>null</code> if there is no active part in a given
	 * context.
	 * </p>
	 */
	public static final String ACTIVE_PART = "e4ActivePart"; //$NON-NLS-1$

	/**
	 * If a client is interested in the identifier of the currently active part,
	 * the part could simply be injected with {@link #ACTIVE_PART} instead.
	 */
	@Deprecated
	public static final String ACTIVE_PART_ID = "activePartId"; //$NON-NLS-1$

	/**
	 * Individual contributions should be persisting its state via the model
	 * instead of through the context as the context is transient.
	 */
	@Deprecated
	public static final String PERSISTED_STATE = "persistedState"; //$NON-NLS-1$

	/**
	 * 
	 */
	public static final String ACTIVE_SHELL = "activeShell"; //$NON-NLS-1$
}
