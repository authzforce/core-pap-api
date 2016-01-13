/**
 * Copyright (C) 2012-2016 Thales Services SAS.
 *
 * This file is part of AuthZForce CE.
 *
 * AuthZForce CE is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AuthZForce CE is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with AuthZForce CE.  If not, see <http://www.gnu.org/licenses/>.
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
