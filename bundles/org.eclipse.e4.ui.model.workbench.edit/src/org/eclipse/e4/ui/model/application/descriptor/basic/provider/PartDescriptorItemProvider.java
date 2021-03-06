/**
 * Copyright (c) 2008, 2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      IBM Corporation - initial API and implementation
 */
package org.eclipse.e4.ui.model.application.descriptor.basic.provider;


import java.util.Collection;
import java.util.List;
import org.eclipse.e4.ui.model.application.commands.MCommandsFactory;
import org.eclipse.e4.ui.model.application.commands.impl.CommandsPackageImpl;
import org.eclipse.e4.ui.model.application.descriptor.basic.MPartDescriptor;
import org.eclipse.e4.ui.model.application.descriptor.basic.impl.BasicPackageImpl;
import org.eclipse.e4.ui.model.application.provider.ApplicationElementItemProvider;
import org.eclipse.e4.ui.model.application.impl.ApplicationPackageImpl;
import org.eclipse.e4.ui.model.application.provider.UIElementsEditPlugin;
import org.eclipse.e4.ui.model.application.ui.impl.UiPackageImpl;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuFactory;
import org.eclipse.e4.ui.model.application.ui.provider.UILabelItemProvider;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link org.eclipse.e4.ui.model.application.descriptor.basic.MPartDescriptor} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PartDescriptorItemProvider
	extends ApplicationElementItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartDescriptorItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addLabelPropertyDescriptor(object);
			addIconURIPropertyDescriptor(object);
			addTooltipPropertyDescriptor(object);
			addBindingContextsPropertyDescriptor(object);
			addAllowMultiplePropertyDescriptor(object);
			addCategoryPropertyDescriptor(object);
			addCloseablePropertyDescriptor(object);
			addDirtyablePropertyDescriptor(object);
			addContributionURIPropertyDescriptor(object);
			addDescriptionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Label feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLabelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_UILabel_label_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_UILabel_label_feature", "_UI_UILabel_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UiPackageImpl.Literals.UI_LABEL__LABEL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Icon URI feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIconURIPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_UILabel_iconURI_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_UILabel_iconURI_feature", "_UI_UILabel_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UiPackageImpl.Literals.UI_LABEL__ICON_URI,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Tooltip feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTooltipPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_UILabel_tooltip_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_UILabel_tooltip_feature", "_UI_UILabel_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 UiPackageImpl.Literals.UI_LABEL__TOOLTIP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Binding Contexts feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBindingContextsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Bindings_bindingContexts_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Bindings_bindingContexts_feature", "_UI_Bindings_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CommandsPackageImpl.Literals.BINDINGS__BINDING_CONTEXTS,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Allow Multiple feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAllowMultiplePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PartDescriptor_allowMultiple_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_PartDescriptor_allowMultiple_feature", "_UI_PartDescriptor_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 BasicPackageImpl.Literals.PART_DESCRIPTOR__ALLOW_MULTIPLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Category feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCategoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PartDescriptor_category_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_PartDescriptor_category_feature", "_UI_PartDescriptor_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 BasicPackageImpl.Literals.PART_DESCRIPTOR__CATEGORY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Closeable feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCloseablePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PartDescriptor_closeable_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_PartDescriptor_closeable_feature", "_UI_PartDescriptor_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 BasicPackageImpl.Literals.PART_DESCRIPTOR__CLOSEABLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Dirtyable feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDirtyablePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PartDescriptor_dirtyable_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_PartDescriptor_dirtyable_feature", "_UI_PartDescriptor_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 BasicPackageImpl.Literals.PART_DESCRIPTOR__DIRTYABLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Contribution URI feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContributionURIPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PartDescriptor_contributionURI_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_PartDescriptor_contributionURI_feature", "_UI_PartDescriptor_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 BasicPackageImpl.Literals.PART_DESCRIPTOR__CONTRIBUTION_URI,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Description feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PartDescriptor_description_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_PartDescriptor_description_feature", "_UI_PartDescriptor_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 BasicPackageImpl.Literals.PART_DESCRIPTOR__DESCRIPTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(CommandsPackageImpl.Literals.HANDLER_CONTAINER__HANDLERS);
			childrenFeatures.add(BasicPackageImpl.Literals.PART_DESCRIPTOR__MENUS);
			childrenFeatures.add(BasicPackageImpl.Literals.PART_DESCRIPTOR__TOOLBAR);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns PartDescriptor.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/PartDescriptor")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		String label = ((MPartDescriptor)object).getLabel();
		return label == null || label.length() == 0 ?
			getString("_UI_PartDescriptor_type") : //$NON-NLS-1$
			getString("_UI_PartDescriptor_type") + " - " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(MPartDescriptor.class)) {
			case BasicPackageImpl.PART_DESCRIPTOR__LABEL:
			case BasicPackageImpl.PART_DESCRIPTOR__ICON_URI:
			case BasicPackageImpl.PART_DESCRIPTOR__TOOLTIP:
			case BasicPackageImpl.PART_DESCRIPTOR__BINDING_CONTEXTS:
			case BasicPackageImpl.PART_DESCRIPTOR__ALLOW_MULTIPLE:
			case BasicPackageImpl.PART_DESCRIPTOR__CATEGORY:
			case BasicPackageImpl.PART_DESCRIPTOR__CLOSEABLE:
			case BasicPackageImpl.PART_DESCRIPTOR__DIRTYABLE:
			case BasicPackageImpl.PART_DESCRIPTOR__CONTRIBUTION_URI:
			case BasicPackageImpl.PART_DESCRIPTOR__DESCRIPTION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case BasicPackageImpl.PART_DESCRIPTOR__HANDLERS:
			case BasicPackageImpl.PART_DESCRIPTOR__MENUS:
			case BasicPackageImpl.PART_DESCRIPTOR__TOOLBAR:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(CommandsPackageImpl.Literals.HANDLER_CONTAINER__HANDLERS,
				 MCommandsFactory.INSTANCE.createHandler()));

		newChildDescriptors.add
			(createChildParameter
				(BasicPackageImpl.Literals.PART_DESCRIPTOR__MENUS,
				 MMenuFactory.INSTANCE.createMenu()));

		newChildDescriptors.add
			(createChildParameter
				(BasicPackageImpl.Literals.PART_DESCRIPTOR__MENUS,
				 MMenuFactory.INSTANCE.createPopupMenu()));

		newChildDescriptors.add
			(createChildParameter
				(BasicPackageImpl.Literals.PART_DESCRIPTOR__MENUS,
				 MMenuFactory.INSTANCE.createRenderedMenu()));

		newChildDescriptors.add
			(createChildParameter
				(BasicPackageImpl.Literals.PART_DESCRIPTOR__MENUS,
				 MMenuFactory.INSTANCE.createOpaqueMenu()));

		newChildDescriptors.add
			(createChildParameter
				(BasicPackageImpl.Literals.PART_DESCRIPTOR__TOOLBAR,
				 MMenuFactory.INSTANCE.createToolBar()));

		newChildDescriptors.add
			(createChildParameter
				(BasicPackageImpl.Literals.PART_DESCRIPTOR__TOOLBAR,
				 MMenuFactory.INSTANCE.createRenderedToolBar()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return UIElementsEditPlugin.INSTANCE;
	}

}
