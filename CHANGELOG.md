# Change log
All notable changes to this project are documented in this file following the [Keep a CHANGELOG](http://keepachangelog.com) conventions. This project adheres to [Semantic Versioning](http://semver.org).

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



