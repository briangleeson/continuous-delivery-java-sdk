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
 * Single tekton pipeline run object.
 */
public class PipelineRunsPipelineRunsItem extends GenericModel {

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
  protected Date created;
  protected Date updated;
  @SerializedName("html_url")
  protected String htmlUrl;
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
   * The aggregated definition ID used for this pipelineRun.
   *
   * @return the definitionId
   */
  public String getDefinitionId() {
    return definitionId;
  }

  /**
   * Gets the worker.
   *
   * worker details used in this pipelineRun.
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
   * Tekton pipeline trigger object.
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
   * for example, for git trigger it includes the git event payload.
   *
   * @return the eventParamsBlob
   */
  public String getEventParamsBlob() {
    return eventParamsBlob;
  }

  /**
   * Gets the eventHeaderParamsBlob.
   *
   * Heads passed to this pipeline run in String format, tekton pipeline service can't control the shape of the
   * contents.
   *
   * @return the eventHeaderParamsBlob
   */
  public String getEventHeaderParamsBlob() {
    return eventHeaderParamsBlob;
  }

  /**
   * Gets the xProperties.
   *
   * Properties used in this tekton pipeline run.
   *
   * @return the xProperties
   */
  public List<Property> getXProperties() {
    return xProperties;
  }

  /**
   * Gets the created.
   *
   * Standard RFC 3339 Date Time String.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * Standard RFC 3339 Date Time String.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * Gets the htmlUrl.
   *
   * Dashboard URL for this pipeline run.
   *
   * @return the htmlUrl
   */
  public String getHtmlUrl() {
    return htmlUrl;
  }

  /**
   * Gets the href.
   *
   * General href URL.
   *
   * @return the href
   */
  public String getHref() {
    return href;
  }
}

