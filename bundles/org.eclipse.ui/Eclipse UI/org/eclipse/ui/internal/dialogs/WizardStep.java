package org.eclipse.ui.internal.dialogs;

import org.eclipse.jface.wizard.IWizard;

/*
 * (c) Copyright IBM Corp. 2000, 2001.
 * All Rights Reserved.
 */

/**
 * Represents a step in a multi-step wizard.
 */
public abstract class WizardStep {
	private int number;
	private boolean done = false;
	
	/**
	 * Creates a wizard step.
	 * 
	 * @param number the step number
	 */
	public WizardStep(int number) {
		super();
		this.number = number;
	}

	/**
	 * Returns the label for this step that can
	 * be presented to the user.
	 * 
	 * @return String the label of this step
	 */
	abstract public String getLabel();
	
	/**
	 * Returns an explaination of this step that can
	 * be presented to the user.
	 * 
	 * @return String the details of this step
	 */
	abstract public String getDetails();
	
	/**
	 * Returns the step's number.
	 * 
	 * @return int the step's number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Returns the step's wizard. Subclasses are
	 * responsible for calling addPages method on
	 * the wizard, if needed, before returning.
	 * 
	 * @return IWizard the wizard to complete the step
	 */
	public abstract IWizard getWizard();

	/**
	 * Returns whether the step is done it's work
	 */
	public boolean isDone() {
		return done;
	}

	/**
	 * Sets the step as being done
	 */
	/* package */ void markAsDone() {
		done = true;
	}
}
