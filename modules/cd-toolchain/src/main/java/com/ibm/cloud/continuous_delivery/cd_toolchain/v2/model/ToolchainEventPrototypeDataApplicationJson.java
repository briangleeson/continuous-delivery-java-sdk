/*
 * (C) Copyright IBM Corp. 2023.
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
 * Contains JSON data to be added with the event. `content_type` must be set to `application/json`.
 */
public class ToolchainEventPrototypeDataApplicationJson extends GenericModel {

  protected Map<String, Object> content;

  /**
   * Builder.
   */
  public static class Builder {
    private Map<String, Object> content;

    /**
     * Instantiates a new Builder from an existing ToolchainEventPrototypeDataApplicationJson instance.
     *
     * @param toolchainEventPrototypeDataApplicationJson the instance to initialize the Builder with
     */
    private Builder(ToolchainEventPrototypeDataApplicationJson toolchainEventPrototypeDataApplicationJson) {
      this.content = toolchainEventPrototypeDataApplicationJson.content;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param content the content
     */
    public Builder(Map<String, Object> content) {
      this.content = content;
    }

    /**
     * Builds a ToolchainEventPrototypeDataApplicationJson.
     *
     * @return the new ToolchainEventPrototypeDataApplicationJson instance
     */
    public ToolchainEventPrototypeDataApplicationJson build() {
      return new ToolchainEventPrototypeDataApplicationJson(this);
    }

    /**
     * Set the content.
     *
     * @param content the content
     * @return the ToolchainEventPrototypeDataApplicationJson builder
     */
    public Builder content(Map<String, Object> content) {
      this.content = content;
      return this;
    }
  }

  protected ToolchainEventPrototypeDataApplicationJson() { }

  protected ToolchainEventPrototypeDataApplicationJson(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.content,
      "content cannot be null");
    content = builder.content;
  }

  /**
   * New builder.
   *
   * @return a ToolchainEventPrototypeDataApplicationJson builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the content.
   *
   * JSON-formatted key-value pairs representing any additional information to be included with the event.
   *
   * @return the content
   */
  public Map<String, Object> content() {
    return content;
  }
}

