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
 * The deleteTool options.
 */
public class DeleteToolOptions extends GenericModel {

  protected String toolchainId;
  protected String toolId;

  /**
   * Builder.
   */
  public static class Builder {
    private String toolchainId;
    private String toolId;

    /**
     * Instantiates a new Builder from an existing DeleteToolOptions instance.
     *
     * @param deleteToolOptions the instance to initialize the Builder with
     */
    private Builder(DeleteToolOptions deleteToolOptions) {
      this.toolchainId = deleteToolOptions.toolchainId;
      this.toolId = deleteToolOptions.toolId;
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
     * @param toolId the toolId
     */
    public Builder(String toolchainId, String toolId) {
      this.toolchainId = toolchainId;
      this.toolId = toolId;
    }

    /**
     * Builds a DeleteToolOptions.
     *
     * @return the new DeleteToolOptions instance
     */
    public DeleteToolOptions build() {
      return new DeleteToolOptions(this);
    }

    /**
     * Set the toolchainId.
     *
     * @param toolchainId the toolchainId
     * @return the DeleteToolOptions builder
     */
    public Builder toolchainId(String toolchainId) {
      this.toolchainId = toolchainId;
      return this;
    }

    /**
     * Set the toolId.
     *
     * @param toolId the toolId
     * @return the DeleteToolOptions builder
     */
    public Builder toolId(String toolId) {
      this.toolId = toolId;
      return this;
    }
  }

  protected DeleteToolOptions() { }

  protected DeleteToolOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.toolchainId,
      "toolchainId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.toolId,
      "toolId cannot be empty");
    toolchainId = builder.toolchainId;
    toolId = builder.toolId;
  }

  /**
   * New builder.
   *
   * @return a DeleteToolOptions builder
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

  /**
   * Gets the toolId.
   *
   * ID of the tool bound to the toolchain.
   *
   * @return the toolId
   */
  public String toolId() {
    return toolId;
  }
}

