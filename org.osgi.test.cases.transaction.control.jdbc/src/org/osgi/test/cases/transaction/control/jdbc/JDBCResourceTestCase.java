/*
 * Copyright (c) OSGi Alliance (2017). All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.osgi.test.cases.transaction.control.jdbc;

import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceReference;
import org.osgi.service.transaction.control.jdbc.JDBCConnectionProviderFactory;
import org.osgi.test.support.OSGiTestCase;
import org.osgi.util.tracker.ServiceTracker;

public abstract class JDBCResourceTestCase extends OSGiTestCase {
	
	private ServiceTracker<JDBCConnectionProviderFactory,JDBCConnectionProviderFactory>	tracker;

	protected JDBCConnectionProviderFactory												jdbcResourceProviderFactory;

	protected Bundle																	jdbcResourceProviderBundle;

	protected boolean												localEnabled;

	protected boolean												xaEnabled;

	protected void setUp() throws InterruptedException {
		tracker = new ServiceTracker<JDBCConnectionProviderFactory,JDBCConnectionProviderFactory>(
				getContext(), JDBCConnectionProviderFactory.class, null);
		tracker.open();
		jdbcResourceProviderFactory = tracker.waitForService(5000);

		assertNotNull("No Tx Control service available within 5 seconds",
				jdbcResourceProviderFactory);

		ServiceReference<JDBCConnectionProviderFactory> ref = tracker
				.getServiceReference();

		jdbcResourceProviderBundle = ref.getBundle();

		localEnabled = toBoolean(ref.getProperty("osgi.local.enabled"));
		xaEnabled = toBoolean(ref.getProperty("osgi.xa.enabled"));

		assertTrue(
				"This transaction control service does not support local or xa transactions",
				localEnabled || xaEnabled);
	}
	
	protected void tearDown() {
		tracker.close();
	}
	
	protected boolean toBoolean(Object o) {
		return o == null ? false : Boolean.parseBoolean(o.toString());
	}
}