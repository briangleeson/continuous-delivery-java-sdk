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
 * The listTektonPipelineProperties options.
 */
public class ListTektonPipelinePropertiesOptions extends GenericModel {

  /**
   * Query in URL.
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
  protected String name;
  protected List<String> type;
  protected String sort;

  /**
   * Builder.
   */
  public static class Builder {
    private String pipelineId;
    private String name;
    private List<String> type;
    private String sort;

    /**
     * Instantiates a new Builder from an existing ListTektonPipelinePropertiesOptions instance.
     *
     * @param listTektonPipelinePropertiesOptions the instance to initialize the Builder with
     */
    private Builder(ListTektonPipelinePropertiesOptions listTektonPipelinePropertiesOptions) {
      this.pipelineId = listTektonPipelinePropertiesOptions.pipelineId;
      this.name = listTektonPipelinePropertiesOptions.name;
      this.type = listTektonPipelinePropertiesOptions.type;
      this.sort = listTektonPipelinePropertiesOptions.sort;
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
     */
    public Builder(String pipelineId) {
      this.pipelineId = pipelineId;
    }

    /**
     * Builds a ListTektonPipelinePropertiesOptions.
     *
     * @return the new ListTektonPipelinePropertiesOptions instance
     */
    public ListTektonPipelinePropertiesOptions build() {
      return new ListTektonPipelinePropertiesOptions(this);
    }

    /**
     * Adds an type to type.
     *
     * @param type the new type
     * @return the ListTektonPipelinePropertiesOptions builder
     */
    public Builder addType(String type) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(type,
        "type cannot be null");
      if (this.type == null) {
        this.type = new ArrayList<String>();
      }
      this.type.add(type);
      return this;
    }

    /**
     * Set the pipelineId.
     *
     * @param pipelineId the pipelineId
     * @return the ListTektonPipelinePropertiesOptions builder
     */
    public Builder pipelineId(String pipelineId) {
      this.pipelineId = pipelineId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ListTektonPipelinePropertiesOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the type.
     * Existing type will be replaced.
     *
     * @param type the type
     * @return the ListTektonPipelinePropertiesOptions builder
     */
    public Builder type(List<String> type) {
      this.type = type;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListTektonPipelinePropertiesOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }
  }

  protected ListTektonPipelinePropertiesOptions() { }

  protected ListTektonPipelinePropertiesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.pipelineId,
      "pipelineId cannot be empty");
    pipelineId = builder.pipelineId;
    name = builder.name;
    type = builder.type;
    sort = builder.sort;
  }

  /**
   * New builder.
   *
   * @return a ListTektonPipelinePropertiesOptions builder
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
   * Gets the name.
   *
   * Filters the collection to resources with the specified property name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the type.
   *
   * Filters the collection to resources with the specified property type.
   *
   * @return the type
   */
  public List<String> type() {
    return type;
  }

  /**
   * Gets the sort.
   *
   * Sorts the returned properties by name, in ascending order using `name` or in descending order using `-name`.
   *
   * @return the sort
   */
  public String sort() {
    return sort;
  }
}

