# Change log
All notable changes to this project are documented in this file following the [Keep a CHANGELOG](http://keepachangelog.com) conventions. This project adheres to [Semantic Versioning](http://semver.org).


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



