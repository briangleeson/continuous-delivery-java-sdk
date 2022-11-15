/*
 * (C) Copyright IBM Corp. 2022.
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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The replaceTektonPipelineProperty options.
 */
public class ReplaceTektonPipelinePropertyOptions extends GenericModel {

  /**
   * Property type.
   */
  public interface Type {
    /** secure. */
    String SECURE = "secure";
    /** text. */
    String TEXT = "text";
    /** integration. */
    String INTEGRATION = "integration";
    /** single_select. */
    String SINGLE_SELECT = "single_select";
    /** appconfig. */
    String APPCONFIG = "appconfig";
  }

  protected String pipelineId;
  protected String propertyName;
  protected String name;
  protected String value;
  protected List<String> xEnum;
  protected String type;
  protected String path;

  /**
   * Builder.
   */
  public static class Builder {
    private String pipelineId;
    private String propertyName;
    private String name;
    private String value;
    private List<String> xEnum;
    private String type;
    private String path;

    /**
     * Instantiates a new Builder from an existing ReplaceTektonPipelinePropertyOptions instance.
     *
     * @param replaceTektonPipelinePropertyOptions the instance to initialize the Builder with
     */
    private Builder(ReplaceTektonPipelinePropertyOptions replaceTektonPipelinePropertyOptions) {
      this.pipelineId = replaceTektonPipelinePropertyOptions.pipelineId;
      this.propertyName = replaceTektonPipelinePropertyOptions.propertyName;
      this.name = replaceTektonPipelinePropertyOptions.name;
      this.value = replaceTektonPipelinePropertyOptions.value;
      this.xEnum = replaceTektonPipelinePropertyOptions.xEnum;
      this.type = replaceTektonPipelinePropertyOptions.type;
      this.path = replaceTektonPipelinePropertyOptions.path;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param pipelineId the pipelineId
     * @param propertyName the propertyName
     */
    public Builder(String pipelineId, String propertyName) {
      this.pipelineId = pipelineId;
      this.propertyName = propertyName;
    }

    /**
     * Builds a ReplaceTektonPipelinePropertyOptions.
     *
     * @return the new ReplaceTektonPipelinePropertyOptions instance
     */
    public ReplaceTektonPipelinePropertyOptions build() {
      return new ReplaceTektonPipelinePropertyOptions(this);
    }

    /**
     * Adds an xEnum to xEnum.
     *
     * @param xEnum the new xEnum
     * @return the ReplaceTektonPipelinePropertyOptions builder
     */
    public Builder addXEnum(String xEnum) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(xEnum,
        "xEnum cannot be null");
      if (this.xEnum == null) {
        this.xEnum = new ArrayList<String>();
      }
      this.xEnum.add(xEnum);
      return this;
    }

    /**
     * Set the pipelineId.
     *
     * @param pipelineId the pipelineId
     * @return the ReplaceTektonPipelinePropertyOptions builder
     */
    public Builder pipelineId(String pipelineId) {
      this.pipelineId = pipelineId;
      return this;
    }

    /**
     * Set the propertyName.
     *
     * @param propertyName the propertyName
     * @return the ReplaceTektonPipelinePropertyOptions builder
     */
    public Builder propertyName(String propertyName) {
      this.propertyName = propertyName;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ReplaceTektonPipelinePropertyOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the ReplaceTektonPipelinePropertyOptions builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }

    /**
     * Set the xEnum.
     * Existing xEnum will be replaced.
     *
     * @param xEnum the xEnum
     * @return the ReplaceTektonPipelinePropertyOptions builder
     */
    public Builder xEnum(List<String> xEnum) {
      this.xEnum = xEnum;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the ReplaceTektonPipelinePropertyOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the path.
     *
     * @param path the path
     * @return the ReplaceTektonPipelinePropertyOptions builder
     */
    public Builder path(String path) {
      this.path = path;
      return this;
    }
  }

  protected ReplaceTektonPipelinePropertyOptions() { }

  protected ReplaceTektonPipelinePropertyOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.pipelineId,
      "pipelineId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.propertyName,
      "propertyName cannot be empty");
    pipelineId = builder.pipelineId;
    propertyName = builder.propertyName;
    name = builder.name;
    value = builder.value;
    xEnum = builder.xEnum;
    type = builder.type;
    path = builder.path;
  }

  /**
   * New builder.
   *
   * @return a ReplaceTektonPipelinePropertyOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the pipelineId.
   *
   * The Tekton pipeline ID.
   *
   * @return the pipelineId
   */
  public String pipelineId() {
    return pipelineId;
  }

  /**
   * Gets the propertyName.
   *
   * The property name.
   *
   * @return the propertyName
   */
  public String propertyName() {
    return propertyName;
  }

  /**
   * Gets the name.
   *
   * Property name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the value.
   *
   * Property value. Any string value is valid.
   *
   * @return the value
   */
  public String value() {
    return value;
  }

  /**
   * Gets the xEnum.
   *
   * Options for `single_select` property type. Only needed when using `single_select` property type.
   *
   * @return the xEnum
   */
  public List<String> xEnum() {
    return xEnum;
  }

  /**
   * Gets the type.
   *
   * Property type.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the path.
   *
   * A dot notation path for `integration` type properties only, to select a value from the tool integration. If left
   * blank the full tool integration data will be used.
   *
   * @return the path
   */
  public String path() {
    return path;
  }
}

