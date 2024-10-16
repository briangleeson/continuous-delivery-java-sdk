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
 * The getToolById options.
 */
public class GetToolByIdOptions extends GenericModel {

  protected String toolchainId;
  protected String toolId;

  /**
   * Builder.
   */
  public static class Builder {
    private String toolchainId;
    private String toolId;

    /**
     * Instantiates a new Builder from an existing GetToolByIdOptions instance.
     *
     * @param getToolByIdOptions the instance to initialize the Builder with
     */
    private Builder(GetToolByIdOptions getToolByIdOptions) {
      this.toolchainId = getToolByIdOptions.toolchainId;
      this.toolId = getToolByIdOptions.toolId;
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
     * Builds a GetToolByIdOptions.
     *
     * @return the new GetToolByIdOptions instance
     */
    public GetToolByIdOptions build() {
      return new GetToolByIdOptions(this);
    }

    /**
     * Set the toolchainId.
     *
     * @param toolchainId the toolchainId
     * @return the GetToolByIdOptions builder
     */
    public Builder toolchainId(String toolchainId) {
      this.toolchainId = toolchainId;
      return this;
    }

    /**
     * Set the toolId.
     *
     * @param toolId the toolId
     * @return the GetToolByIdOptions builder
     */
    public Builder toolId(String toolId) {
      this.toolId = toolId;
      return this;
    }
  }

  protected GetToolByIdOptions() { }

  protected GetToolByIdOptions(Builder builder) {
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
   * @return a GetToolByIdOptions builder
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

