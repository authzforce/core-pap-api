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

import oasis.names.tc.xacml._3_0.core.schema.wd_17.PolicySet;

import java.util.Map;

/**
 * Authorization Policy
 */
public interface AuthzPolicy
{
    /**
     * Get XACML form
     * @return XACML PolicySet
     */
    PolicySet toXacml();

    /**
     * Get XML namespaces (prefix-URI mappings) to be used in PolicySet's XPath expressions, e.g. AttributeSelectors' Paths
     * @return XPath namespace prefix-to-URI mappings
     */
    Map<String, String> getXPathNamespaceContexts();
}
