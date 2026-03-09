#!/bin/bash

# Required environment variables:
# GH_TOKEN
# GITHUB_REPO_SLUG
# GITHUB_TAG

printf "\n>>>>> Publishing javadoc for release build: repo=%s tag=%s\n" ${GITHUB_REPO_SLUG} ${GITHUB_TAG}

printf "\n>>>>> Cloning repository's gh-pages branch into directory 'gh-pages'\n"
rm -fr ./gh-pages
# TODO this approach doesnt work when using GH_TOKEN: ${{ secrets.GITHUB_TOKEN }} in workflow
git config --global user.email "github-actions[bot]@users.noreply.github.com"
git config --global user.name "github-actions[bot]"
git clone --branch=gh-pages https://${GH_TOKEN}@github.com/${GITHUB_REPO_SLUG}.git gh-pages
# TODO For now using a hardcoded token in the repo settings secrets, tied to brian.gleeson@ie.ibm.com
# git clone --branch=gh-pages https://${GH_TOKEN}@github.com/${GITHUB_REPO_SLUG}.git gh-pages
printf "\n>>>>> Finished cloning...\n"

gh auth status

printf "\n>>>>> Finished checking gh auth status...\n"

pushd gh-pages

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
git push -f origin gh-pages
printf "\n>>>>> Pushed changes...\n"

popd

printf "\n>>>>> Published javadoc for release build: repo=%s tag=%s\n"  ${GITHUB_REPO_SLUG} ${GITHUB_TAG}
