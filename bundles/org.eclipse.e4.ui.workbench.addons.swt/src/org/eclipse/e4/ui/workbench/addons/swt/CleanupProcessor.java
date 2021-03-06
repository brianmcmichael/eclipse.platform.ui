/*******************************************************************************
 * Copyright (c) 2013 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.e4.ui.workbench.addons.swt;

import java.util.List;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MAddon;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.impl.ApplicationFactoryImpl;

public class CleanupProcessor {
	@Execute
	void addCleanupAddon(MApplication app) {
		List<MAddon> addons = app.getAddons();

		// Prevent multiple copies
		for (MAddon addon : addons) {
			if (addon.getContributionURI()
					.contains("ui.workbench.addons.cleanupaddon.CleanupAddon"))
				return;
		}

		// Insert the addon into the system
		MAddon cleanupAddon = ApplicationFactoryImpl.eINSTANCE.createAddon();
		cleanupAddon.setElementId("CleanupAddon"); //$NON-NLS-1$
		cleanupAddon
				.setContributionURI("bundleclass://org.eclipse.e4.ui.workbench.addons.swt/org.eclipse.e4.ui.workbench.addons.cleanupaddon.CleanupAddon"); //$NON-NLS-1$
		app.getAddons().add(cleanupAddon);
	}
}
