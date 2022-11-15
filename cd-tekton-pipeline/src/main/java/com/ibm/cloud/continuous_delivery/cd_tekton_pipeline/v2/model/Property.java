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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Property object.
 */
public class Property extends GenericModel {

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

  protected String name;
  protected String value;
  @SerializedName("enum")
  protected List<String> xEnum;
  protected String type;
  protected String path;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String value;
    private List<String> xEnum;
    private String type;
    private String path;

    /**
     * Instantiates a new Builder from an existing Property instance.
     *
     * @param property the instance to initialize the Builder with
     */
    private Builder(Property property) {
      this.name = property.name;
      this.value = property.value;
      this.xEnum = property.xEnum;
      this.type = property.type;
      this.path = property.path;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param name the name
     * @param type the type
     */
    public Builder(String name, String type) {
      this.name = name;
      this.type = type;
    }

    /**
     * Builds a Property.
     *
     * @return the new Property instance
     */
    public Property build() {
      return new Property(this);
    }

    /**
     * Adds an xEnum to xEnum.
     *
     * @param xEnum the new xEnum
     * @return the Property builder
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
     * Set the name.
     *
     * @param name the name
     * @return the Property builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the Property builder
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
     * @return the Property builder
     */
    public Builder xEnum(List<String> xEnum) {
      this.xEnum = xEnum;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the Property builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the path.
     *
     * @param path the path
     * @return the Property builder
     */
    public Builder path(String path) {
      this.path = path;
      return this;
    }
  }

  protected Property() { }

  protected Property(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type,
      "type cannot be null");
    name = builder.name;
    value = builder.value;
    xEnum = builder.xEnum;
    type = builder.type;
    path = builder.path;
  }

  /**
   * New builder.
   *
   * @return a Property builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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
   * A dot notation path for `integration` type properties only, that selects a value from the tool integration. If left
   * blank the full tool integration data will be used.
   *
   * @return the path
   */
  public String path() {
    return path;
  }
}

