/*
 * Copyright 2012-2024 THALES.
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

import java.util.List;

import oasis.names.tc.xacml._3_0.core.schema.wd_17.IdReferenceType;

/**
 * Readable PDP properties, i.e. writable PDP properties and read-only properties
 *
 */
public interface ReadablePdpProperties extends WritablePdpProperties
{
	/**
	 * Get time the PDP was created or last time the PDP was modified
	 * 
	 * @return time of last creation/modification of the PDP in UTC milliseconds from the epoch
	 */
	long getLastModified();

	/**
	 * Get PDP's applicable root policy reference, resolved from {@link #getRootPolicyRefExpression()}
	 * 
	 * @return actual root policy reference
	 */
	IdReferenceType getApplicableRootPolicyRef();

	/**
	 * Get applicable policies referenced directly/indirectly from the root policy (returned by {@link #getRootPolicyRefExpression()}) via XACML PolicySetIdReference
	 * 
	 * @return references to policies (in)directly referenced from the root policy in force; empty if none
	 */
	List<IdReferenceType> getApplicableRefPolicyRefs();
}
