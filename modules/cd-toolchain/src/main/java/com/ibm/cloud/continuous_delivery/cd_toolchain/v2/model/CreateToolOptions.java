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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createTool options.
 */
public class CreateToolOptions extends GenericModel {

  protected String toolchainId;
  protected String toolTypeId;
  protected String name;
  protected Map<String, Object> parameters;

  /**
   * Builder.
   */
  public static class Builder {
    private String toolchainId;
    private String toolTypeId;
    private String name;
    private Map<String, Object> parameters;

    /**
     * Instantiates a new Builder from an existing CreateToolOptions instance.
     *
     * @param createToolOptions the instance to initialize the Builder with
     */
    private Builder(CreateToolOptions createToolOptions) {
      this.toolchainId = createToolOptions.toolchainId;
      this.toolTypeId = createToolOptions.toolTypeId;
      this.name = createToolOptions.name;
      this.parameters = createToolOptions.parameters;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param toolchainId the toolchainId
     * @param toolTypeId the toolTypeId
     */
    public Builder(String toolchainId, String toolTypeId) {
      this.toolchainId = toolchainId;
      this.toolTypeId = toolTypeId;
    }

    /**
     * Builds a CreateToolOptions.
     *
     * @return the new CreateToolOptions instance
     */
    public CreateToolOptions build() {
      return new CreateToolOptions(this);
    }

    /**
     * Set the toolchainId.
     *
     * @param toolchainId the toolchainId
     * @return the CreateToolOptions builder
     */
    public Builder toolchainId(String toolchainId) {
      this.toolchainId = toolchainId;
      return this;
    }

    /**
     * Set the toolTypeId.
     *
     * @param toolTypeId the toolTypeId
     * @return the CreateToolOptions builder
     */
    public Builder toolTypeId(String toolTypeId) {
      this.toolTypeId = toolTypeId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateToolOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the parameters.
     *
     * @param parameters the parameters
     * @return the CreateToolOptions builder
     */
    public Builder parameters(Map<String, Object> parameters) {
      this.parameters = parameters;
      return this;
    }
  }

  protected CreateToolOptions() { }

  protected CreateToolOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.toolchainId,
      "toolchainId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.toolTypeId,
      "toolTypeId cannot be null");
    toolchainId = builder.toolchainId;
    toolTypeId = builder.toolTypeId;
    name = builder.name;
    parameters = builder.parameters;
  }

  /**
   * New builder.
   *
   * @return a CreateToolOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the toolchainId.
   *
   * ID of the toolchain to bind the tool to.
   *
   * @return the toolchainId
   */
  public String toolchainId() {
    return toolchainId;
  }

  /**
   * Gets the toolTypeId.
   *
   * The unique short name of the tool that should be provisioned. A table of `tool_type_id` values corresponding to
   * each tool integration can be found in the &lt;a
   * href="https://cloud.ibm.com/docs/ContinuousDelivery?topic=ContinuousDelivery-integrations"&gt;Configuring tool
   * integrations page&lt;/a&gt;.
   *
   * @return the toolTypeId
   */
  public String toolTypeId() {
    return toolTypeId;
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
}

