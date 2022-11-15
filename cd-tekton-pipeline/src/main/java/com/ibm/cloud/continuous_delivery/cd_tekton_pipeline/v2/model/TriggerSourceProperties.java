/*
 * (C) Copyright IBM Corp. 2022.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Properties of the source, which define the URL of the repository and a branch or pattern.
 */
public class TriggerSourceProperties extends GenericModel {

  protected String url;
  protected String branch;
  protected String pattern;
  @SerializedName("blind_connection")
  protected Boolean blindConnection;
  @SerializedName("hook_id")
  protected String hookId;
  protected TriggerSourcePropertiesTool tool;

  /**
   * Builder.
   */
  public static class Builder {
    private String url;
    private String branch;
    private String pattern;
    private Boolean blindConnection;
    private String hookId;
    private TriggerSourcePropertiesTool tool;

    /**
     * Instantiates a new Builder from an existing TriggerSourceProperties instance.
     *
     * @param triggerSourceProperties the instance to initialize the Builder with
     */
    private Builder(TriggerSourceProperties triggerSourceProperties) {
      this.url = triggerSourceProperties.url;
      this.branch = triggerSourceProperties.branch;
      this.pattern = triggerSourceProperties.pattern;
      this.blindConnection = triggerSourceProperties.blindConnection;
      this.hookId = triggerSourceProperties.hookId;
      this.tool = triggerSourceProperties.tool;
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
     */
    public Builder(String url) {
      this.url = url;
    }

    /**
     * Builds a TriggerSourceProperties.
     *
     * @return the new TriggerSourceProperties instance
     */
    public TriggerSourceProperties build() {
      return new TriggerSourceProperties(this);
    }

    /**
     * Set the url.
     *
     * @param url the url
     * @return the TriggerSourceProperties builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }

    /**
     * Set the branch.
     *
     * @param branch the branch
     * @return the TriggerSourceProperties builder
     */
    public Builder branch(String branch) {
      this.branch = branch;
      return this;
    }

    /**
     * Set the pattern.
     *
     * @param pattern the pattern
     * @return the TriggerSourceProperties builder
     */
    public Builder pattern(String pattern) {
      this.pattern = pattern;
      return this;
    }

    /**
     * Set the blindConnection.
     *
     * @param blindConnection the blindConnection
     * @return the TriggerSourceProperties builder
     */
    public Builder blindConnection(Boolean blindConnection) {
      this.blindConnection = blindConnection;
      return this;
    }

    /**
     * Set the hookId.
     *
     * @param hookId the hookId
     * @return the TriggerSourceProperties builder
     */
    public Builder hookId(String hookId) {
      this.hookId = hookId;
      return this;
    }

    /**
     * Set the tool.
     *
     * @param tool the tool
     * @return the TriggerSourceProperties builder
     */
    public Builder tool(TriggerSourcePropertiesTool tool) {
      this.tool = tool;
      return this;
    }
  }

  protected TriggerSourceProperties() { }

  protected TriggerSourceProperties(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.url,
      "url cannot be null");
    url = builder.url;
    branch = builder.branch;
    pattern = builder.pattern;
    blindConnection = builder.blindConnection;
    hookId = builder.hookId;
    tool = builder.tool;
  }

  /**
   * New builder.
   *
   * @return a TriggerSourceProperties builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the url.
   *
   * URL of the repository to which the trigger is listening.
   *
   * @return the url
   */
  public String url() {
    return url;
  }

  /**
   * Gets the branch.
   *
   * Name of a branch from the repo. One of branch or pattern must be specified, but only one or the other.
   *
   * @return the branch
   */
  public String branch() {
    return branch;
  }

  /**
   * Gets the pattern.
   *
   * Git branch or tag pattern to listen to, specify one of branch or pattern only. When specifying a tag to listen to,
   * you can also specify a simple glob pattern such as '!test' or '*master' to match against multiple tags/branches in
   * the repository.
   *
   * @return the pattern
   */
  public String pattern() {
    return pattern;
  }

  /**
   * Gets the blindConnection.
   *
   * True if the repository server is not addressable on the public internet. IBM Cloud will not be able to validate the
   * connection details you provide.
   *
   * @return the blindConnection
   */
  public Boolean blindConnection() {
    return blindConnection;
  }

  /**
   * Gets the hookId.
   *
   * ID of the webhook from the repo. Computed upon creation of the trigger.
   *
   * @return the hookId
   */
  public String hookId() {
    return hookId;
  }

  /**
   * Gets the tool.
   *
   * Reference to the repository tool in the parent toolchain.
   *
   * @return the tool
   */
  public TriggerSourcePropertiesTool tool() {
    return tool;
  }
}

