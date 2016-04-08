# Change log
All notable changes to this project are documented in this file following the [Keep a CHANGELOG](http://keepachangelog.com) conventions. This project adheres to [Semantic Versioning](http://semver.org).

## Unreleased
## Changed
- API type for Policy versions changed (from String) to PolicyVersion class in DomainDAO methods

## Added
- Interface method DomainDAO#getLatestPolicyVersionId(policyId): gets latest version of given policy in the domain
- Interface method to get new PDP properties: enabled policies (applicable by the PDP), last modified time (last time PDP was instantiated, in particular synced with backend data layer)
- Interface methods to get/set PDP's feature IDs. Such identifiers identify implementation-specific features enabled/supported by the PDP, e.g. support for XACML Multiple Decision Profile, extra XACML function, etc.
- Interface methods to get/set new PRP-specific properties: max policy count per domain, max version count per policy,  version rolling (enable automatic rolling of versions when max version count per policy is reached)


## 3.6.0
### Added
- Initial release on Github



