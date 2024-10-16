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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createToolchain options.
 */
public class CreateToolchainOptions extends GenericModel {

  protected String name;
  protected String resourceGroupId;
  protected String description;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String resourceGroupId;
    private String description;

    /**
     * Instantiates a new Builder from an existing CreateToolchainOptions instance.
     *
     * @param createToolchainOptions the instance to initialize the Builder with
     */
    private Builder(CreateToolchainOptions createToolchainOptions) {
      this.name = createToolchainOptions.name;
      this.resourceGroupId = createToolchainOptions.resourceGroupId;
      this.description = createToolchainOptions.description;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param name the name
     * @param resourceGroupId the resourceGroupId
     */
    public Builder(String name, String resourceGroupId) {
      this.name = name;
      this.resourceGroupId = resourceGroupId;
    }

    /**
     * Builds a CreateToolchainOptions.
     *
     * @return the new CreateToolchainOptions instance
     */
    public CreateToolchainOptions build() {
      return new CreateToolchainOptions(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateToolchainOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the resourceGroupId.
     *
     * @param resourceGroupId the resourceGroupId
     * @return the CreateToolchainOptions builder
     */
    public Builder resourceGroupId(String resourceGroupId) {
      this.resourceGroupId = resourceGroupId;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateToolchainOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }
  }

  protected CreateToolchainOptions() { }

  protected CreateToolchainOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.resourceGroupId,
      "resourceGroupId cannot be null");
    name = builder.name;
    resourceGroupId = builder.resourceGroupId;
    description = builder.description;
  }

  /**
   * New builder.
   *
   * @return a CreateToolchainOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * Toolchain name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the resourceGroupId.
   *
   * Resource group where toolchain will be created.
   *
   * @return the resourceGroupId
   */
  public String resourceGroupId() {
    return resourceGroupId;
  }

  /**
   * Gets the description.
   *
   * Describes the toolchain.
   *
   * @return the description
   */
  public String description() {
    return description;
  }
}

