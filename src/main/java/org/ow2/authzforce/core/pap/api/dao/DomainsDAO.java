/**
 * Copyright (C) 2012-2016 Thales Services SAS.
 *
 * This file is part of AuthZForce CE.
 *
 * AuthZForce CE is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * AuthZForce CE is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with AuthZForce CE. If not, see <http://www.gnu.org/licenses/>.
 */
package org.ow2.authzforce.core.pap.api.dao;

import java.io.IOException;
import java.util.Set;

/**
 * Domain repository DAO (multiple domains)
 *
 * @param <C>
 *            domain
 */
public interface DomainsDAO<C extends DomainDAOClient<?>>
{

	/**
	 * Add domain
	 * 
	 * @param props
	 *            new domain properties. If the 'rootPolicyRef' element is missing, a default root policy must be
	 *            automatically created for the domain and a corresponding rootPolicyRef set in the domain properties,
	 *            so that later calls to {@link DomainDAO#getDomainProperties()} always return a valid 'rootPolicyRef'.
	 *            If the 'rootPolicyRef' element is present in {@code props}, it assumes that the DAO implementation
	 *            initializes new domains with a fixed set of policies, and the client knows about those policies and
	 *            therefore how to set the 'rootPolicyRef' properly to match one of those pre-set policies. If this
	 *            client-defined 'rootPolicyRef' does not match any, the domain creation request will be rejected.
	 * 
	 * @return new domain ID
	 * @throws IllegalArgumentException
	 *             invalid {@code props}
	 * @throws IOException
	 *             I/O error adding domain to domain repository
	 */
	String addDomain(WritableDomainProperties props) throws IllegalArgumentException, IOException;

	/**
	 * Get domain IDs
	 * 
	 * @param externalId
	 *            (optional) external ID of domain, i.e. managed by the API client. If {@code externalId == null}, IDs
	 *            of all domains must be returned, else only ID(s) of domain(s) matching {@code externalId}. In the
	 *            latter case, as external IDs are supposed to be managed externally (by the client), implementations of
	 *            this API are not required to return at most one domain ID for a given {@code externalId}. An empty set
	 *            must be returned if no domain found, whether {@code externalId} is null or not.
	 * @return domain IDs, or empty set if no domain found
	 * @throws IOException
	 *             I/O error getting list of domains from Data layer (domain repository/database)
	 */
	Set<String> getDomainIDs(String externalId) throws IOException;

	/**
	 * Checks whether domain exists in domain repository
	 * 
	 * @param domainId
	 *            domain ID
	 * @return true iff domain exists
	 * @throws IOException
	 *             I/O error checking domain repository
	 */
	boolean containsDomain(String domainId) throws IOException;

	/**
	 * Get domain-specific DAO client/consumer
	 * 
	 * @param domainId
	 *            domain ID
	 * @return DAO for domain identified by {@code domainId}, or null if no such domain
	 * @throws IOException
	 *             I/O error getting domain data from Data layer (domain repository/database)
	 */
	C getDomainDAOClient(String domainId) throws IOException;

}
