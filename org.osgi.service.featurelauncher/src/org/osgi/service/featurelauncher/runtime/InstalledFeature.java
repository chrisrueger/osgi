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
package org.osgi.service.featurelauncher.runtime;

import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.service.feature.ID;

/**
 * An {@link InstalledFeature} represents the current state of a feature
 * installed by the {@link FeatureRuntime}.
 * <p>
 * This type is a DTO and represents the state of the runtime when it was
 * created. It may become out of date if additional features are installed or
 * removed.
 */
@ProviderType
public final class InstalledFeature {

	/**
	 * The string version of the {@link ID} of the installed feature
	 */
	public String						featureId;

    /**
	 * A map with keys that are the bundles installed by this feature. The
	 * values are a {@link List} of the String {@link ID}s for each installed
	 * feature that installed the bundle
	 */
	public Map<Bundle,List<String>>		installedBundles;


	/**
	 * A list of the configurations that were installed by this feature
	 */
	public List<InstalledConfiguration>	installedConfigurations;
}