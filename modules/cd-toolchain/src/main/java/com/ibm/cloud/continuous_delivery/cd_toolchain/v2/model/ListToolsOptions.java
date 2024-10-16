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
 * The listTools options.
 */
public class ListToolsOptions extends GenericModel {

  protected String toolchainId;
  protected Long limit;
  protected String start;

  /**
   * Builder.
   */
  public static class Builder {
    private String toolchainId;
    private Long limit;
    private String start;

    /**
     * Instantiates a new Builder from an existing ListToolsOptions instance.
     *
     * @param listToolsOptions the instance to initialize the Builder with
     */
    private Builder(ListToolsOptions listToolsOptions) {
      this.toolchainId = listToolsOptions.toolchainId;
      this.limit = listToolsOptions.limit;
      this.start = listToolsOptions.start;
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
     * Builds a ListToolsOptions.
     *
     * @return the new ListToolsOptions instance
     */
    public ListToolsOptions build() {
      return new ListToolsOptions(this);
    }

    /**
     * Set the toolchainId.
     *
     * @param toolchainId the toolchainId
     * @return the ListToolsOptions builder
     */
    public Builder toolchainId(String toolchainId) {
      this.toolchainId = toolchainId;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListToolsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the start.
     *
     * @param start the start
     * @return the ListToolsOptions builder
     */
    public Builder start(String start) {
      this.start = start;
      return this;
    }
  }

  protected ListToolsOptions() { }

  protected ListToolsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.toolchainId,
      "toolchainId cannot be empty");
    toolchainId = builder.toolchainId;
    limit = builder.limit;
    start = builder.start;
  }

  /**
   * New builder.
   *
   * @return a ListToolsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the toolchainId.
   *
   * ID of the toolchain that tools are bound to.
   *
   * @return the toolchainId
   */
  public String toolchainId() {
    return toolchainId;
  }

  /**
   * Gets the limit.
   *
   * Limit the number of results.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the start.
   *
   * Pagination token.
   *
   * @return the start
   */
  public String start() {
    return start;
  }
}

