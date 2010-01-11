/*******************************************************************************
 * Copyright (c) 2008, 2010 Oakland Software Incorporated and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oakland Software Incorporated - initial API and implementation
 *.....IBM Corporation - fixed dead code warning
 *     Fair Issac Corp - bug 287103 - NCSLabelProvider does not properly handle overrides 
 *******************************************************************************/
package org.eclipse.ui.tests.navigator;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.internal.navigator.extensions.NavigatorContentExtension;
import org.eclipse.ui.tests.harness.util.DisplayHelper;
import org.eclipse.ui.tests.navigator.extension.TestLabelProvider;
import org.eclipse.ui.tests.navigator.extension.TestLabelProviderBlank;
import org.eclipse.ui.tests.navigator.extension.TestLabelProviderCyan;
import org.eclipse.ui.tests.navigator.extension.TestLabelProviderStyledGreen;
import org.eclipse.ui.tests.navigator.extension.TrackingLabelProvider;

public class LabelProviderTest extends NavigatorTestBase {

	public LabelProviderTest() {
		_navigatorInstanceId = "org.eclipse.ui.tests.navigator.OverrideTestView";
	}

	private static final int NONE = 0;
	private static final int OVERRIDDEN = 1;
	private static final int OVERRIDING = 2;
	private static final int BOTH = 3;

	private static final boolean BLANK = true;
	private static final boolean NULL = false;

	private static final String PLAIN = "Plain";

	private void setBlank(String cpToGet, boolean blank) {
		NavigatorContentExtension ext = (NavigatorContentExtension) _contentService
				.getContentExtensionById(cpToGet);
		TestLabelProvider tp = (TestLabelProvider) ext.getLabelProvider();
		if (blank)
			tp._blank = true;
		else
			tp._null = true;

	}

	// Bug 289090 label provider returning blank in getText() not properly
	// skipped
	// Bug 296253 blank label provider should be allowed if nothing better found
	public void blankLabelProviderOverride(int nce, boolean blank, String suffix)
			throws Exception {

		String overriddenCp = TEST_CONTENT_OVERRIDDEN1 + suffix; // Red
		String overrideCp = TEST_CONTENT_OVERRIDE1 + suffix; // Green

		String checkColor = "Green";

		switch (nce) {
		case NONE:
			break;
		case OVERRIDDEN:
			setBlank(overriddenCp, blank);
			break;
		case OVERRIDING:
			checkColor = "Red";
			setBlank(overrideCp, blank);
			break;
		case BOTH:
			setBlank(overriddenCp, blank);
			setBlank(overrideCp, blank);
			break;
		}

		_contentService.bindExtensions(
				new String[] { overriddenCp, overrideCp }, false);
		_contentService.getActivationService().activateExtensions(
				new String[] { overrideCp, overriddenCp }, true);

		refreshViewer();

		// This tests the getStyledText() method
		TreeItem[] rootItems = _viewer.getTree().getItems();

		// Also test the raw ILabelProvider which uses the getText() method
		ILabelProvider lp = _contentService.createCommonLabelProvider();
		String lpText = lp.getText(rootItems[0].getData());

		if (nce == BOTH) {
			if (!rootItems[0].getText().equals(""))
				fail("Wrong text: " + rootItems[0].getText());

			if (blank) {
				if (!lpText.equals(""))
					fail("Wrong text from ILabelProvider: " + lpText);
			} else {
				if (lpText != null)
					fail("Wrong text from ILabelProvider: " + lpText);
			}
		} else {
			if (!rootItems[0].getText().startsWith(checkColor))
				fail("Wrong text: " + rootItems[0].getText());
			if (!lpText.startsWith(checkColor))
				fail("Wrong text from ILabelProvider: " + lpText);
		}
	}

	public void testBlankLabelProviderOverrideNone() throws Exception {
		blankLabelProviderOverride(NONE, BLANK, "");
	}

	public void testNullLabelProviderOverrideNone() throws Exception {
		blankLabelProviderOverride(NONE, NULL, "");
	}

	public void testPlainBlankLabelProviderOverrideNone() throws Exception {
		blankLabelProviderOverride(NONE, BLANK, PLAIN);
	}

	public void testPlainNullLabelProviderOverrideNone() throws Exception {
		blankLabelProviderOverride(NONE, NULL, PLAIN);
	}

