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

import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.GsonSingleton;

/**
 * Request body used to update this pipeline.
 */
public class TektonPipelinePatch extends GenericModel {

  @SerializedName("next_build_number")
  protected Long nextBuildNumber;
  @SerializedName("enable_notifications")
  protected Boolean enableNotifications;
  @SerializedName("enable_partial_cloning")
  protected Boolean enablePartialCloning;
  protected WorkerIdentity worker;

  /**
   * Builder.
   */
  public static class Builder {
    private Long nextBuildNumber;
    private Boolean enableNotifications;
    private Boolean enablePartialCloning;
    private WorkerIdentity worker;

    /**
     * Instantiates a new Builder from an existing TektonPipelinePatch instance.
     *
     * @param tektonPipelinePatch the instance to initialize the Builder with
     */
    private Builder(TektonPipelinePatch tektonPipelinePatch) {
      this.nextBuildNumber = tektonPipelinePatch.nextBuildNumber;
      this.enableNotifications = tektonPipelinePatch.enableNotifications;
      this.enablePartialCloning = tektonPipelinePatch.enablePartialCloning;
      this.worker = tektonPipelinePatch.worker;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a TektonPipelinePatch.
     *
     * @return the new TektonPipelinePatch instance
     */
    public TektonPipelinePatch build() {
      return new TektonPipelinePatch(this);
    }

    /**
     * Set the nextBuildNumber.
     *
     * @param nextBuildNumber the nextBuildNumber
     * @return the TektonPipelinePatch builder
     */
    public Builder nextBuildNumber(long nextBuildNumber) {
      this.nextBuildNumber = nextBuildNumber;
      return this;
    }

    /**
     * Set the enableNotifications.
     *
     * @param enableNotifications the enableNotifications
     * @return the TektonPipelinePatch builder
     */
    public Builder enableNotifications(Boolean enableNotifications) {
      this.enableNotifications = enableNotifications;
      return this;
    }

    /**
     * Set the enablePartialCloning.
     *
     * @param enablePartialCloning the enablePartialCloning
     * @return the TektonPipelinePatch builder
     */
    public Builder enablePartialCloning(Boolean enablePartialCloning) {
      this.enablePartialCloning = enablePartialCloning;
      return this;
    }

    /**
     * Set the worker.
     *
     * @param worker the worker
     * @return the TektonPipelinePatch builder
     */
    public Builder worker(WorkerIdentity worker) {
      this.worker = worker;
      return this;
    }
  }

  protected TektonPipelinePatch() { }

  protected TektonPipelinePatch(Builder builder) {
    nextBuildNumber = builder.nextBuildNumber;
    enableNotifications = builder.enableNotifications;
    enablePartialCloning = builder.enablePartialCloning;
    worker = builder.worker;
  }

  /**
   * New builder.
   *
   * @return a TektonPipelinePatch builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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
   * Worker object containing worker ID only. If omitted the IBM Managed shared workers are used by default.
   *
   * @return the worker
   */
  public WorkerIdentity worker() {
    return worker;
  }

  /**
   * Construct a JSON merge-patch from the TektonPipelinePatch.
   *
   * Note that properties of the TektonPipelinePatch with null values are not represented in the constructed
   * JSON merge-patch object, but can be explicitly set afterward to signify a property delete.
   *
   * @return a JSON merge-patch for the TektonPipelinePatch
   */
  public Map<String, Object> asPatch() {
    return GsonSingleton.getGson().fromJson(this.toString(), Map.class);
  }

}

