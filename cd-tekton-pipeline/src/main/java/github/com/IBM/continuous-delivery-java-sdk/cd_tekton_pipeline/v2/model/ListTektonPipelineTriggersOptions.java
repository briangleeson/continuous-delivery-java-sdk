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
 * The listTektonPipelineTriggers options.
 */
public class ListTektonPipelineTriggersOptions extends GenericModel {

  protected String pipelineId;
  protected String type;
  protected String name;
  protected String eventListener;
  protected String workerId;
  protected String workerName;
  protected String disabled;
  protected String tags;

  /**
   * Builder.
   */
  public static class Builder {
    private String pipelineId;
    private String type;
    private String name;
    private String eventListener;
    private String workerId;
    private String workerName;
    private String disabled;
    private String tags;

    private Builder(ListTektonPipelineTriggersOptions listTektonPipelineTriggersOptions) {
      this.pipelineId = listTektonPipelineTriggersOptions.pipelineId;
      this.type = listTektonPipelineTriggersOptions.type;
      this.name = listTektonPipelineTriggersOptions.name;
      this.eventListener = listTektonPipelineTriggersOptions.eventListener;
      this.workerId = listTektonPipelineTriggersOptions.workerId;
      this.workerName = listTektonPipelineTriggersOptions.workerName;
      this.disabled = listTektonPipelineTriggersOptions.disabled;
      this.tags = listTektonPipelineTriggersOptions.tags;
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
     * Builds a ListTektonPipelineTriggersOptions.
     *
     * @return the new ListTektonPipelineTriggersOptions instance
     */
    public ListTektonPipelineTriggersOptions build() {
      return new ListTektonPipelineTriggersOptions(this);
    }

    /**
     * Set the pipelineId.
     *
     * @param pipelineId the pipelineId
     * @return the ListTektonPipelineTriggersOptions builder
     */
    public Builder pipelineId(String pipelineId) {
      this.pipelineId = pipelineId;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the ListTektonPipelineTriggersOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ListTektonPipelineTriggersOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the eventListener.
     *
     * @param eventListener the eventListener
     * @return the ListTektonPipelineTriggersOptions builder
     */
    public Builder eventListener(String eventListener) {
      this.eventListener = eventListener;
      return this;
    }

    /**
     * Set the workerId.
     *
     * @param workerId the workerId
     * @return the ListTektonPipelineTriggersOptions builder
     */
    public Builder workerId(String workerId) {
      this.workerId = workerId;
      return this;
    }

    /**
     * Set the workerName.
     *
     * @param workerName the workerName
     * @return the ListTektonPipelineTriggersOptions builder
     */
    public Builder workerName(String workerName) {
      this.workerName = workerName;
      return this;
    }

    /**
     * Set the disabled.
     *
     * @param disabled the disabled
     * @return the ListTektonPipelineTriggersOptions builder
     */
    public Builder disabled(String disabled) {
      this.disabled = disabled;
      return this;
    }

    /**
     * Set the tags.
     *
     * @param tags the tags
     * @return the ListTektonPipelineTriggersOptions builder
     */
    public Builder tags(String tags) {
      this.tags = tags;
      return this;
    }
  }

  protected ListTektonPipelineTriggersOptions() { }

  protected ListTektonPipelineTriggersOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.pipelineId,
      "pipelineId cannot be empty");
    pipelineId = builder.pipelineId;
    type = builder.type;
    name = builder.name;
    eventListener = builder.eventListener;
    workerId = builder.workerId;
    workerName = builder.workerName;
    disabled = builder.disabled;
    tags = builder.tags;
  }

  /**
   * New builder.
   *
   * @return a ListTektonPipelineTriggersOptions builder
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
   * Gets the type.
   *
   * Filter the triggers by "type", accepts a comma separated list of types. Valid types are "manual", "scm", "generic",
   * and "timer".
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the name.
   *
   * Filter the triggers by "name", accepts a single string value.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the eventListener.
   *
   * Filter the triggers by "event_listener", accepts a single string value.
   *
   * @return the eventListener
   */
  public String eventListener() {
    return eventListener;
  }

  /**
   * Gets the workerId.
   *
   * Filter the triggers by "worker.id", accepts a single string value.
   *
   * @return the workerId
   */
  public String workerId() {
    return workerId;
  }

  /**
   * Gets the workerName.
   *
   * Filter the triggers by "worker.name", accepts a single string value.
   *
   * @return the workerName
   */
  public String workerName() {
    return workerName;
  }

  /**
   * Gets the disabled.
   *
   * Filter the triggers by "disabled" flag, possible values are "true" or "false".
   *
   * @return the disabled
   */
  public String disabled() {
    return disabled;
  }

  /**
   * Gets the tags.
   *
   * Filter the triggers by "tags", accepts a comma separated list of tags. The response lists triggers having at least
   * one matching tag.
   *
   * @return the tags
   */
  public String tags() {
    return tags;
  }
}

