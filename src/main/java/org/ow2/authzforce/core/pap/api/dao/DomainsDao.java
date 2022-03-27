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

import java.io.IOException;
import java.util.Set;

/**
 * Domain repository DAO (multiple domains)
 *
 * @param <C>
 *            domain
 */
public interface DomainsDao<C extends DomainDaoClient<?>>
{

	/**
	 * Add domain
	 * 
	 * @param props
	 *            new domain properties. If the 'rootPolicyRef' element is missing, a default root policy must be automatically created for the domain and a corresponding rootPolicyRef set in the
	 *            domain properties, so that later calls to {@link DomainDao#getDomainProperties()} always return a valid 'rootPolicyRef'. If the 'rootPolicyRef' element is present in {@code props},
	 *            it assumes that the DAO implementation initializes new domains with a fixed set of policies, and the client knows about those policies and therefore how to set the 'rootPolicyRef'
	 *            properly to match one of those pre-set policies. If this client-defined 'rootPolicyRef' does not match any, the domain creation request will be rejected.
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
	 *            (optional) external ID of domain, i.e. managed by the API client. If {@code externalId == null}, IDs of all domains must be returned, else only ID(s) of domain(s) matching
	 *            {@code externalId}. In the latter case, as external IDs are supposed to be managed externally (by the client), implementations of this API are not required to return at most one
	 *            domain ID for a given {@code externalId}. An empty set must be returned if no domain found, whether {@code externalId} is null or not.
	 * @return domain IDs, or empty set if no domain found
	 * @throws IOException
	 *             I/O error getting list of domains from Data layer (domain repository/database)
	 */
	Set<String> getDomainIdentifiers(String externalId) throws IOException;

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
	C getDomainDaoClient(String domainId) throws IOException;

}
