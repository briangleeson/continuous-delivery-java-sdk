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
 * The createToolchainEvent options.
 */
public class CreateToolchainEventOptions extends GenericModel {

  /**
   * The content type of the attached data. Supported values are `text/plain`, `application/json`, and `none`.
   */
  public interface ContentType {
    /** application/json. */
    String APPLICATION_JSON = "application/json";
    /** text/plain. */
    String TEXT_PLAIN = "text/plain";
    /** none. */
    String NONE = "none";
  }

  protected String toolchainId;
  protected String title;
  protected String description;
  protected String contentType;
  protected ToolchainEventPrototypeData data;

  /**
   * Builder.
   */
  public static class Builder {
    private String toolchainId;
    private String title;
    private String description;
    private String contentType;
    private ToolchainEventPrototypeData data;

    /**
     * Instantiates a new Builder from an existing CreateToolchainEventOptions instance.
     *
     * @param createToolchainEventOptions the instance to initialize the Builder with
     */
    private Builder(CreateToolchainEventOptions createToolchainEventOptions) {
      this.toolchainId = createToolchainEventOptions.toolchainId;
      this.title = createToolchainEventOptions.title;
      this.description = createToolchainEventOptions.description;
      this.contentType = createToolchainEventOptions.contentType;
      this.data = createToolchainEventOptions.data;
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
     * @param title the title
     * @param description the description
     * @param contentType the contentType
     */
    public Builder(String toolchainId, String title, String description, String contentType) {
      this.toolchainId = toolchainId;
      this.title = title;
      this.description = description;
      this.contentType = contentType;
    }

    /**
     * Builds a CreateToolchainEventOptions.
     *
     * @return the new CreateToolchainEventOptions instance
     */
    public CreateToolchainEventOptions build() {
      return new CreateToolchainEventOptions(this);
    }

    /**
     * Set the toolchainId.
     *
     * @param toolchainId the toolchainId
     * @return the CreateToolchainEventOptions builder
     */
    public Builder toolchainId(String toolchainId) {
      this.toolchainId = toolchainId;
      return this;
    }

    /**
     * Set the title.
     *
     * @param title the title
     * @return the CreateToolchainEventOptions builder
     */
    public Builder title(String title) {
      this.title = title;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateToolchainEventOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the contentType.
     *
     * @param contentType the contentType
     * @return the CreateToolchainEventOptions builder
     */
    public Builder contentType(String contentType) {
      this.contentType = contentType;
      return this;
    }

    /**
     * Set the data.
     *
     * @param data the data
     * @return the CreateToolchainEventOptions builder
     */
    public Builder data(ToolchainEventPrototypeData data) {
      this.data = data;
      return this;
    }
  }

  protected CreateToolchainEventOptions() { }

  protected CreateToolchainEventOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.toolchainId,
      "toolchainId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.title,
      "title cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.description,
      "description cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.contentType,
      "contentType cannot be null");
    toolchainId = builder.toolchainId;
    title = builder.title;
    description = builder.description;
    contentType = builder.contentType;
    data = builder.data;
  }

  /**
   * New builder.
   *
   * @return a CreateToolchainEventOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the toolchainId.
   *
   * ID of the toolchain to send events from.
   *
   * @return the toolchainId
   */
  public String toolchainId() {
    return toolchainId;
  }

  /**
   * Gets the title.
   *
   * Event title.
   *
   * @return the title
   */
  public String title() {
    return title;
  }

  /**
   * Gets the description.
   *
   * Describes the event.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the contentType.
   *
   * The content type of the attached data. Supported values are `text/plain`, `application/json`, and `none`.
   *
   * @return the contentType
   */
  public String contentType() {
    return contentType;
  }

  /**
   * Gets the data.
   *
   * Additional data to be added with the event. The format must correspond to the value of `content_type`.
   *
   * @return the data
   */
  public ToolchainEventPrototypeData data() {
    return data;
  }
}

