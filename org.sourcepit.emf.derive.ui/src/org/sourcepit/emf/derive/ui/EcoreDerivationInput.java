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

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;

public class EcoreDerivationInput {
   private final Set<URI> inputEPackageUris = new LinkedHashSet<>(), reuseEPackageUris = new LinkedHashSet<>();

   public Set<URI> getInputEPackageUris() {
      return inputEPackageUris;
   }

   public Set<URI> getReuseEPackageUris() {
      return reuseEPackageUris;
   }
}
