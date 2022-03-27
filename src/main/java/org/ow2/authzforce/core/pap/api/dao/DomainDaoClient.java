/*
 * Copyright 2012-2022 THALES.
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

import java.io.Closeable;
import java.io.IOException;

/**
 * Domain-specific DAO client/consumer
 * 
 * @param <DAO>
 *            Domain-specific DAO implementation class
 *
 */
public interface DomainDaoClient<DAO extends DomainDao<?, ?>>
{
	/**
	 * Domain-specific DAO builder
	 *
	 * @param <DAO>
	 */
	interface Builder<DAO>
	{
		DAO build() throws IOException;
	}

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
	interface Factory<VERSION_DAO_CLIENT extends PolicyVersionDaoClient, POLICY_DAO_CLIENT extends PolicyDaoClient, DOMAIN_DAO extends DomainDao<?, ?>, DOMAIN_DAO_CLIENT extends DomainDaoClient<DOMAIN_DAO>>
	{
		/**
		 * Create instance of domain-specific DAO client
		 * 
		 * @param domainId
		 *            domain ID
		 * @param domainDaoBuilder
		 *            domain DAO builder. {@link DomainDao} is {@link Closeable}, so the created instance should be responsible for managing its lifecycle from instantiation to closure, to prevent
		 *            resource leak.
		 * @return domain-specific DAO client
		 * @throws IOException
		 *             I/O exception creating the backend DAO
		 */
		DOMAIN_DAO_CLIENT getInstance(String domainId, Builder<DOMAIN_DAO> domainDaoBuilder) throws IOException;

		/**
		 * Get domain policy DAO client factory
		 * 
		 * @return domain's policy DAO client factory
		 */
		PolicyDaoClient.Factory<VERSION_DAO_CLIENT, POLICY_DAO_CLIENT> getPolicyDaoClientFactory();
	}

	/**
	 * Get domain-specific DAO
	 *
	 * @return domain-specific DAO
	 */
	DAO getDao();
}
