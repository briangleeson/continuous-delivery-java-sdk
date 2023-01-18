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
 * The listTektonPipelineRuns options.
 */
public class ListTektonPipelineRunsOptions extends GenericModel {

  /**
   * Filters the collection to resources with the specified status.
   */
  public interface Status {
    /** pending. */
    String PENDING = "pending";
    /** waiting. */
    String WAITING = "waiting";
    /** queued. */
    String QUEUED = "queued";
    /** running. */
    String RUNNING = "running";
    /** cancelled. */
    String CANCELLED = "cancelled";
    /** cancelling. */
    String CANCELLING = "cancelling";
    /** failed. */
    String FAILED = "failed";
    /** error. */
    String ERROR = "error";
    /** succeeded. */
    String SUCCEEDED = "succeeded";
  }

  protected String pipelineId;
  protected String start;
  protected Long limit;
  protected String status;
  protected String triggerName;

  /**
   * Builder.
   */
  public static class Builder {
    private String pipelineId;
    private String start;
    private Long limit;
    private String status;
    private String triggerName;

    /**
     * Instantiates a new Builder from an existing ListTektonPipelineRunsOptions instance.
     *
     * @param listTektonPipelineRunsOptions the instance to initialize the Builder with
     */
    private Builder(ListTektonPipelineRunsOptions listTektonPipelineRunsOptions) {
      this.pipelineId = listTektonPipelineRunsOptions.pipelineId;
      this.start = listTektonPipelineRunsOptions.start;
      this.limit = listTektonPipelineRunsOptions.limit;
      this.status = listTektonPipelineRunsOptions.status;
      this.triggerName = listTektonPipelineRunsOptions.triggerName;
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
     * Builds a ListTektonPipelineRunsOptions.
     *
     * @return the new ListTektonPipelineRunsOptions instance
     */
    public ListTektonPipelineRunsOptions build() {
      return new ListTektonPipelineRunsOptions(this);
    }

    /**
     * Set the pipelineId.
     *
     * @param pipelineId the pipelineId
     * @return the ListTektonPipelineRunsOptions builder
     */
    public Builder pipelineId(String pipelineId) {
      this.pipelineId = pipelineId;
      return this;
    }

    /**
     * Set the start.
     *
     * @param start the start
     * @return the ListTektonPipelineRunsOptions builder
     */
    public Builder start(String start) {
      this.start = start;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListTektonPipelineRunsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the status.
     *
     * @param status the status
     * @return the ListTektonPipelineRunsOptions builder
     */
    public Builder status(String status) {
      this.status = status;
      return this;
    }

    /**
     * Set the triggerName.
     *
     * @param triggerName the triggerName
     * @return the ListTektonPipelineRunsOptions builder
     */
    public Builder triggerName(String triggerName) {
      this.triggerName = triggerName;
      return this;
    }
  }

  protected ListTektonPipelineRunsOptions() { }

  protected ListTektonPipelineRunsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.pipelineId,
      "pipelineId cannot be empty");
    pipelineId = builder.pipelineId;
    start = builder.start;
    limit = builder.limit;
    status = builder.status;
    triggerName = builder.triggerName;
  }

  /**
   * New builder.
   *
   * @return a ListTektonPipelineRunsOptions builder
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
   * Gets the start.
   *
   * A page token that identifies the start point of the list of pipeline runs. This value is included in the response
   * body of each request to fetch pipeline runs.
   *
   * @return the start
   */
  public String start() {
    return start;
  }

  /**
   * Gets the limit.
   *
   * The number of pipeline runs to return, sorted by creation time, most recent first.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the status.
   *
   * Filters the collection to resources with the specified status.
   *
   * @return the status
   */
  public String status() {
    return status;
  }

  /**
   * Gets the triggerName.
   *
   * Filters the collection to resources with the specified trigger name.
   *
   * @return the triggerName
   */
  public String triggerName() {
    return triggerName;
  }
}

