package org.eclipse.ui.internal.dialogs;

/*
 * (c) Copyright IBM Corp. 2000, 2001.
 * All Rights Reserved.
 */
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNatureDescriptor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.internal.WorkbenchMessages;
import org.eclipse.ui.internal.WorkbenchPlugin;
import org.eclipse.ui.internal.registry.Capability;
import org.eclipse.ui.internal.registry.CapabilityRegistry;
import org.eclipse.ui.internal.registry.Category;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

/**
 * Standard workbench wizard that guides the user to supply
 * the necessary information to create a project.
 */
public class NewProjectWizard extends MultiStepWizard implements INewWizard {
	// init method parameters supplied
	private IWorkbench workbench;
	private IStructuredSelection selection;
	
	// Reference to the pages provided by this wizard
	private WizardNewProjectCreationPage creationPage;
	private WizardNewProjectCapabilityPage capabilityPage;
	
	// Newly created project
	private IProject newProject;

	// initial values for the pages provided by this wizard
	private String initialProjectName;
	private Capability[] initialProjectCapabilities;
	private Category[] initialSelectedCategories;
	
	/**
	 * Creates an empty wizard for creating a new project
	 * in the workspace.
	 */
	public NewProjectWizard() {
		super();
		
		WorkbenchPlugin plugin = WorkbenchPlugin.getDefault();
		IDialogSettings workbenchSettings = plugin.getDialogSettings();
		IDialogSettings section = workbenchSettings.getSection("NewProjectWizard");//$NON-NLS-1$
		if (section == null)
			section = workbenchSettings.addNewSection("NewProjectWizard");//$NON-NLS-1$
		setDialogSettings(section);
	}

	/* (non-Javadoc)
	 * Method declared on MultiStepWizard.
	 */
	protected void addCustomPages() {
		creationPage = new WizardNewProjectCreationPage("newProjectCreationPage");//$NON-NLS-1$
		creationPage.setTitle(WorkbenchMessages.getString("NewProjectWizard.title")); //$NON-NLS-1$
		creationPage.setDescription(WorkbenchMessages.getString("WizardNewProjectCreationPage.description")); //$NON-NLS-1$
		creationPage.setInitialProjectName(initialProjectName);
		this.addPage(creationPage);
		
		capabilityPage = new WizardNewProjectCapabilityPage("newProjectCapabilityPage");//$NON-NLS-1$
		capabilityPage.setTitle(WorkbenchMessages.getString("NewProjectWizard.title")); //$NON-NLS-1$
		capabilityPage.setDescription(WorkbenchMessages.getString("WizardNewProjectCapabilityPage.description")); //$NON-NLS-1$
		capabilityPage.setInitialProjectCapabilities(initialProjectCapabilities);
		capabilityPage.setInitialSelectedCategories(initialSelectedCategories);
		this.addPage(capabilityPage);
	}

	/**
	 * Builds the collection of steps to create and install
	 * the chosen capabilities
	 */
	private void buildSteps() {
		Capability[] caps = capabilityPage.getSelectedCapabilities();
		CapabilityRegistry reg = WorkbenchPlugin.getDefault().getCapabilityRegistry();
		IStatus status = reg.validateCapabilities(caps);
		if (status.isOK()) {
			Capability[] results = reg.pruneCapabilities(caps);
			WizardStep[] steps = new WizardStep[results.length + 1];
			steps[0] = new CreateProjectStep(1, creationPage, this);
			for (int i = 0; i < results.length; i++)
				steps[i+1] = new InstallCapabilityStep(i+2, results[i]);
			setSteps(steps);
		} else {
		}
	}
	
	/* (non-Javadoc)
	 * Method declared on MultiStepWizard.
	 */
	protected String getConfigurePageTitle() {
		return WorkbenchMessages.getString("NewProjectWizard.title");
	}
	
	/* (non-Javadoc)
	 * Method declared on MultiStepWizard.
	 */
	protected String getConfigurePageDescription() {
		return WorkbenchMessages.getString("WizardProjectConfigurePage.description");
	}
	
	/* (non-Javadoc)
	 * Method declared on MultiStepWizard.
	 */
	protected  String getReviewPageTitle() {
		return WorkbenchMessages.getString("NewProjectWizard.title");
	}
	
	/* (non-Javadoc)
	 * Method declared on MultiStepWizard.
	 */
	protected String getReviewPageDescription() {
		return WorkbenchMessages.getString("WizardProjectReviewPage.description");
	}
		
	/**
	 * Returns the newly created project.
	 *
	 * @return the created project, or <code>null</code>
	 *   if project is not created yet.
	 */
	public IProject getNewProject() {
		return newProject;
	}

	/* (non-Javadoc)
	 * Method declared on IWizard.
	 */
	public IWizardPage getNextPage(IWizardPage page) {
		if (page == capabilityPage)
			buildSteps();
		return super.getNextPage(page);
	}

	/* (non-Javadoc)
	 * Method declared on IWorkbenchWizard.
	 */
	public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
		this.workbench = workbench;
		this.selection = currentSelection;
		initializeDefaultPageImageDescriptor();
		setWindowTitle(WorkbenchMessages.getString("NewProjectWizard.windowTitle")); //$NON-NLS-1$
	}

	/* (non-Javadoc)
	 * Method declared on BasicNewResourceWizard.
	 */
	protected void initializeDefaultPageImageDescriptor() {
		String iconPath = "icons/full/";//$NON-NLS-1$		
		try {
			URL installURL = WorkbenchPlugin.getDefault().getDescriptor().getInstallURL();
			URL url = new URL(installURL, iconPath + "wizban/newprj_wiz.gif");//$NON-NLS-1$
			ImageDescriptor desc = ImageDescriptor.createFromURL(url);
			setDefaultPageImageDescriptor(desc);
		}
		catch (MalformedURLException e) {
			// Should not happen. Ignore.
		}
	}

	/**
	 * Sets the initial categories to be selected.
	 * 
	 * @param categories initial categories to select
	 */
	public void setInitialSelectedCategories(Category[] categories) {
		initialSelectedCategories = categories;
	}
	
	/**
	 * Sets the initial project capabilities to be selected.
	 * 
	 * @param capabilities initial project capabilities to select
	 */
	public void setInitialProjectCapabilities(Capability[] capabilities) {
		initialProjectCapabilities = capabilities;
	}
	
	/**
	 * Sets the initial project name. Leading and trailing
	 * spaces in the name are ignored.
	 * 
	 * @param name initial project name
	 */
	public void setInitialProjectName(String name) {
		if (name == null)
			initialProjectName = null;
		else
			initialProjectName = name.trim();
	}
	
	/**
	 * Sets the newly created project resource
	 */
	/* package */ void setNewProject(IProject project) {
		newProject = project;
	}
}
