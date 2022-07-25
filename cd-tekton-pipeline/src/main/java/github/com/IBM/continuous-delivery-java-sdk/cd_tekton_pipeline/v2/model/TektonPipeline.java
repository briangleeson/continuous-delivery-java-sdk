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
 * Tekton pipeline object.
 */
public class TektonPipeline extends GenericModel {

  /**
   * Pipeline status.
   */
  public interface Status {
    /** configured. */
    String CONFIGURED = "configured";
    /** configuring. */
    String CONFIGURING = "configuring";
  }

  protected String name;
  protected String status;
  @SerializedName("resource_group_id")
  protected String resourceGroupId;
  protected Toolchain toolchain;
  protected String id;
  protected List<Definition> definitions;
  @SerializedName("properties")
  protected List<Property> xProperties;
  @SerializedName("updated_at")
  protected Date updatedAt;
  @SerializedName("created_at")
  protected Date createdAt;
  @SerializedName("pipeline_definition")
  protected TektonPipelinePipelineDefinition pipelineDefinition;
  protected List<Trigger> triggers;
  protected Worker worker;
  @SerializedName("runs_url")
  protected String runsUrl;
  @SerializedName("build_number")
  protected Long buildNumber;
  @SerializedName("enable_slack_notifications")
  protected Boolean enableSlackNotifications;
  @SerializedName("enable_partial_cloning")
  protected Boolean enablePartialCloning;
  protected Boolean enabled;

  /**
   * Gets the name.
   *
   * String.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the status.
   *
   * Pipeline status.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the resourceGroupId.
   *
   * ID.
   *
   * @return the resourceGroupId
   */
  public String getResourceGroupId() {
    return resourceGroupId;
  }

  /**
   * Gets the toolchain.
   *
   * Toolchain object.
   *
   * @return the toolchain
   */
  public Toolchain getToolchain() {
    return toolchain;
  }

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
   * Gets the definitions.
   *
   * Definition list.
   *
   * @return the definitions
   */
  public List<Definition> getDefinitions() {
    return definitions;
  }

  /**
   * Gets the xProperties.
   *
   * Tekton pipeline's environment properties.
   *
   * @return the xProperties
   */
  public List<Property> getXProperties() {
    return xProperties;
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
   * Gets the pipelineDefinition.
   *
   * Tekton pipeline definition object. If this property is absent or empty, the pipeline has no definitions added.
   *
   * @return the pipelineDefinition
   */
  public TektonPipelinePipelineDefinition getPipelineDefinition() {
    return pipelineDefinition;
  }

  /**
   * Gets the triggers.
   *
   * Tekton pipeline triggers list.
   *
   * @return the triggers
   */
  public List<Trigger> getTriggers() {
    return triggers;
  }

  /**
   * Gets the worker.
   *
   * Default pipeline worker used to run the pipeline.
   *
   * @return the worker
   */
  public Worker getWorker() {
    return worker;
  }

  /**
   * Gets the runsUrl.
   *
   * URL for this pipeline showing the list of pipeline runs.
   *
   * @return the runsUrl
   */
  public String getRunsUrl() {
    return runsUrl;
  }

  /**
   * Gets the buildNumber.
   *
   * The latest pipeline run build number. If this property is absent, the pipeline hasn't had any pipeline runs.
   *
   * @return the buildNumber
   */
  public Long getBuildNumber() {
    return buildNumber;
  }

  /**
   * Gets the enableSlackNotifications.
   *
   * Flag whether to enable slack notifications for this pipeline. When enabled, pipeline run events will be published
   * on all slack integration specified channels in the enclosing toolchain.
   *
   * @return the enableSlackNotifications
   */
  public Boolean isEnableSlackNotifications() {
    return enableSlackNotifications;
  }

  /**
   * Gets the enablePartialCloning.
   *
   * Flag whether to enable partial cloning for this pipeline. When partial clone is enabled, only the files contained
   * within the paths specified in definition repositories will be read and cloned. This means symbolic links may not
   * work.
   *
   * @return the enablePartialCloning
   */
  public Boolean isEnablePartialCloning() {
    return enablePartialCloning;
  }

  /**
   * Gets the enabled.
   *
   * Flag whether this pipeline is enabled.
   *
   * @return the enabled
   */
  public Boolean isEnabled() {
    return enabled;
  }
}

