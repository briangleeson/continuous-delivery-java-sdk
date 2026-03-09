#!/bin/bash

# Required environment variables:
# GITHUB_REPO_SLUG
# GITHUB_TAG

printf "\n>>>>> Publishing javadoc for release build: repo=%s tag=%s\n" ${GITHUB_REPO_SLUG} ${GITHUB_TAG}

printf "\n>>>>> Checking gh auth status...\n"
gh auth status
printf "\n>>>>> Finished checking gh auth status...\n"

printf "\n>>>>> Checking out gh-pages branch...\n"
rm -fr ./gh-pages
git config --global user.email "github-actions[bot]@users.noreply.github.com"
git config --global user.name "github-actions[bot]"
# Checkout the gh-pages branch as a copy of latest in main
git checkout -b gh-pages --no-guess
git status
printf "\n>>>>> Finished checking out...\n"

printf "\n>>>>> Generating Javadoc...\n"
mvn -B versions:set -DnewVersion="${GITHUB_TAG}" -DgenerateBackupPoms=false
printf "\n>>>>> [DEBUG] build fodler contents...\n"
ls -la build
printf "\n>>>>> [/DEBUG] build fodler contents...\n"
mvn clean javadoc:aggregate --settings build/.github.settings.xml
printf "\n>>>>> Finished  generating Javadoc...\n"

# Create a new directory for this branch/tag and copy the javadocs there.
printf "\n>>>>> Copying javadocs to new directory: docs/%s\n" ${GITHUB_TAG}
rm -rf docs/${GITHUB_TAG}
mkdir -p docs/${GITHUB_TAG}
cp -rf ../target/site/apidocs/* docs/${GITHUB_TAG}

printf "\n>>>>> Generating gh-pages index.html...\n"
../build/generateJavadocIndex.sh > index.html

printf "\n>>>>> Committing new javadoc...\n"
git add -f .
printf "\n>>>>> Added files...\n"
git commit -m "docs: latest javadoc for ${GITHUB_TAG}"
printf "\n>>>>> Committed changes...\n"
git remote -v
git push origin gh-pages
printf "\n>>>>> Pushed changes...\n"

printf "\n>>>>> Published javadoc for release build: repo=%s tag=%s\n"  ${GITHUB_REPO_SLUG} ${GITHUB_TAG}
