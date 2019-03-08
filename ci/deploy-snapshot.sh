echo check deployment

if [ "$TRAVIS_REPO_SLUG" == "TDesjardins/gwt-ol" ] && \
   [ "$TRAVIS_JDK_VERSION" == "oraclejdk8" ] && \
   [ "$TRAVIS_PULL_REQUEST" == "false" ] && \
   [ "$TRAVIS_BRANCH" == "master" ]; then

  echo deploy snapshot
  mvn -s ci/settings.xml clean deploy -Dmaven.test.skip=true -Dinvoker.skip=true
fi