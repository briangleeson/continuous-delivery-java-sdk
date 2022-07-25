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
package github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listTektonPipelineTriggerProperties options.
 */
public class ListTektonPipelineTriggerPropertiesOptions extends GenericModel {

  protected String pipelineId;
  protected String triggerId;
  protected String name;
  protected String type;
  protected String sort;

  /**
   * Builder.
   */
  public static class Builder {
    private String pipelineId;
    private String triggerId;
    private String name;
    private String type;
    private String sort;

    private Builder(ListTektonPipelineTriggerPropertiesOptions listTektonPipelineTriggerPropertiesOptions) {
      this.pipelineId = listTektonPipelineTriggerPropertiesOptions.pipelineId;
      this.triggerId = listTektonPipelineTriggerPropertiesOptions.triggerId;
      this.name = listTektonPipelineTriggerPropertiesOptions.name;
      this.type = listTektonPipelineTriggerPropertiesOptions.type;
      this.sort = listTektonPipelineTriggerPropertiesOptions.sort;
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
     * @param triggerId the triggerId
     * @param name the name
     * @param type the type
     * @param sort the sort
     */
    public Builder(String pipelineId, String triggerId, String name, String type, String sort) {
      this.pipelineId = pipelineId;
      this.triggerId = triggerId;
      this.name = name;
      this.type = type;
      this.sort = sort;
    }

    /**
     * Builds a ListTektonPipelineTriggerPropertiesOptions.
     *
     * @return the new ListTektonPipelineTriggerPropertiesOptions instance
     */
    public ListTektonPipelineTriggerPropertiesOptions build() {
      return new ListTektonPipelineTriggerPropertiesOptions(this);
    }

    /**
     * Set the pipelineId.
     *
     * @param pipelineId the pipelineId
     * @return the ListTektonPipelineTriggerPropertiesOptions builder
     */
    public Builder pipelineId(String pipelineId) {
      this.pipelineId = pipelineId;
      return this;
    }

    /**
     * Set the triggerId.
     *
     * @param triggerId the triggerId
     * @return the ListTektonPipelineTriggerPropertiesOptions builder
     */
    public Builder triggerId(String triggerId) {
      this.triggerId = triggerId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ListTektonPipelineTriggerPropertiesOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the ListTektonPipelineTriggerPropertiesOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListTektonPipelineTriggerPropertiesOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }
  }

  protected ListTektonPipelineTriggerPropertiesOptions() { }

  protected ListTektonPipelineTriggerPropertiesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.pipelineId,
      "pipelineId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.triggerId,
      "triggerId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type,
      "type cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.sort,
      "sort cannot be null");
    pipelineId = builder.pipelineId;
    triggerId = builder.triggerId;
    name = builder.name;
    type = builder.type;
    sort = builder.sort;
  }

  /**
   * New builder.
   *
   * @return a ListTektonPipelineTriggerPropertiesOptions builder
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
   * Gets the triggerId.
   *
   * The trigger ID.
   *
   * @return the triggerId
   */
  public String triggerId() {
    return triggerId;
  }

  /**
   * Gets the name.
   *
   * Filter properties by `name`.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the type.
   *
   * Filter properties by `type`. Valid types are `secure`, `text`, `integration`, `single_select`, `appconfig`.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the sort.
   *
   * Sort properties by name. They can be sorted in ascending order using `name` or in descending order using `-name`.
   *
   * @return the sort
   */
  public String sort() {
    return sort;
  }
}

