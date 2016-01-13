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
 * Policy DAO client/consumer
 *
 */
public interface PolicyDAOClient// <DAO extends DomainDAO<?, ?>>
{
	/**
	 * Policy DAO client factory
	 * 
	 * @param <VERSION_DAO_CLIENT>
	 *            policy version DAO client implementation class
	 *
	 * @param <POLICY_DAO_CLIENT>
	 *            policy DAO client implementation class
	 */
	interface Factory<VERSION_DAO_CLIENT extends PolicyVersionDAOClient, POLICY_DAO_CLIENT extends PolicyDAOClient>
	{
		POLICY_DAO_CLIENT getInstance(String policyId, DomainDAO<VERSION_DAO_CLIENT, ?> domainDAO);

		PolicyVersionDAOClient.Factory<VERSION_DAO_CLIENT> getVersionDAOClientFactory();
	}

}
