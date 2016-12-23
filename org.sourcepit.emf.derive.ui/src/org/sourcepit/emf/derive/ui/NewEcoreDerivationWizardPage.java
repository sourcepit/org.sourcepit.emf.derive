/*
 * Copyright 2016 Bernd Vogt and others.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.sourcepit.emf.derive.ui;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.presentation.EcoreActionBarContributor.ExtendedLoadResourceAction.ExtendedLoadResourceDialog;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;

public class NewEcoreDerivationWizardPage extends WizardPage {
   private abstract static class ContentProvider extends AdapterFactoryContentProvider {
      private ContentProvider(AdapterFactory adapterFactory) {
         super(adapterFactory);
      }

      @Override
      public Object[] getElements(Object object) {
         if (object instanceof ResourceSet) {
            final List<Object> result = new ArrayList<>();
            for (Object element : super.getElements(object)) {
               if (select(element)) {
                  result.add(element);
               }
            }
            return result.toArray();
         }
         return new Object[0];
      }

      protected abstract boolean select(Object element);

      @Override
      public boolean hasChildren(Object object) {
         if (object instanceof Resource) {
            return super.hasChildren(object);
         }
         return false;
      }

      @Override
      public Object[] getChildren(Object object) {
         if (object instanceof Resource) {
            return super.getChildren(object);
         }
         return new Object[0];
      }
   }

   private final IStructuredSelection selection;

   private final ComposedAdapterFactory adapterFactory;
   private final EditingDomain editingDomain;
   private final Set<URI> inputUris = new LinkedHashSet<>(), reuseUris = new LinkedHashSet<>();

   private CheckboxTreeViewer inputPackagesViewer;
   private CheckboxTreeViewer reusePackagesViewer;

   public NewEcoreDerivationWizardPage(IStructuredSelection selection) {
      super("wizardPage");

      setMessage(
         "Specify Ecore packages you want to derive a new model from and which to re-use from already derived models.");
      setTitle("Package Selection");
      setDescription("Wizard Page description");
      this.selection = selection;

      adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

      adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
      adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
      adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

      editingDomain = new AdapterFactoryEditingDomain(adapterFactory, new BasicCommandStack());
   }

   /**
    * Create contents of the wizard.
    * 
    * @param parent
    */
   public void createControl(Composite parent) {
      Composite container = new Composite(parent, SWT.NULL);

      setControl(container);
      container.setLayout(new FillLayout(SWT.HORIZONTAL));
      {
         final SashForm sashForm = new SashForm(container, SWT.VERTICAL);
         {
            final Group group = new Group(sashForm, SWT.NONE);
            group.setText("New Derivations");
            group.setLayout(new GridLayout(2, false));
            {
               final Label label = new Label(group, SWT.NONE);
               label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 2, 1));
               label.setText("For which packages do you want to create derivatives?");
            }
            {
               inputPackagesViewer = new CheckboxTreeViewer(group, SWT.BORDER | SWT.CHECK);
               final Tree tree = inputPackagesViewer.getTree();
               tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
            }
            {
               final Button button = new Button(group, SWT.NONE);
               button.addSelectionListener(new SelectionAdapter() {
                  @Override
                  public void widgetSelected(SelectionEvent e) {
                     onAddRootPackage();
                  }
               });
               button.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
               button.setText("Add...");
            }
         }
         {
            final Group group = new Group(sashForm, SWT.NONE);
            group.setText("Re-used Derivations");
            group.setLayout(new GridLayout(2, false));
            {
               final Label label = new Label(group, SWT.NONE);
               label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 2, 1));
               label.setText("Which packages do you want to re-use from already derived models?");
            }
            {
               reusePackagesViewer = new CheckboxTreeViewer(group, SWT.BORDER | SWT.CHECK);
               final Tree tree = reusePackagesViewer.getTree();
               tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
            }
            {
               final Button button = new Button(group, SWT.NONE);
               button.addSelectionListener(new SelectionAdapter() {
                  @Override
                  public void widgetSelected(SelectionEvent e) {
                     onAddDerivative();
                  }
               });
               button.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
               button.setText("Add...");
            }
         }
         sashForm.setWeights(new int[] { 3, 2 });
      }

      init();
   }

   private void init() {

      final ResourceSet resourceSet = editingDomain.getResourceSet();

      inputPackagesViewer.setContentProvider(new ContentProvider(adapterFactory) {
         @Override
         protected boolean select(Object element) {
            return true;
         }
      });
      inputPackagesViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
      inputPackagesViewer.setCheckStateProvider(new ICheckStateProvider() {

         @Override
         public boolean isGrayed(Object element) {
            return false;
         }

         @Override
         public boolean isChecked(Object element) {
            for (URI checkedUri : inputUris) {
               if (checkedUri.toString().startsWith(getUri(element).toString())) {
                  return true;
               }
            }
            return false;
         }
      });
      inputPackagesViewer.addCheckStateListener(new ICheckStateListener() {
         @Override
         public void checkStateChanged(CheckStateChangedEvent event) {
            final Set<URI> uris = new LinkedHashSet<>();
            final Object element = event.getElement();
            if (element instanceof Resource) {
               for (EObject eObject : ((Resource) element).getContents()) {
                  uris.add(EcoreUtil.getURI(eObject));
               }
            }
            else {
               uris.add(EcoreUtil.getURI((EObject) element));
            }

            if (event.getChecked()) {
               inputUris.addAll(uris);
            }
            else {
               inputUris.removeAll(uris);
            }

            inputPackagesViewer.refresh();
         }
      });

      reusePackagesViewer.setContentProvider(new ContentProvider(adapterFactory) {

         @Override
         protected boolean select(Object element) {
            return false;
         }
      });
      reusePackagesViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

      inputPackagesViewer.setInput(resourceSet);
      reusePackagesViewer.setInput(resourceSet);

      if (selection != null) {

         final Set<URI> newUris = new LinkedHashSet<>();

         for (IResource resource : extractResources(selection)) {
            final URI resourceUri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
            newUris.add(resourceUri);
         }

         loadInputResourceUris(newUris);
      }
   }

   private void loadInputResourceUris(final Collection<URI> uris) {

      final ResourceSet resourceSet = editingDomain.getResourceSet();

      final Set<EObject> oldRootObjects = new LinkedHashSet<>();
      for (Resource resource : resourceSet.getResources()) {
         for (EObject eObject : resource.getContents()) {
            oldRootObjects.add(eObject);
         }
      }
      for (URI uri : uris) {
         if (uri.hasFragment()) {
            throw new IllegalStateException(format("%s must not have a fragment.", uri));
         }
         final Resource resource = resourceSet.getResource(uri, true);
         EcoreUtil.resolveAll(resource);
      }
      final Set<EObject> newRootObjects = new LinkedHashSet<>();
      for (Resource resource : resourceSet.getResources()) {
         for (EObject eObject : resource.getContents()) {
            newRootObjects.add(eObject);
         }
      }
      newRootObjects.removeAll(oldRootObjects);
      if (!newRootObjects.isEmpty()) {
         for (EObject object : newRootObjects) {
            final URI uri = EcoreUtil.getURI(object);
            inputUris.add(uri);
            reuseUris.remove(uri);
         }
         for (EObject object : newRootObjects) {
            inputPackagesViewer.expandToLevel(object.eResource(), 1);
         }
      }

      inputPackagesViewer.refresh();
   }

   private void onAddRootPackage() {
      ExtendedLoadResourceDialog loadResourceDialog = new ExtendedLoadResourceDialog(getShell(), null);
      if (Window.OK == loadResourceDialog.open()) {
         loadInputResourceUris(loadResourceDialog.getURIs());
      }
   }

   private void onAddDerivative() {
   }

   private static List<IResource> extractResources(final IStructuredSelection selection) {
      final List<IResource> selectedResources = new ArrayList<IResource>();
      final Iterator<?> it = selection.iterator();
      while (it.hasNext()) {
         final IResource selectedResource = extractResource(it.next());
         if (selectedResource != null) {
            selectedResources.add(selectedResource);
         }
      }
      return selectedResources;
   }

   private static IResource extractResource(Object object) {
      if (object instanceof IResource) {
         return (IResource) object;
      }
      else if (object instanceof IAdaptable) {
         return (IResource) ((IAdaptable) object).getAdapter(IResource.class);
      }
      else {
         return null;
      }
   }

   private static URI getUri(Object element) {
      if (element instanceof Resource) {
         return ((Resource) element).getURI();
      }
      else if (element instanceof EObject) {
         return EcoreUtil.getURI((EObject) element);
      }
      throw new IllegalStateException();
   }
}
