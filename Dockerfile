FROM opensearchproject/opensearch:2.11.1

# relies on `brew install opensearch`
RUN opensearch-plugin install --batch \
  "https://github.com/opensearch-project/opensearch-learning-to-rank-base/releases/download/release-test-release-new/ltr-plugin-v2.11.1-RC1.zip"