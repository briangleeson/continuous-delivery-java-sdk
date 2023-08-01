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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createTektonPipeline options.
 */
public class CreateTektonPipelineOptions extends GenericModel {

  protected String id;
  protected Long nextBuildNumber;
  protected Boolean enableNotifications;
  protected Boolean enablePartialCloning;
  protected WorkerIdentity worker;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private Long nextBuildNumber;
    private Boolean enableNotifications;
    private Boolean enablePartialCloning;
    private WorkerIdentity worker;

    /**
     * Instantiates a new Builder from an existing CreateTektonPipelineOptions instance.
     *
     * @param createTektonPipelineOptions the instance to initialize the Builder with
     */
    private Builder(CreateTektonPipelineOptions createTektonPipelineOptions) {
      this.id = createTektonPipelineOptions.id;
      this.nextBuildNumber = createTektonPipelineOptions.nextBuildNumber;
      this.enableNotifications = createTektonPipelineOptions.enableNotifications;
      this.enablePartialCloning = createTektonPipelineOptions.enablePartialCloning;
      this.worker = createTektonPipelineOptions.worker;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param id the id
     */
    public Builder(String id) {
      this.id = id;
    }

    /**
     * Builds a CreateTektonPipelineOptions.
     *
     * @return the new CreateTektonPipelineOptions instance
     */
    public CreateTektonPipelineOptions build() {
      return new CreateTektonPipelineOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the CreateTektonPipelineOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the nextBuildNumber.
     *
     * @param nextBuildNumber the nextBuildNumber
     * @return the CreateTektonPipelineOptions builder
     */
    public Builder nextBuildNumber(long nextBuildNumber) {
      this.nextBuildNumber = nextBuildNumber;
      return this;
    }

    /**
     * Set the enableNotifications.
     *
     * @param enableNotifications the enableNotifications
     * @return the CreateTektonPipelineOptions builder
     */
    public Builder enableNotifications(Boolean enableNotifications) {
      this.enableNotifications = enableNotifications;
      return this;
    }

    /**
     * Set the enablePartialCloning.
     *
     * @param enablePartialCloning the enablePartialCloning
     * @return the CreateTektonPipelineOptions builder
     */
    public Builder enablePartialCloning(Boolean enablePartialCloning) {
      this.enablePartialCloning = enablePartialCloning;
      return this;
    }

    /**
     * Set the worker.
     *
     * @param worker the worker
     * @return the CreateTektonPipelineOptions builder
     */
    public Builder worker(WorkerIdentity worker) {
      this.worker = worker;
      return this;
    }
  }

  protected CreateTektonPipelineOptions() { }

  protected CreateTektonPipelineOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.id,
      "id cannot be null");
    id = builder.id;
    nextBuildNumber = builder.nextBuildNumber;
    enableNotifications = builder.enableNotifications;
    enablePartialCloning = builder.enablePartialCloning;
    worker = builder.worker;
  }

  /**
   * New builder.
   *
   * @return a CreateTektonPipelineOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The ID for the associated pipeline tool, which was already created in the target toolchain. To get the pipeline ID
   * call the toolchain API https://cloud.ibm.com/apidocs/toolchain#list-tools and find the pipeline tool.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the nextBuildNumber.
   *
   * Specify the build number that will be used for the next pipeline run. Build numbers can be any positive whole
   * number between 0 and 100000000000000.
   *
   * @return the nextBuildNumber
   */
  public Long nextBuildNumber() {
    return nextBuildNumber;
  }

  /**
   * Gets the enableNotifications.
   *
   * Flag whether to enable notifications for this pipeline. When enabled, pipeline run events are published on all
   * slack integration specified channels in the parent toolchain.
   *
   * @return the enableNotifications
   */
  public Boolean enableNotifications() {
    return enableNotifications;
  }

  /**
   * Gets the enablePartialCloning.
   *
   * Flag whether to enable partial cloning for this pipeline. When partial clone is enabled, only the files contained
   * within the paths specified in definition repositories are read and cloned, this means that symbolic links might not
   * work.
   *
   * @return the enablePartialCloning
   */
  public Boolean enablePartialCloning() {
    return enablePartialCloning;
  }

  /**
   * Gets the worker.
   *
   * Specify the worker used to run the trigger, as a worker object containing the worker ID only. If omitted, or
   * specified as `worker: { id: 'public' }`, the IBM Managed shared workers are used.
   *
   * @return the worker
   */
  public WorkerIdentity worker() {
    return worker;
  }
}

