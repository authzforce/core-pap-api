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

/**
 * PDP feature
 *
 */
public class PdpFeature
{
	private final String id;
	private final String type;
	private final boolean enabled;

	/**
	 * Constructor
	 * 
	 * @param id
	 *            feature ID
	 * @param type
	 *            feature type
	 * @param enabled
	 *            true iff feature is enabled
	 */
	public PdpFeature(String id, String type, boolean enabled)
	{
		assert id != null && type != null;
		this.id = id;
		this.type = type;
		this.enabled = enabled;
	}

	/**
	 * get feature ID
	 * 
	 * @return feature ID
	 */
	public String getID()
	{
		return this.id;
	}

	/**
	 * get feature type
	 * 
	 * @return feature type/category; null means the default type/category of feature (implementation-specific)
	 */
	public String getType()
	{
		return this.type;
	}

	/**
	 * get feature activation status
	 * 
	 * @return true iff the feature is enabled
	 */
	public boolean isEnabled()
	{
		return this.enabled;
	}

	/**
	 * hashCode is same as ID hashCode
	 * 
	 * @return hashCode
	 */
	@Override
	public int hashCode()
	{
		return id.hashCode();
	}

	/**
	 * 
	 * @param obj
	 *            compared feature
	 * @return true iff obj is a {@link PdpFeature} with equal ID
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}

		if (!(obj instanceof PdpFeature))
		{
			return false;
		}

		final PdpFeature other = (PdpFeature) obj;
		return id.equals(other.id);
	}
}
