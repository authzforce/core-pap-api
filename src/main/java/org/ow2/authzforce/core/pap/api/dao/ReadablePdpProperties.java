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
/**
 * 
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
	IdReferenceType getRootPolicyRef();

	/**
	 * Get applicable policies referenced directly/indirectly from the root policy (returned by {@link #getRootPolicyRef()}) via XACML PolicySetIdReference
	 * 
	 * @return references to policies (in)directly referenced from the root policy in force; empty if none
	 */
	List<IdReferenceType> getRefPolicyRefs();
}
