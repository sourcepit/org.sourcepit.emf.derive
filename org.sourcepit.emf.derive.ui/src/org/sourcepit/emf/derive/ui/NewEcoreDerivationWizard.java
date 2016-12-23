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

import org.eclipse.jface.dialogs.IPageChangedListener;
import org.eclipse.jface.dialogs.PageChangedEvent;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

public class NewEcoreDerivationWizard extends Wizard implements INewWizard, IPageChangedListener {
   private WizardNewFileCreationPage filePage;
   private NewEcoreDerivationWizardPage derivationPage;

   public NewEcoreDerivationWizard() {
      setWindowTitle("New Wizard");
   }

   @Override
   public void init(IWorkbench workbench, IStructuredSelection selection) {
      filePage = new WizardNewFileCreationPage(WizardNewFileCreationPage.class.getName(), selection);
      filePage.setTitle("Ecore Model Derivative");
      filePage.setDescription("Create the Ecore model derivative");
      filePage.setFileExtension("ecore");

      derivationPage = new NewEcoreDerivationWizardPage(selection);
   }

   @Override
   public void addPages() {
      addPage(filePage);
      addPage(derivationPage);
   }


   @Override
   public void pageChanged(PageChangedEvent event) {
   }

   @Override
   public boolean performFinish() {
      return false;
   }

}
