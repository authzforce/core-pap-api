/**
 * Copyright 2012-2017 Thales Services SAS.
 *
 * This file is part of AuthzForce CE.
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
 */
package org.ow2.authzforce.core.pap.api.dao;

/**
 * Domain-specific DAO client/consumer
 * 
 * @param <DAO>
 *            Domain-specific DAO implementation class
 *
 */
public interface DomainDAOClient<DAO extends DomainDAO<?, ?>>
{
	/**
	 * Domain-specific DAO client factory
	 * 
	 * @param <VERSION_DAO_CLIENT>
	 *            Domain policy version-specific DAO client implementation class
	 *
	 * @param <POLICY_DAO_CLIENT>
	 *            policy-specific DAO client implementation class for a domain's policy
	 * @param <DOMAIN_DAO>
	 * @param <DOMAIN_DAO_CLIENT>
	 */
	interface Factory<VERSION_DAO_CLIENT extends PolicyVersionDAOClient, POLICY_DAO_CLIENT extends PolicyDAOClient, DOMAIN_DAO extends DomainDAO<?, ?>, DOMAIN_DAO_CLIENT extends DomainDAOClient<DOMAIN_DAO>>
	{
		DOMAIN_DAO_CLIENT getInstance(String domainId, DOMAIN_DAO domainDAO);

		/**
		 * Get domain policy DAO client factory
		 * 
		 * @return domain's policy DAO client factory
		 */
		PolicyDAOClient.Factory<VERSION_DAO_CLIENT, POLICY_DAO_CLIENT> getPolicyDAOClientFactory();
	}

	/**
	 * Get domain-specific DAO
	 *
	 * @return domain-specific DAO
	 */
	DAO getDAO();
}
