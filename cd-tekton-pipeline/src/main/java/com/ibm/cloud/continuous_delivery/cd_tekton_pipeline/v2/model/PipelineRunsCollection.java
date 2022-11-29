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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Tekton pipeline runs object.
 */
public class PipelineRunsCollection extends GenericModel {

  @SerializedName("pipeline_runs")
  protected List<PipelineRunsCollectionPipelineRunsItem> pipelineRuns;
  protected Long limit;
  protected PipelineRunsCollectionFirst first;
  protected PipelineRunsCollectionNext next;
  protected PipelineRunsCollectionLast last;

  protected PipelineRunsCollection() { }

  /**
   * Gets the pipelineRuns.
   *
   * Tekton pipeline runs list.
   *
   * @return the pipelineRuns
   */
  public List<PipelineRunsCollectionPipelineRunsItem> getPipelineRuns() {
    return pipelineRuns;
  }

  /**
   * Gets the limit.
   *
   * The number of pipeline runs to return, sorted by creation time, most recent first.
   *
   * @return the limit
   */
  public Long getLimit() {
    return limit;
  }

  /**
   * Gets the first.
   *
   * First page of pipeline runs.
   *
   * @return the first
   */
  public PipelineRunsCollectionFirst getFirst() {
    return first;
  }

  /**
   * Gets the next.
   *
   * Next page of pipeline runs relative to the `start` and `limit` params. Only included when there are more pages
   * available.
   *
   * @return the next
   */
  public PipelineRunsCollectionNext getNext() {
    return next;
  }

  /**
   * Gets the last.
   *
   * Last page of pipeline runs relative to the `start` and `limit` params. Only included when the last page has been
   * reached.
   *
   * @return the last
   */
  public PipelineRunsCollectionLast getLast() {
    return last;
  }
}