	public void testBlankLabelProviderOverride1() throws Exception {
		blankLabelProviderOverride(OVERRIDDEN, BLANK, "");
	}

	public void testNullLabelProviderOverride1() throws Exception {
		blankLabelProviderOverride(OVERRIDDEN, NULL, "");
	}

	public void testPlainBlankLabelProviderOverride1() throws Exception {
		blankLabelProviderOverride(OVERRIDDEN, BLANK, PLAIN);
	}

	public void testPlainNullLabelProviderOverride1() throws Exception {
		blankLabelProviderOverride(OVERRIDDEN, NULL, PLAIN);
	}

	public void testBlankLabelProviderOverride2() throws Exception {
		blankLabelProviderOverride(OVERRIDING, BLANK, "");
	}

	public void testNullLabelProviderOverride2() throws Exception {
		blankLabelProviderOverride(OVERRIDING, NULL, "");
	}

	public void testPlainBlankLabelProviderOverride2() throws Exception {
		blankLabelProviderOverride(OVERRIDING, BLANK, PLAIN);
	}

	public void testPlainNullLabelProviderOverride2() throws Exception {
		blankLabelProviderOverride(OVERRIDING, NULL, PLAIN);
	}

	public void testBlankLabelProviderBoth() throws Exception {
		blankLabelProviderOverride(BOTH, BLANK, "");
	}

	public void testNullLabelProviderBoth() throws Exception {
		blankLabelProviderOverride(BOTH, NULL, "");
	}

	public void testPlainBlankLabelProviderBoth() throws Exception {
		blankLabelProviderOverride(BOTH, BLANK, PLAIN);
	}

	public void testPlainNullLabelProviderBoth() throws Exception {
		blankLabelProviderOverride(BOTH, NULL, PLAIN);
	}

	private void checkItemsAll(TreeItem[] rootItems, TestLabelProvider tlp) {
		if (!rootItems[0].getText().startsWith(tlp.getColorName()))
			fail("Wrong text: " + rootItems[0].getText());
		checkItems(rootItems, tlp);
	}

	private void checkItems(TreeItem[] rootItems, TestLabelProvider tlp) {
		assertEquals(tlp.backgroundColor, rootItems[0].getBackground(0));
		assertEquals(TestLabelProvider.toForegroundColor(tlp.backgroundColor),
				rootItems[0].getForeground(0));
		assertEquals(tlp.font, rootItems[0].getFont(0));
		assertEquals(tlp.image, rootItems[0].getImage(0));
	}

	// bug 252293 [CommonNavigator] LabelProviders do not obey override rules
	public void testSimpleResFirst() throws Exception {

		_contentService.bindExtensions(new String[] { TEST_CONTENT_OVERRIDDEN1,
				TEST_CONTENT_OVERRIDE1 }, false);
		_contentService.getActivationService()
				.activateExtensions(
						new String[] { TEST_CONTENT_OVERRIDE1,
								TEST_CONTENT_OVERRIDDEN1 }, true);

		refreshViewer();

		TreeItem[] rootItems = _viewer.getTree().getItems();
		checkItemsAll(rootItems, TestLabelProviderStyledGreen.instance);
	}

	/**
	 * E{low} overrides D{low} overrides B{normal} overrides A F{high} overrides
	 * C{low} overrides A G{normal} overrides C{low} B branch has higher
	 * priority than C's, and G higher than G, so order should be B branch (E -
	 * D - B) then C branches (F - G - C) then A
	 */
	public void testOverrideChain() throws Exception {
		final String[] EXTENSIONS = new String[] {
				TEST_CONTENT_TRACKING_LABEL + ".A",
				TEST_CONTENT_TRACKING_LABEL + ".B",
				TEST_CONTENT_TRACKING_LABEL + ".C",
				TEST_CONTENT_TRACKING_LABEL + ".D",
				TEST_CONTENT_TRACKING_LABEL + ".E",
				TEST_CONTENT_TRACKING_LABEL + ".F",
				TEST_CONTENT_TRACKING_LABEL + ".G" };
		_contentService.bindExtensions(EXTENSIONS, true);
		_contentService.getActivationService().activateExtensions(EXTENSIONS,
				true);

		refreshViewer();
		_viewer.getTree().getItems();

		TrackingLabelProvider.resetQueries();

		// Time for the decorating label provider to settle down
		DisplayHelper.sleep(200);

		refreshViewer();

		// The label provider (sync runs) and then the decorating label provider
		// runs (in something like every 100ms)
		// Give time for both and expect both to have happened.
		DisplayHelper.sleep(200);

		final String EXPECTED = "EDBFGCA";
		if (false)
			System.out.println("Map: "
					+ TrackingLabelProvider.styledTextQueries);
		String queries = (String) TrackingLabelProvider.styledTextQueries
				.get(_project);
		// This can happen multiple times depending on when the decorating label
		// provider
		// runs, so just make sure the sequence is right
		assertTrue("Wrong query order for text", queries.startsWith(EXPECTED));
	}

