/*
 * (C) Copyright IBM Corp. 2023.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Properties of the source, which define the URL of the repository and a branch or tag.
 */
public class DefinitionSourceProperties extends GenericModel {

  protected String url;
  protected String branch;
  protected String tag;
  protected String path;
  protected Tool tool;

  /**
   * Builder.
   */
  public static class Builder {
    private String url;
    private String branch;
    private String tag;
    private String path;
    private Tool tool;

    /**
     * Instantiates a new Builder from an existing DefinitionSourceProperties instance.
     *
     * @param definitionSourceProperties the instance to initialize the Builder with
     */
    private Builder(DefinitionSourceProperties definitionSourceProperties) {
      this.url = definitionSourceProperties.url;
      this.branch = definitionSourceProperties.branch;
      this.tag = definitionSourceProperties.tag;
      this.path = definitionSourceProperties.path;
      this.tool = definitionSourceProperties.tool;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param url the url
     * @param path the path
     */
    public Builder(String url, String path) {
      this.url = url;
      this.path = path;
    }

    /**
     * Builds a DefinitionSourceProperties.
     *
     * @return the new DefinitionSourceProperties instance
     */
    public DefinitionSourceProperties build() {
      return new DefinitionSourceProperties(this);
    }

    /**
     * Set the url.
     *
     * @param url the url
     * @return the DefinitionSourceProperties builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }

    /**
     * Set the branch.
     *
     * @param branch the branch
     * @return the DefinitionSourceProperties builder
     */
    public Builder branch(String branch) {
      this.branch = branch;
      return this;
    }

    /**
     * Set the tag.
     *
     * @param tag the tag
     * @return the DefinitionSourceProperties builder
     */
    public Builder tag(String tag) {
      this.tag = tag;
      return this;
    }

    /**
     * Set the path.
     *
     * @param path the path
     * @return the DefinitionSourceProperties builder
     */
    public Builder path(String path) {
      this.path = path;
      return this;
    }

    /**
     * Set the tool.
     *
     * @param tool the tool
     * @return the DefinitionSourceProperties builder
     */
    public Builder tool(Tool tool) {
      this.tool = tool;
      return this;
    }
  }

  protected DefinitionSourceProperties() { }

  protected DefinitionSourceProperties(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.url,
      "url cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.path,
      "path cannot be null");
    url = builder.url;
    branch = builder.branch;
    tag = builder.tag;
    path = builder.path;
    tool = builder.tool;
  }

  /**
   * New builder.
   *
   * @return a DefinitionSourceProperties builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the url.
   *
   * URL of the definition repository.
   *
   * @return the url
   */
  public String url() {
    return url;
  }

  /**
   * Gets the branch.
   *
   * A branch from the repo, specify one of branch or tag only.
   *
   * @return the branch
   */
  public String branch() {
    return branch;
  }

  /**
   * Gets the tag.
   *
   * A tag from the repo, specify one of branch or tag only.
   *
   * @return the tag
   */
  public String tag() {
    return tag;
  }

  /**
   * Gets the path.
   *
   * The path to the definition's YAML files.
   *
   * @return the path
   */
  public String path() {
    return path;
  }

  /**
   * Gets the tool.
   *
   * Reference to the repository tool in the parent toolchain.
   *
   * @return the tool
   */
  public Tool tool() {
    return tool;
  }
}

