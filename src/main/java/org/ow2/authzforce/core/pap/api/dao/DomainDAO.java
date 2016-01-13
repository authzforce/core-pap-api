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
/**
 * 
 */
package org.ow2.authzforce.core.pap.api.dao;

import java.io.IOException;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;

import oasis.names.tc.xacml._3_0.core.schema.wd_17.PolicySet;

import org.ow2.authzforce.core.pdp.api.PDP;
import org.ow2.authzforce.core.pdp.api.PolicyVersion;
import org.ow2.authzforce.xmlns.pdp.ext.AbstractAttributeProvider;

/**
 * Domain DAO
 * 
 * @param <V>
 *            Domain-specific policy version DAO client implementation class
 * 
 * @param <P>
 *            Domain-specific policy DAO client/consumer implementation class
 */
public interface DomainDAO<V extends PolicyVersionDAOClient, P extends PolicyDAOClient>
{

	/**
	 * Get domain properties/metadata
	 * 
	 * @return domain properties
	 * @throws IOException
	 *             I/O error getting domain properties from domain repository
	 * 
	 */
	ReadableDomainProperties getDomainProperties() throws IOException;

	/**
	 * Update domain properties/metadata
	 * 
	 * @param properties
	 *            new domain properties
	 * @return properties actually committed to the domain repository
	 * 
	 * @throws IOException
	 *             I/O error updating domain properties in domain repository
	 * @throws IllegalArgumentException
	 *             invalid properties
	 * 
	 */
	ReadableDomainProperties setDomainProperties(WritableDomainProperties properties) throws IOException, IllegalArgumentException;

	/**
	 * Remove the domain from the domain repository
	 * 
	 * @return result of {@link #getDomainProperties()} before removal
	 * @throws IOException
	 *             if any I/O error occurred removing the domain from the domain repository
	 */
	ReadableDomainProperties removeDomain() throws IOException;

	/**
	 * Get domain's attribute providers
	 * 
	 * @return domain attribute providers
	 * @throws IOException
	 *             I/O error getting domain's attribute providers from domain repository
	 * 
	 */
	List<AbstractAttributeProvider> getAttributeProviders() throws IOException;

	/**
	 * Update domain's attribute providers
	 * 
	 * @param attributeProviders
	 *            new domain attribute providers
	 * @return AttributeProviders configuration actually committed
	 * 
	 * @throws IOException
	 *             I/O error updating domain's attribute providers in domain repository
	 * @throws IllegalArgumentException
	 *             invalid attribute providers (configuration)
	 * 
	 */
	List<AbstractAttributeProvider> setAttributeProviders(List<AbstractAttributeProvider> attributeProviders) throws IOException, IllegalArgumentException;

	/**
	 * Get IDs of domain's policies
	 * 
	 * @return policy identifiers
	 * @throws IOException
	 *             I/O error getting list of policies from domain repository
	 */
	Set<String> getPolicyIDs() throws IOException;

	/**
	 * Add policy to the domain's policy repository
	 * 
	 * @param policy
	 *            XACML PolicySet
	 * @return Policy already existing with same ID/Version in the domain's policy repository, if any (conflict); or null if there isn't any (no conflict)
	 * @throws IOException
	 *             I/O error adding policy to domain in domain repository
	 * @throws IllegalArgumentException
	 *             invalid policy, because of invalid syntax or unsupported feature, or - in general - resulting in invalid PDP
	 * @throws TooManyPoliciesException
	 *             max allowed number of policies is already reached
	 */
	PolicySet addPolicy(PolicySet policy) throws IOException, IllegalArgumentException, TooManyPoliciesException;

	/**
	 * Get policy-specific DAO client/consumer
	 * 
	 * @param policyId
	 *            policy ID
	 * @return DAO for policy identified by {@code policyId} in the domain, or null if no such policy in the domain
	 */
	P getPolicyDAOClient(String policyId);

	/**
	 * Get the domain's Policy Decision Point (based on policies and attribute providers)
	 * 
	 * @return domain PDP
	 */
	PDP getPDP();

	/**
	 * Get all versions of the policy
	 * 
	 * @param policyId
	 *            policy ID
	 * 
	 * @return policy versions, empty if policy not found in the policy repository
	 * @throws IOException
	 *             I/O error getting policy versions the policy repository
	 */
	NavigableSet<PolicyVersion> getPolicyVersions(String policyId) throws IOException;

	/**
	 * Remove the policy (all versions) from the domain's policy repository
	 * 
	 * @param policyId
	 *            policy ID
	 * @return all removed policy versions; empty if policy not found in the policy repository
	 * @throws IOException
	 *             I/O error removing policy (all versions) from the policy repository
	 * @throws IllegalArgumentException
	 *             if it (removing this policy) results in an invalid PDP (when referenced directly or indirectly from the root policy)
	 */
	NavigableSet<PolicyVersion> removePolicy(String policyId) throws IOException, IllegalArgumentException;

	/**
	 * Get policy-version-specific DAO client/consumer
	 * 
	 * @param policyId
	 *            policy ID
	 * 
	 * @param version
	 *            policy version ID
	 * @return DAO for policy version identified by {@code version}, or null if no such policy or no such version of the policy
	 */
	V getVersionDAOClient(String policyId, String version);

	/**
	 * Get policy version
	 * 
	 * @param policyId
	 *            policy ID
	 * 
	 * @param version
	 *            policy version ID
	 * @return policy version; null if no such policy, or no such version of the policy in the policy repository
	 * @throws IOException
	 *             I/O error getting policy version from the policy repository
	 */
	PolicySet getPolicyVersion(String policyId, String version) throws IOException;

	/**
	 * Remove a specific version of the policy from the policy repository
	 * 
	 * @param policyId
	 *            policy ID
	 * 
	 * @param version
	 *            policy version ID
	 * @return removed policy version; null if no such policy or no such version in the policy repository
	 * @throws IOException
	 *             I/O error removing policy version from the policy repository
	 * @throws IllegalArgumentException
	 *             if it (removing this policy version) results in an invalid PDP (when referenced directly or indirectly from the root policy)
	 */
	PolicySet removePolicyVersion(String policyId, String version) throws IOException, IllegalArgumentException;

}
