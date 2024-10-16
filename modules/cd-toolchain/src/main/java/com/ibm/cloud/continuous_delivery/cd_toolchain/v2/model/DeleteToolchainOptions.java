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
 * The deleteToolchain options.
 */
public class DeleteToolchainOptions extends GenericModel {

  protected String toolchainId;

  /**
   * Builder.
   */
  public static class Builder {
    private String toolchainId;

    /**
     * Instantiates a new Builder from an existing DeleteToolchainOptions instance.
     *
     * @param deleteToolchainOptions the instance to initialize the Builder with
     */
    private Builder(DeleteToolchainOptions deleteToolchainOptions) {
      this.toolchainId = deleteToolchainOptions.toolchainId;
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
     */
    public Builder(String toolchainId) {
      this.toolchainId = toolchainId;
    }

    /**
     * Builds a DeleteToolchainOptions.
     *
     * @return the new DeleteToolchainOptions instance
     */
    public DeleteToolchainOptions build() {
      return new DeleteToolchainOptions(this);
    }

    /**
     * Set the toolchainId.
     *
     * @param toolchainId the toolchainId
     * @return the DeleteToolchainOptions builder
     */
    public Builder toolchainId(String toolchainId) {
      this.toolchainId = toolchainId;
      return this;
    }
  }

  protected DeleteToolchainOptions() { }

  protected DeleteToolchainOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.toolchainId,
      "toolchainId cannot be empty");
    toolchainId = builder.toolchainId;
  }

  /**
   * New builder.
   *
   * @return a DeleteToolchainOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the toolchainId.
   *
   * ID of the toolchain.
   *
   * @return the toolchainId
   */
  public String toolchainId() {
    return toolchainId;
  }
}