	// bug 252293 [CommonNavigator] LabelProviders do not obey override rules
	public void testSimpleResLast() throws Exception {
		_contentService.bindExtensions(new String[] { TEST_CONTENT_OVERRIDDEN2,
				TEST_CONTENT_OVERRIDE2 }, false);
		_contentService.getActivationService()
				.activateExtensions(
						new String[] { TEST_CONTENT_OVERRIDDEN2,
								TEST_CONTENT_OVERRIDE2 }, true);

		refreshViewer();

		TreeItem[] rootItems = _viewer.getTree().getItems();
		checkItemsAll(rootItems, TestLabelProviderCyan.instance);
	}

	public void testOverrideAdd() throws Exception {
		_contentService.bindExtensions(new String[] { TEST_CONTENT_OVERRIDDEN2,
				TEST_CONTENT_OVERRIDE2 }, false);
		_contentService.getActivationService()
				.activateExtensions(
						new String[] { TEST_CONTENT_OVERRIDDEN2,
								TEST_CONTENT_OVERRIDE2 }, true);

		refreshViewer();

		// Try manually adding
		_viewer.expandToLevel(_project, 3);
		IFile f = _project.getFile("newfile");
		_viewer.add(_project, new Object[] { f });

		if (false)
			DisplayHelper.sleep(10000000);

		TreeItem[] rootItems = _viewer.getTree().getItems();
		checkItemsAll(rootItems, TestLabelProviderCyan.instance);
	}

	// Make sure that it finds label providers that are in overridden content
	// extensions
	// if none of the label providers from the desired content extensions return
	// anything
	public void testUsingOverriddenLabelProvider() throws Exception {

		_contentService.bindExtensions(new String[] { TEST_CONTENT_OVERRIDDEN2,
				TEST_CONTENT_OVERRIDE2_BLANK }, true);
		_contentService.getActivationService().activateExtensions(
				new String[] { TEST_CONTENT_OVERRIDDEN2,
						TEST_CONTENT_OVERRIDE2_BLANK }, true);

		refreshViewer();

		TreeItem[] rootItems = _viewer.getTree().getItems();

		if (false)
			DisplayHelper.sleep(10000000);

		// But we get the text from the overridden label provider
		if (!rootItems[0].getText().startsWith("Blue"))
			fail("Wrong text: " + rootItems[0].getText());

		// We get the everything else from the blank label provider
		checkItems(rootItems, TestLabelProviderBlank.instance);
	}

	// Bug 295803 Source of contribution set to lowest priority NCE
	// Not fixed yet
	public void XXXtestMultiNceSameObject() throws Exception {

		_contentService.bindExtensions(
				new String[] { TEST_CONTENT_OVERRIDDEN1, }, true);
		// Just two different ones, they don't override, the label provider
		// should be associated with the higher priority extension that
		// contributed the object.
		_contentService.getActivationService().activateExtensions(
				new String[] { TEST_CONTENT_OVERRIDDEN1,
						COMMON_NAVIGATOR_RESOURCE_EXT }, true);

		refreshViewer();

		TreeItem[] rootItems = _viewer.getTree().getItems();

		// DisplayHelper.sleep(10000000);

		// But we get the text from the overridden label provider
		// FIXME - this should be the normal background and foreground color
		// since it should be from the JDT/Resource NCE
		if (!rootItems[0].getText().startsWith("Blue"))
			fail("Wrong text: " + rootItems[0].getText());
	}

}