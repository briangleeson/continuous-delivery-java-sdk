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
  @SerializedName("resource_group")
  protected ResourceGroupReference resourceGroup;
  protected ToolchainReference toolchain;
  protected String id;
  protected List<Definition> definitions;
  @SerializedName("properties")
  protected List<Property> xProperties;
  @SerializedName("updated_at")
  protected Date updatedAt;
  @SerializedName("created_at")
  protected Date createdAt;
  protected List<Trigger> triggers;
  protected Worker worker;
  @SerializedName("runs_url")
  protected String runsUrl;
  protected String href;
  @SerializedName("build_number")
  protected Long buildNumber;
  @SerializedName("next_build_number")
  protected Long nextBuildNumber;
  @SerializedName("enable_notifications")
  protected Boolean enableNotifications;
  @SerializedName("enable_partial_cloning")
  protected Boolean enablePartialCloning;
  protected Boolean enabled;

  protected TektonPipeline() { }

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
   * Gets the resourceGroup.
   *
   * The resource group in which the pipeline was created.
   *
   * @return the resourceGroup
   */
  public ResourceGroupReference getResourceGroup() {
    return resourceGroup;
  }

  /**
   * Gets the toolchain.
   *
   * Toolchain object containing references to the parent toolchain.
   *
   * @return the toolchain
   */
  public ToolchainReference getToolchain() {
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
   * Details of the worker used to run the pipeline.
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
   * Gets the href.
   *
   * API URL for interacting with the pipeline.
   *
   * @return the href
   */
  public String getHref() {
    return href;
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
   * Gets the nextBuildNumber.
   *
   * The build number that will be used for the next pipeline run.
   *
   * @return the nextBuildNumber
   */
  public Long getNextBuildNumber() {
    return nextBuildNumber;
  }

  /**
   * Gets the enableNotifications.
   *
   * Flag whether to enable notifications for this pipeline. When enabled, pipeline run events will be published on all
   * slack integration specified channels in the parent toolchain. If omitted, this feature is disabled by default.
   *
   * @return the enableNotifications
   */
  public Boolean isEnableNotifications() {
    return enableNotifications;
  }

  /**
   * Gets the enablePartialCloning.
   *
   * Flag whether to enable partial cloning for this pipeline. When partial clone is enabled, only the files contained
   * within the paths specified in definition repositories are read and cloned, this means that symbolic links might not
   * work. If omitted, this feature is disabled by default.
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

