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
 * Contains text data to be added with the event. `content_type` must be set to `text/plain`.
 */
public class ToolchainEventPrototypeDataTextPlain extends GenericModel {

  protected String content;

  /**
   * Builder.
   */
  public static class Builder {
    private String content;

    /**
     * Instantiates a new Builder from an existing ToolchainEventPrototypeDataTextPlain instance.
     *
     * @param toolchainEventPrototypeDataTextPlain the instance to initialize the Builder with
     */
    private Builder(ToolchainEventPrototypeDataTextPlain toolchainEventPrototypeDataTextPlain) {
      this.content = toolchainEventPrototypeDataTextPlain.content;
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
    public Builder(String content) {
      this.content = content;
    }

    /**
     * Builds a ToolchainEventPrototypeDataTextPlain.
     *
     * @return the new ToolchainEventPrototypeDataTextPlain instance
     */
    public ToolchainEventPrototypeDataTextPlain build() {
      return new ToolchainEventPrototypeDataTextPlain(this);
    }

    /**
     * Set the content.
     *
     * @param content the content
     * @return the ToolchainEventPrototypeDataTextPlain builder
     */
    public Builder content(String content) {
      this.content = content;
      return this;
    }
  }

  protected ToolchainEventPrototypeDataTextPlain() { }

  protected ToolchainEventPrototypeDataTextPlain(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.content,
      "content cannot be null");
    content = builder.content;
  }

  /**
   * New builder.
   *
   * @return a ToolchainEventPrototypeDataTextPlain builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the content.
   *
   * The text data to send in the event.
   *
   * @return the content
   */
  public String content() {
    return content;
  }
}

