/*
 * Copyright 2012-2021 THALES.
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
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;

import org.json.JSONObject;
import org.ow2.authzforce.core.pdp.api.policy.PolicyVersion;
import org.ow2.authzforce.xmlns.pdp.ext.AbstractAttributeProvider;

import oasis.names.tc.xacml._3_0.core.schema.wd_17.PolicySet;
import oasis.names.tc.xacml._3_0.core.schema.wd_17.Request;
import oasis.names.tc.xacml._3_0.core.schema.wd_17.Response;

/**
 * Domain DAO
 * 
 * @param <V>
 *            Domain-specific policy version DAO client implementation class
 * 
 * @param <P>
 *            Domain-specific policy DAO client/consumer implementation class
 */
public interface DomainDao<V extends PolicyVersionDaoClient, P extends PolicyDaoClient> extends Closeable
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
	 * Update domain's global properties/metadata
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
	 * Indicates whether the PAP is enabled/supported on this domain
	 * 
	 * @return true iff the PAP is enabled/supported on this domain
	 */
	boolean isPapEnabled();

	/**
	 * Get domain's PDP-specific properties, other than policy references and attribute providers
	 * 
	 * @return PDP properties
	 * @throws IOException
	 *             I/O error getting PDP properties from domain repository
	 * 
	 */
	ReadablePdpProperties getOtherPdpProperties() throws IOException;

	/**
	 * Update domain's PDP-specific properties, other than policy references and attribute providers
	 * 
	 * @param properties
	 *            new PDP properties
	 * @return new PDP properties
	 * 
	 * @throws IOException
	 *             I/O error updating domain's PDP properties in domain repository
	 * @throws IllegalArgumentException
	 *             invalid properties
	 * 
	 */
	ReadablePdpProperties setOtherPdpProperties(WritablePdpProperties properties) throws IOException, IllegalArgumentException;

	/**
	 * Get domain's PRP-specific properties, other than policies
	 * 
	 * @return PRP properties
	 * @throws IOException
	 *             I/O error getting PRP properties from domain repository
	 * 
	 */
	PrpRwProperties getOtherPrpProperties() throws IOException;

	/**
	 * Update domain's PRP-specific properties, other than policies
	 * 
	 * @param properties
	 *            new PRP properties
	 * @return new PRP properties
	 * 
	 * @throws IOException
	 *             I/O error updating domain's PRP properties in domain repository
	 * @throws IllegalArgumentException
	 *             invalid properties
	 * 
	 */
	PrpRwProperties setOtherPrpProperties(PrpRwProperties properties) throws IOException, IllegalArgumentException;

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
	Set<String> getPolicyIdentifiers() throws IOException;

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
	P getPolicyDaoClient(String policyId);

	/**
	 * Get all versions of the policy ordered from latest to oldest
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
	 * Get latest version of a given policy
	 * 
	 * @param policyId
	 *            policy ID
	 * 
	 * @return policy version; null if no such policy in the policy repository
	 * @throws IOException
	 *             I/O error getting policy version from the policy repository
	 */
	PolicyVersion getLatestPolicyVersionId(String policyId) throws IOException;

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
	 * @param policyVersion
	 *            policy version ID
	 * @return DAO for policy version identified by {@code version}, or null if no such policy or no such version of the policy
	 */
	V getVersionDaoClient(String policyId, PolicyVersion policyVersion);

	/**
	 * Get policy version
	 * 
	 * @param policyId
	 *            policy ID
	 * 
	 * @param versionId
	 *            policy version ID
	 * @return policy version; null if no such policy, or no such version of the policy in the policy repository
	 * @throws IOException
	 *             I/O error getting policy version from the policy repository
	 */
	PolicySet getPolicyVersion(String policyId, PolicyVersion versionId) throws IOException;

	/**
	 * Remove a specific version of the policy from the policy repository. If this is the last remaining version of the policy, this must have the same effect as {@link #removePolicy(String)}.
	 * 
	 * @param policyId
	 *            policy ID
	 * 
	 * @param versionId
	 *            policy version ID
	 * @return removed policy version; null if no such policy or no such version in the policy repository
	 * @throws IOException
	 *             I/O error removing policy version from the policy repository
	 * @throws IllegalArgumentException
	 *             if it (removing this policy version) results in an invalid PDP (when referenced directly or indirectly from the root policy)
	 */
	PolicySet removePolicyVersion(String policyId, PolicyVersion versionId) throws IOException, IllegalArgumentException;

	/**
	 * Check whether the PDP supports XACML/XML (JAXB) input/output according to XACML 3.0 core specification
	 * 
	 * @return true iff {@link #evaluatePolicyDecision(Request)} is supported
	 */
	boolean isXacmlXmlSupported();

	/**
	 * Check whether the PDP supports XACML/JSON input/output according to XACML JSON Profile 1.0 specification at OASIS
	 * 
	 * @return true iff {@link #evaluatePolicyDecision(JSONObject)} is supported
	 */
	boolean isXacmlJsonSupported();

	/**
	 * @param request
	 *            XACML (JAXB) Request
	 * @return XACML (JAXB) Response
	 * @throws UnsupportedOperationException
	 *             if XACML/XML input/output is not supported
	 */
	Response evaluatePolicyDecision(Request request) throws UnsupportedOperationException;

	/**
	 * @param request
	 *            XACML/JSON Request
	 * @return XACML/JSON Response
	 * @throws UnsupportedOperationException
	 *             if XACML/JSON input/output according to JSON Profile is not supported
	 */
	JSONObject evaluatePolicyDecision(JSONObject request) throws UnsupportedOperationException;

}
