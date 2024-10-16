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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Additional data to be added with the event. The format must correspond to the value of `content_type`.
 */
public class ToolchainEventPrototypeData extends GenericModel {

  @SerializedName("application_json")
  protected ToolchainEventPrototypeDataApplicationJson applicationJson;
  @SerializedName("text_plain")
  protected ToolchainEventPrototypeDataTextPlain textPlain;

  /**
   * Builder.
   */
  public static class Builder {
    private ToolchainEventPrototypeDataApplicationJson applicationJson;
    private ToolchainEventPrototypeDataTextPlain textPlain;

    /**
     * Instantiates a new Builder from an existing ToolchainEventPrototypeData instance.
     *
     * @param toolchainEventPrototypeData the instance to initialize the Builder with
     */
    private Builder(ToolchainEventPrototypeData toolchainEventPrototypeData) {
      this.applicationJson = toolchainEventPrototypeData.applicationJson;
      this.textPlain = toolchainEventPrototypeData.textPlain;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ToolchainEventPrototypeData.
     *
     * @return the new ToolchainEventPrototypeData instance
     */
    public ToolchainEventPrototypeData build() {
      return new ToolchainEventPrototypeData(this);
    }

    /**
     * Set the applicationJson.
     *
     * @param applicationJson the applicationJson
     * @return the ToolchainEventPrototypeData builder
     */
    public Builder applicationJson(ToolchainEventPrototypeDataApplicationJson applicationJson) {
      this.applicationJson = applicationJson;
      return this;
    }

    /**
     * Set the textPlain.
     *
     * @param textPlain the textPlain
     * @return the ToolchainEventPrototypeData builder
     */
    public Builder textPlain(ToolchainEventPrototypeDataTextPlain textPlain) {
      this.textPlain = textPlain;
      return this;
    }
  }

  protected ToolchainEventPrototypeData() { }

  protected ToolchainEventPrototypeData(Builder builder) {
    applicationJson = builder.applicationJson;
    textPlain = builder.textPlain;
  }

  /**
   * New builder.
   *
   * @return a ToolchainEventPrototypeData builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the applicationJson.
   *
   * Contains JSON data to be added with the event. `content_type` must be set to `application/json`.
   *
   * @return the applicationJson
   */
  public ToolchainEventPrototypeDataApplicationJson applicationJson() {
    return applicationJson;
  }

  /**
   * Gets the textPlain.
   *
   * Contains text data to be added with the event. `content_type` must be set to `text/plain`.
   *
   * @return the textPlain
   */
  public ToolchainEventPrototypeDataTextPlain textPlain() {
    return textPlain;
  }
}

