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

import com.google.common.collect.ImmutableMap;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import oasis.names.tc.xacml._3_0.core.schema.wd_17.PolicySet;

import java.util.Map;

/**
 * JAXB-annotated XACML-based {@link }AuthzPolicy}
 */
public class JaxbXacmlAuthzPolicy implements AuthzPolicy
{
    private final PolicySet jaxbPolicySet;
    private final ImmutableMap<String, String> xPathNamespaceContexts;

    @SuppressFBWarnings(value = "EI_EXPOSE_REP2", justification = "PolicySet is immutable")
    public JaxbXacmlAuthzPolicy(final PolicySet jaxbPolicySet, final ImmutableMap<String, String> xPathNamespaceContexts)
    {
        this.jaxbPolicySet = jaxbPolicySet;
        this.xPathNamespaceContexts = xPathNamespaceContexts;
    }

    @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "PolicySet is immutable")
    @Override
    public PolicySet toXacml()
    {
        return jaxbPolicySet;
    }

    @Override
    public Map<String, String> getXPathNamespaceContexts()
    {
        return xPathNamespaceContexts;
    }
}

