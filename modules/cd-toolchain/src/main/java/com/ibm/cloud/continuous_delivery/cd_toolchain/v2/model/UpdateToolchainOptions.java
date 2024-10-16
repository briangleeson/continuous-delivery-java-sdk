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
 * The updateToolchain options.
 */
public class UpdateToolchainOptions extends GenericModel {

  protected String toolchainId;
  protected Map<String, Object> toolchainPrototypePatch;

  /**
   * Builder.
   */
  public static class Builder {
    private String toolchainId;
    private Map<String, Object> toolchainPrototypePatch;

    /**
     * Instantiates a new Builder from an existing UpdateToolchainOptions instance.
     *
     * @param updateToolchainOptions the instance to initialize the Builder with
     */
    private Builder(UpdateToolchainOptions updateToolchainOptions) {
      this.toolchainId = updateToolchainOptions.toolchainId;
      this.toolchainPrototypePatch = updateToolchainOptions.toolchainPrototypePatch;
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
     * @param toolchainPrototypePatch the toolchainPrototypePatch
     */
    public Builder(String toolchainId, Map<String, Object> toolchainPrototypePatch) {
      this.toolchainId = toolchainId;
      this.toolchainPrototypePatch = toolchainPrototypePatch;
    }

    /**
     * Builds a UpdateToolchainOptions.
     *
     * @return the new UpdateToolchainOptions instance
     */
    public UpdateToolchainOptions build() {
      return new UpdateToolchainOptions(this);
    }

    /**
     * Set the toolchainId.
     *
     * @param toolchainId the toolchainId
     * @return the UpdateToolchainOptions builder
     */
    public Builder toolchainId(String toolchainId) {
      this.toolchainId = toolchainId;
      return this;
    }

    /**
     * Set the toolchainPrototypePatch.
     *
     * @param toolchainPrototypePatch the toolchainPrototypePatch
     * @return the UpdateToolchainOptions builder
     */
    public Builder toolchainPrototypePatch(Map<String, Object> toolchainPrototypePatch) {
      this.toolchainPrototypePatch = toolchainPrototypePatch;
      return this;
    }
  }

  protected UpdateToolchainOptions() { }

  protected UpdateToolchainOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.toolchainId,
      "toolchainId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.toolchainPrototypePatch,
      "toolchainPrototypePatch cannot be null");
    toolchainId = builder.toolchainId;
    toolchainPrototypePatch = builder.toolchainPrototypePatch;
  }

  /**
   * New builder.
   *
   * @return a UpdateToolchainOptions builder
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
   * Gets the toolchainPrototypePatch.
   *
   * JSON Merge-Patch content for update_toolchain.
   *
   * @return the toolchainPrototypePatch
   */
  public Map<String, Object> toolchainPrototypePatch() {
    return toolchainPrototypePatch;
  }
}

