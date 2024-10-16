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
 * The updateTool options.
 */
public class UpdateToolOptions extends GenericModel {

  protected String toolchainId;
  protected String toolId;
  protected Map<String, Object> toolchainToolPrototypePatch;

  /**
   * Builder.
   */
  public static class Builder {
    private String toolchainId;
    private String toolId;
    private Map<String, Object> toolchainToolPrototypePatch;

    /**
     * Instantiates a new Builder from an existing UpdateToolOptions instance.
     *
     * @param updateToolOptions the instance to initialize the Builder with
     */
    private Builder(UpdateToolOptions updateToolOptions) {
      this.toolchainId = updateToolOptions.toolchainId;
      this.toolId = updateToolOptions.toolId;
      this.toolchainToolPrototypePatch = updateToolOptions.toolchainToolPrototypePatch;
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
     * @param toolchainToolPrototypePatch the toolchainToolPrototypePatch
     */
    public Builder(String toolchainId, String toolId, Map<String, Object> toolchainToolPrototypePatch) {
      this.toolchainId = toolchainId;
      this.toolId = toolId;
      this.toolchainToolPrototypePatch = toolchainToolPrototypePatch;
    }

    /**
     * Builds a UpdateToolOptions.
     *
     * @return the new UpdateToolOptions instance
     */
    public UpdateToolOptions build() {
      return new UpdateToolOptions(this);
    }

    /**
     * Set the toolchainId.
     *
     * @param toolchainId the toolchainId
     * @return the UpdateToolOptions builder
     */
    public Builder toolchainId(String toolchainId) {
      this.toolchainId = toolchainId;
      return this;
    }

    /**
     * Set the toolId.
     *
     * @param toolId the toolId
     * @return the UpdateToolOptions builder
     */
    public Builder toolId(String toolId) {
      this.toolId = toolId;
      return this;
    }

    /**
     * Set the toolchainToolPrototypePatch.
     *
     * @param toolchainToolPrototypePatch the toolchainToolPrototypePatch
     * @return the UpdateToolOptions builder
     */
    public Builder toolchainToolPrototypePatch(Map<String, Object> toolchainToolPrototypePatch) {
      this.toolchainToolPrototypePatch = toolchainToolPrototypePatch;
      return this;
    }
  }

  protected UpdateToolOptions() { }

  protected UpdateToolOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.toolchainId,
      "toolchainId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.toolId,
      "toolId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.toolchainToolPrototypePatch,
      "toolchainToolPrototypePatch cannot be null");
    toolchainId = builder.toolchainId;
    toolId = builder.toolId;
    toolchainToolPrototypePatch = builder.toolchainToolPrototypePatch;
  }

  /**
   * New builder.
   *
   * @return a UpdateToolOptions builder
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

  /**
   * Gets the toolchainToolPrototypePatch.
   *
   * JSON Merge-Patch content for update_tool.
   *
   * @return the toolchainToolPrototypePatch
   */
  public Map<String, Object> toolchainToolPrototypePatch() {
    return toolchainToolPrototypePatch;
  }
}

