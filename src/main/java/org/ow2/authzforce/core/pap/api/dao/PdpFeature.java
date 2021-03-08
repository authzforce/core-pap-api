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
	public String getId()
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
