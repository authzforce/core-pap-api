/**
 * Copyright 2012-2020 THALES.
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
/**
 * 
 */
package org.ow2.authzforce.core.pap.api.dao;

/**
 * Readable domain properties, i.e. writable domain properties and read-only properties
 *
 */
public interface ReadableDomainProperties extends WritableDomainProperties
{
	/**
	 * @return domain ID (read-only), as generated/known by the DAO backend: database, repository, etc.
	 */
	String getInternalId();
}
