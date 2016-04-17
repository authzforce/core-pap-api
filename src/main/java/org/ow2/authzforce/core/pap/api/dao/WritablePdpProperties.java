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
 * Writable domain properties, as opposed to read-only properties
 *
 */
public interface WritablePdpProperties
{
	/**
	 * Get PDP's root policy reference expression (ID and version constraints)
	 * 
	 * @return root policy reference expression
	 */
	IdReferenceType getRootPolicyRefExpression();

	/**
	 * Get PDP's feature IDs. Such identifiers identify implementation-specific features enabled/supported by the PDP (and easily identified by an ID without
	 * any further configuration parameter), e.g. support for XACML Multiple Decision Profile, extra XACML function, etc.
	 * 
	 * @return enabled PDP features
	 */
	List<String> getFeatureIDs();
}
