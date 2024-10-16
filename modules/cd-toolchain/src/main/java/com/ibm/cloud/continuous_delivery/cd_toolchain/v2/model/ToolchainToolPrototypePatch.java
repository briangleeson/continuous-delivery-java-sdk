/*
 * (C) Copyright IBM Corp. 2024.
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

package com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model;

import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.GsonSingleton;

/**
 * Details on the new tool.
 */
public class ToolchainToolPrototypePatch extends GenericModel {

  protected String name;
  @SerializedName("tool_type_id")
  protected String toolTypeId;
  protected Map<String, Object> parameters;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String toolTypeId;
    private Map<String, Object> parameters;

    /**
     * Instantiates a new Builder from an existing ToolchainToolPrototypePatch instance.
     *
     * @param toolchainToolPrototypePatch the instance to initialize the Builder with
     */
    private Builder(ToolchainToolPrototypePatch toolchainToolPrototypePatch) {
      this.name = toolchainToolPrototypePatch.name;
      this.toolTypeId = toolchainToolPrototypePatch.toolTypeId;
      this.parameters = toolchainToolPrototypePatch.parameters;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ToolchainToolPrototypePatch.
     *
     * @return the new ToolchainToolPrototypePatch instance
     */
    public ToolchainToolPrototypePatch build() {
      return new ToolchainToolPrototypePatch(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ToolchainToolPrototypePatch builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the toolTypeId.
     *
     * @param toolTypeId the toolTypeId
     * @return the ToolchainToolPrototypePatch builder
     */
    public Builder toolTypeId(String toolTypeId) {
      this.toolTypeId = toolTypeId;
      return this;
    }

    /**
     * Set the parameters.
     *
     * @param parameters the parameters
     * @return the ToolchainToolPrototypePatch builder
     */
    public Builder parameters(Map<String, Object> parameters) {
      this.parameters = parameters;
      return this;
    }
  }

  protected ToolchainToolPrototypePatch() { }

  protected ToolchainToolPrototypePatch(Builder builder) {
    name = builder.name;
    toolTypeId = builder.toolTypeId;
    parameters = builder.parameters;
  }

  /**
   * New builder.
   *
   * @return a ToolchainToolPrototypePatch builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * Name of the tool.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the toolTypeId.
   *
   * The unique short name of the tool that should be provisioned or updated. A table of `tool_type_id` values
   * corresponding to each tool integration can be found in the &lt;a
   * href="https://cloud.ibm.com/docs/ContinuousDelivery?topic=ContinuousDelivery-integrations"&gt;Configuring tool
   * integrations page&lt;/a&gt;.
   *
   * @return the toolTypeId
   */
  public String toolTypeId() {
    return toolTypeId;
  }

  /**
   * Gets the parameters.
   *
   * Unique key-value pairs representing parameters to be used to create the tool. A list of parameters for each tool
   * integration can be found in the &lt;a
   * href="https://cloud.ibm.com/docs/ContinuousDelivery?topic=ContinuousDelivery-integrations"&gt;Configuring tool
   * integrations page&lt;/a&gt;.
   *
   * @return the parameters
   */
  public Map<String, Object> parameters() {
    return parameters;
  }

  /**
   * Construct a JSON merge-patch from the ToolchainToolPrototypePatch.
   *
   * Note that properties of the ToolchainToolPrototypePatch with null values are not represented in the constructed
   * JSON merge-patch object, but can be explicitly set afterward to signify a property delete.
   *
   * @return a JSON merge-patch for the ToolchainToolPrototypePatch
   */
  public Map<String, Object> asPatch() {
    return GsonSingleton.getGson().fromJson(this.toString(), Map.class);
  }
}

