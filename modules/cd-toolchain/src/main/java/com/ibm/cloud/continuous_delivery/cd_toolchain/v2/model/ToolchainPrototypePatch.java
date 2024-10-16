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
import com.ibm.cloud.sdk.core.util.GsonSingleton;

/**
 * Body structure for the update toolchain PATCH request.
 */
public class ToolchainPrototypePatch extends GenericModel {

  protected String name;
  protected String description;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String description;

    /**
     * Instantiates a new Builder from an existing ToolchainPrototypePatch instance.
     *
     * @param toolchainPrototypePatch the instance to initialize the Builder with
     */
    private Builder(ToolchainPrototypePatch toolchainPrototypePatch) {
      this.name = toolchainPrototypePatch.name;
      this.description = toolchainPrototypePatch.description;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ToolchainPrototypePatch.
     *
     * @return the new ToolchainPrototypePatch instance
     */
    public ToolchainPrototypePatch build() {
      return new ToolchainPrototypePatch(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ToolchainPrototypePatch builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the ToolchainPrototypePatch builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }
  }

  protected ToolchainPrototypePatch() { }

  protected ToolchainPrototypePatch(Builder builder) {
    name = builder.name;
    description = builder.description;
  }

  /**
   * New builder.
   *
   * @return a ToolchainPrototypePatch builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * The name of the toolchain.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * An optional description.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Construct a JSON merge-patch from the ToolchainPrototypePatch.
   *
   * Note that properties of the ToolchainPrototypePatch with null values are not represented in the constructed
   * JSON merge-patch object, but can be explicitly set afterward to signify a property delete.
   *
   * @return a JSON merge-patch for the ToolchainPrototypePatch
   */
  public Map<String, Object> asPatch() {
    return GsonSingleton.getGson().fromJson(this.toString(), Map.class);
  }
}

