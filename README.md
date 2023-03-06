# console-core-service-system

## Release

A pull request will trigger the release pipeline when merged. If you don't want a pull request to trigger a release add the tag `no_release` to the pull request.

The release pipeline will increment the version in the pom.xml, commit it back to the repo and tag a release in Github. A container will be built afterwards and released to the Dev environment.
