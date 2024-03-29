# Change log
All notable changes to this project are documented in this file following the [Keep a CHANGELOG](http://keepachangelog.com) conventions. This project adheres to [Semantic Versioning](http://semver.org).

## 13.0.0
### Changed
- Upgraded authzforce-ce-parent (parent project): 9.1.0:

  - **Migrated to Java 17** (as the minimum required JRE version from now on)
- Upgraded dependencies:

  - authzforce-ce-core-pdp-api: 22.0.0
  - org.json:json to 20231013
  - spotbugs-annotations: 4.7.3


## 12.0.0
### Changed
- New `AuthzPolicy` interface replacing (XACML-schema-derived JAXB-annotated) `PolicySet` in API operations, as a more generic policy type.
- Upgraded parent project version (authzforce-ce-parent) to 8.2.1

  - Upgraded SLF4j to 1.7.32
  - Upgraded Saxon-HE to 10.6
  - Upgraded Guava to 31.0
  - Upgraded org.json:json to 20211205
- Upgraded compile dependency authzforce-ce-core-pdp-api to 21.2.0

  - Improved support of Multiple Decision Profile in following PDP extensions: Combining Algorithm, Function, Attribute Provider, Policy Provider (new methods and new optional `EvaluationContext` parameter for the MDP evaluation context).
  - Feature: XPath variables in xPathExpression `AttributeValue`s' XPath expressions can now be defined by XACML `VariableDefinition`s (variable name used as `XACML VariableId`), which means XACML Variables can be used as XPath variables there.
  - Changed Datatype extension (`AttributeValueFactory`) , `EvaluationContext`, `VariableReference` and `ExpressionFactory` interfaces to better support above feature and XPath evaluation in general
  - Changed Request preprocessor interface.
  - New `XMLUtils.SAXBasedXmlnsFilteringParser` class constructor parameter - XML namespace prefix-to-URI mappings - to help fix the issue authzforce/server#66 .

### Added
- `JaxbXacmlAuthzPolicy` class as default `AuthzPolicy` implementation based on schema-derived JAXB-annotated `PolicySet` class


## 11.0.1
### Fixed
- CVE-2021-22118: updated parent version to 8.0.2 -> Spring version to 5.2.15
- Dependency fixes:
  - Upgraded dependency authzforce-ce-core-pdp-api to v18.0.2
    - Upgraded javax.mailapi to 1.6.2


## 11.0.0
### Changed
- Upgraded project parent version: 8.0.0
- Upgraded to Java 11 (Java 8 no longer supported)
- Upgraded dependency authzforce-ce-core-pdp-api: 18.0.1

### Fixed
- Issue raised on AuthzForce Server project: authzforce/server#62


## 10.1.0
### Changed
- Upgraded parent project: 7.6.1
- Upgraded dependency authzforce-ce-core-pdp-api: 17.0.0


## 10.0.0
### Changed
- DomainDao API: 
	- Now extends `Closeable`, because some DAO implementations hold resources to be closed when done.
	- Replaced `getXacmlJaxbPdp()` and `getXacmlJsonPdp()` with: `isXacmlXmlSupported()`/`isXacmlJsonSupported()` and `evaluatePolicyDecision(Request)`/`evaluatePolicyDecision(JSONObject)`, to respect OOP encapsulation principles.
- DomainDaoClient.Factory API: `getInstance(String, DOMAIN_DAO)` replaced with `getInstance(String, Builder<DOMAIND_DAO>)`; so that only the created `DomainDaoClient` instance owns the reference to the `DOMAIN_DAO` instance internally created (from the `Builder`), to better manage potential resource leaks since now `DomainDao` extends `Closeable`.
- Parent project (authzforce-ce-parent / authzforce-ce-xacml-model / authzforce-ce-pdp-ext-model) version: 7.5.1
- Dependencies: 
	- authzforce-ce-core-pdp-api version: 15.3.0
		- Guava: 24.1.1-jre
		- Dependency mailapi replaced with javax.mail-api: v1.6.0
- License headers updated for current year 2019


## 9.2.0
### Changed
- Parent project (authzforce-ce-parent / authzforce-ce-xacml-model / authzforce-ce-pdp-ext-model) version: 7.3.0
- authzforce-ce-core-pdp-api version: 15.2.0
- License headers updated for current year 2018


## 9.1.0
### Changed
- Parent project (authzforce-ce-parent) version: 7.0.0 -> 7.1.0:
	Managed dependency versions:
	- json: 20170516 -> 20171018
	- authzforce-ce-core-pdp-api version: 12.0.0 -> 12.1.0
		- guava: 21.0 -> 22.0


## 9.0.0
### Changed/Fixed
- Fixed typo in method name DomainsDao#getDomainDaoClient()


## 8.0.0
### Changed
- Applied new Java class naming convention for acronyms on all interface methods


## 7.0.0
### Changed
- Parent project (authzforce-ce-parent) version: 5.1.0 -> 7.0.0
- Dependency authzforce-ce-core-pdp-api version: 9.1.0 -> 12.0.0
- Java class naming convention: only first letter in acronym should be uppercase, e.g. DomainDAOClient -> DomainDaoClient
- DomainDao interface: replaced method getPDP() with getXacmlJaxbPDP and getXacmlJsonPDP to provide both XACML/XML and XACML/JSON in-out PDP adapters, in order to support JSON Profile of XACML


## 6.4.0
### Changed
- License: GPL v3.0 replaced by Apache License v2.0
- Project URL: https://tuleap.ow2.org/projects/authzforce -> https://authzforce.ow2.org
- GIT repository URL base: https://tuleap.ow2.org/plugins/git/authzforce -> https://gitlab.ow2.org/authzforce
- Version of parent project (authzforce-ce-parent): 5.1.0 
- Version of dependency authzforce-ce-core-pdp-api: 9.1.0


## 6.3.0
### Changed
- Version of parent project (authzforce-ce-parent): 5.0.0 
- Version of dependency authzforce-ce-core-pdp-api: 9.0.0


## 6.2.0
### Changed
- Parent project version: 4.0.0 -> 4.1.1 
- Dependency authzforce-ce-core-pdp-api: 8.0.0 -> 8.2.0


## 6.1.0
### Added
- DomainDAO#isPAPEnabled(): method that returns true iff the DAO supports PAP features. Used for instance to disable PAP features on a frontend server API
features


## 6.0.0
### Added
- Maven plugin owasp-dependency-check to check vulnerabilities in dependencies 

### Changed
- Maven parent project version: 3.4.0 -> 4.0.0:
	- **Java version: 1.7 -> 1.8** (maven.compiler.source/target property)

### Removed
- Dependency on Koloboke


## 5.3.0
### Changed
- Parent project version: authzforce-ce-parent: 3.4.0
- Dependency version: authzforce-ce-core-pdp-api: 7.1.1

## 5.2.1 
### Fixed
- Issues reported by Codacy


## 5.2.0
### Changed
- Maven POM: authzforce-ce-core-pdp-api dependency version -> 4.0.0


## 5.1.0
### Added
- Management of PDP features (extensions), i.e. listing, get status, activation/de-activation: custom XACML datatypes, custom functions, custom policy/rule combining algorithms, custom XACML Request filter, custom XACML Result filter.


## 5.0.0
### Changed
- Replaced WritablePdpProperties#getRootPolicyRef() method with WritablePdpProperties#getRootPolicyRefExpression() and ReadablePdpProperties#getApplicableRootPolicyRef() to make the clear distinction between the writable rootPolicyRef pattern expression (with Version/EarliestVersion/LatestVersion patterns) used as input to PDP configuration, and the read-only rootPolicyRef resulting from the evaluation of this expression - fixed root policy ID and version - that is made applicable by the PDP during evaluation
- Renamed ReadablePdpProperties#getRefPolicyRef()) method to #getApplicableRootPolicyRef() to follow the same naming pattern as #getApplicableRootPolicyRef()


## 4.0.0
### Changed
- API type for Policy versions changed (from String) to PolicyVersion class in DomainDAO methods

### Added
- Interface method DomainDAO#getLatestPolicyVersionId(policyId): gets latest version of given policy in the domain
- Interface method to get new PDP properties: enabled policies (applicable by the PDP), last modified time (last time PDP was instantiated, in particular synced with backend data layer)
- Interface methods to get/set PDP's feature IDs. Such identifiers identify implementation-specific features enabled/supported by the PDP, e.g. support for XACML Multiple Decision Profile, extra XACML function, etc.
- Interface methods to get/set new PRP-specific properties: max policy count per domain, max version count per policy,  version rolling (enable automatic rolling of versions when max version count per policy is reached)


## 3.6.0
### Added
- Initial release on Github



