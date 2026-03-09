#!/bin/bash

set -e

# Required environment variables:
# GITHUB_REPO_SLUG
# GITHUB_TAG

printf "\n>>>>> Publishing javadoc for release build: repo=%s tag=%s\n" ${GITHUB_REPO_SLUG} ${GITHUB_TAG}

# Open the "main" dir, containing the checked out main branch
pushd main

printf "\n>>>>> Generating Javadoc...\n"
mvn -B versions:set -DnewVersion="${GITHUB_TAG}" -DgenerateBackupPoms=false
mvn -B -ntp clean javadoc:aggregate --settings build/.github.settings.xml
printf "\n>>>>> Finished generating Javadoc...\n"

# Create a new directory for this branch/tag and copy the javadocs there.
printf "\n>>>>> Copying javadocs to new directory: docs/%s\n" ${GITHUB_TAG}
rm -rf ../gh-pages/docs/${GITHUB_TAG}
mkdir -p ../gh-pages/docs/${GITHUB_TAG}
cp -rf target/site/apidocs/* ../gh-pages/docs/${GITHUB_TAG}

# Return to root dir, then open "gh-pages" dir
popd 
pushd gh-pages

printf "\n>>>>> Generating gh-pages index.html...\n"
../main/build/generateJavadocIndex.sh > index.html

printf "\n>>>>> Committing new javadoc...\n"
git config user.email "github-actions[bot]@users.noreply.github.com"
git config user.name "github-actions[bot]"
git add -f .
printf "\n>>>>> Added files...\n"
git commit -m "docs: latest javadoc for ${GITHUB_TAG}"
printf "\n>>>>> Committed changes...\n"
git push -f origin gh-pages
printf "\n>>>>> Pushed changes...\n"

popd

printf "\n>>>>> Published javadoc for release build: repo=%s tag=%s\n"  ${GITHUB_REPO_SLUG} ${GITHUB_TAG}
