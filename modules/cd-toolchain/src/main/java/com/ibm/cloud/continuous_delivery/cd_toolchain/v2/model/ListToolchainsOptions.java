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
 * The listToolchains options.
 */
public class ListToolchainsOptions extends GenericModel {

  protected String resourceGroupId;
  protected Long limit;
  protected String start;
  protected String name;

  /**
   * Builder.
   */
  public static class Builder {
    private String resourceGroupId;
    private Long limit;
    private String start;
    private String name;

    /**
     * Instantiates a new Builder from an existing ListToolchainsOptions instance.
     *
     * @param listToolchainsOptions the instance to initialize the Builder with
     */
    private Builder(ListToolchainsOptions listToolchainsOptions) {
      this.resourceGroupId = listToolchainsOptions.resourceGroupId;
      this.limit = listToolchainsOptions.limit;
      this.start = listToolchainsOptions.start;
      this.name = listToolchainsOptions.name;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param resourceGroupId the resourceGroupId
     */
    public Builder(String resourceGroupId) {
      this.resourceGroupId = resourceGroupId;
    }

    /**
     * Builds a ListToolchainsOptions.
     *
     * @return the new ListToolchainsOptions instance
     */
    public ListToolchainsOptions build() {
      return new ListToolchainsOptions(this);
    }

    /**
     * Set the resourceGroupId.
     *
     * @param resourceGroupId the resourceGroupId
     * @return the ListToolchainsOptions builder
     */
    public Builder resourceGroupId(String resourceGroupId) {
      this.resourceGroupId = resourceGroupId;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListToolchainsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the start.
     *
     * @param start the start
     * @return the ListToolchainsOptions builder
     */
    public Builder start(String start) {
      this.start = start;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ListToolchainsOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }
  }

  protected ListToolchainsOptions() { }

  protected ListToolchainsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.resourceGroupId,
      "resourceGroupId cannot be null");
    resourceGroupId = builder.resourceGroupId;
    limit = builder.limit;
    start = builder.start;
    name = builder.name;
  }

  /**
   * New builder.
   *
   * @return a ListToolchainsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the resourceGroupId.
   *
   * The resource group ID where the toolchains exist.
   *
   * @return the resourceGroupId
   */
  public String resourceGroupId() {
    return resourceGroupId;
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

  /**
   * Gets the name.
   *
   * Exact name of toolchain to look up. This parameter is case sensitive.
   *
   * @return the name
   */
  public String name() {
    return name;
  }
}

