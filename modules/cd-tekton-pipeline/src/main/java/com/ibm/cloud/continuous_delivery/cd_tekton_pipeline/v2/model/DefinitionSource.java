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
package com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Source repository containing the Tekton pipeline definition.
 */
public class DefinitionSource extends GenericModel {

  protected String type;
  @SerializedName("properties")
  protected DefinitionSourceProperties xProperties;

  /**
   * Builder.
   */
  public static class Builder {
    private String type;
    private DefinitionSourceProperties xProperties;

    /**
     * Instantiates a new Builder from an existing DefinitionSource instance.
     *
     * @param definitionSource the instance to initialize the Builder with
     */
    private Builder(DefinitionSource definitionSource) {
      this.type = definitionSource.type;
      this.xProperties = definitionSource.xProperties;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param type the type
     * @param xProperties the xProperties
     */
    public Builder(String type, DefinitionSourceProperties xProperties) {
      this.type = type;
      this.xProperties = xProperties;
    }

    /**
     * Builds a DefinitionSource.
     *
     * @return the new DefinitionSource instance
     */
    public DefinitionSource build() {
      return new DefinitionSource(this);
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the DefinitionSource builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the xProperties.
     *
     * @param xProperties the xProperties
     * @return the DefinitionSource builder
     */
    public Builder xProperties(DefinitionSourceProperties xProperties) {
      this.xProperties = xProperties;
      return this;
    }
  }

  protected DefinitionSource() { }

  protected DefinitionSource(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type,
      "type cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.xProperties,
      "xProperties cannot be null");
    type = builder.type;
    xProperties = builder.xProperties;
  }

  /**
   * New builder.
   *
   * @return a DefinitionSource builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the type.
   *
   * The only supported source type is "git", indicating that the source is a git repository.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the xProperties.
   *
   * Properties of the source, which define the URL of the repository and a branch or tag.
   *
   * @return the xProperties
   */
  public DefinitionSourceProperties xProperties() {
    return xProperties;
  }
}

