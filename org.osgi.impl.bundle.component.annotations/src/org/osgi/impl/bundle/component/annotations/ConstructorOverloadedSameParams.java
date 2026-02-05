/*******************************************************************************
 * Copyright (c) Contributors to the Eclipse Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0 
 *******************************************************************************/
package org.osgi.impl.bundle.component.annotations;

import java.util.Map;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 * Warning scenario from bnd issue #7084:
 * Multiple constructors with same parameter count where only one has @Activate.
 * This may lead to subtle bugs as DS may choose any constructor with matching parameter count.
 */
@Component(name = "testConstructorOverloadedSameParams")
public class ConstructorOverloadedSameParams {

	public ConstructorOverloadedSameParams(BundleContext context) {
		// Constructor without @Activate
	}

	@Activate
	public ConstructorOverloadedSameParams(Map<String, Object> properties) {
		// Constructor with @Activate
	}
}
