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
 * Source repository for a Git trigger. Only required for Git triggers. The referenced repository URL must match the URL
 * of a repository tool integration in the parent toolchain. Obtain the list of integrations from the toolchain API
 * https://cloud.ibm.com/apidocs/toolchain#list-tools.
 */
public class TriggerSourcePrototype extends GenericModel {

  protected String type;
  @SerializedName("properties")
  protected TriggerSourcePropertiesPrototype xProperties;

  /**
   * Builder.
   */
  public static class Builder {
    private String type;
    private TriggerSourcePropertiesPrototype xProperties;

    /**
     * Instantiates a new Builder from an existing TriggerSourcePrototype instance.
     *
     * @param triggerSourcePrototype the instance to initialize the Builder with
     */
    private Builder(TriggerSourcePrototype triggerSourcePrototype) {
      this.type = triggerSourcePrototype.type;
      this.xProperties = triggerSourcePrototype.xProperties;
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
    public Builder(String type, TriggerSourcePropertiesPrototype xProperties) {
      this.type = type;
      this.xProperties = xProperties;
    }

    /**
     * Builds a TriggerSourcePrototype.
     *
     * @return the new TriggerSourcePrototype instance
     */
    public TriggerSourcePrototype build() {
      return new TriggerSourcePrototype(this);
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the TriggerSourcePrototype builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the xProperties.
     *
     * @param xProperties the xProperties
     * @return the TriggerSourcePrototype builder
     */
    public Builder xProperties(TriggerSourcePropertiesPrototype xProperties) {
      this.xProperties = xProperties;
      return this;
    }
  }

  protected TriggerSourcePrototype() { }

  protected TriggerSourcePrototype(Builder builder) {
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
   * @return a TriggerSourcePrototype builder
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
   * Properties of the source, which define the URL of the repository and a branch or pattern.
   *
   * @return the xProperties
   */
  public TriggerSourcePropertiesPrototype xProperties() {
    return xProperties;
  }
}

