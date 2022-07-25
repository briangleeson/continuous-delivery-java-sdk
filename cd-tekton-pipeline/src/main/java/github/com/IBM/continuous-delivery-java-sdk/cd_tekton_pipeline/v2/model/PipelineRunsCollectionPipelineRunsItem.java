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

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Single Tekton pipeline run object.
 */
public class PipelineRunsCollectionPipelineRunsItem extends GenericModel {

  /**
   * Status of the pipeline run.
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

  protected String id;
  @SerializedName("user_info")
  protected UserInfo userInfo;
  protected String status;
  @SerializedName("definition_id")
  protected String definitionId;
  protected PipelineRunWorker worker;
  @SerializedName("pipeline_id")
  protected String pipelineId;
  @SerializedName("listener_name")
  protected String listenerName;
  protected Trigger trigger;
  @SerializedName("event_params_blob")
  protected String eventParamsBlob;
  @SerializedName("event_header_params_blob")
  protected String eventHeaderParamsBlob;
  @SerializedName("properties")
  protected List<Property> xProperties;
  @SerializedName("created_at")
  protected Date createdAt;
  @SerializedName("updated_at")
  protected Date updatedAt;
  @SerializedName("run_url")
  protected String runUrl;
  protected String href;

  /**
   * Gets the id.
   *
   * UUID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the userInfo.
   *
   * User information.
   *
   * @return the userInfo
   */
  public UserInfo getUserInfo() {
    return userInfo;
  }

  /**
   * Gets the status.
   *
   * Status of the pipeline run.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the definitionId.
   *
   * The aggregated definition ID used for this pipeline run.
   *
   * @return the definitionId
   */
  public String getDefinitionId() {
    return definitionId;
  }

  /**
   * Gets the worker.
   *
   * worker details used in this pipeline run.
   *
   * @return the worker
   */
  public PipelineRunWorker getWorker() {
    return worker;
  }

  /**
   * Gets the pipelineId.
   *
   * UUID.
   *
   * @return the pipelineId
   */
  public String getPipelineId() {
    return pipelineId;
  }

  /**
   * Gets the listenerName.
   *
   * Listener name used to start the run.
   *
   * @return the listenerName
   */
  public String getListenerName() {
    return listenerName;
  }

  /**
   * Gets the trigger.
   *
   * Tekton pipeline trigger.
   *
   * @return the trigger
   */
  public Trigger getTrigger() {
    return trigger;
  }

  /**
   * Gets the eventParamsBlob.
   *
   * Event parameters object passed to this pipeline run in String format, the contents depends on the type of trigger,
   * for example, for Git trigger it includes the Git event payload.
   *
   * @return the eventParamsBlob
   */
  public String getEventParamsBlob() {
    return eventParamsBlob;
  }

  /**
   * Gets the eventHeaderParamsBlob.
   *
   * Headers passed to this pipeline run in String format.
   *
   * @return the eventHeaderParamsBlob
   */
  public String getEventHeaderParamsBlob() {
    return eventHeaderParamsBlob;
  }

  /**
   * Gets the xProperties.
   *
   * Properties used in this Tekton pipeline run.
   *
   * @return the xProperties
   */
  public List<Property> getXProperties() {
    return xProperties;
  }

  /**
   * Gets the createdAt.
   *
   * Standard RFC 3339 Date Time String.
   *
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the updatedAt.
   *
   * Standard RFC 3339 Date Time String.
   *
   * @return the updatedAt
   */
  public Date getUpdatedAt() {
    return updatedAt;
  }

  /**
   * Gets the runUrl.
   *
   * URL for the details page of this pipeline run.
   *
   * @return the runUrl
   */
  public String getRunUrl() {
    return runUrl;
  }

  /**
   * Gets the href.
   *
   * API URL for interacting with the pipeline run.
   *
   * @return the href
   */
  public String getHref() {
    return href;
  }
}

