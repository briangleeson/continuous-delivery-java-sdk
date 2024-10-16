/*
 * (C) Copyright IBM Corp. 2024.
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

package com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model;

import java.util.Date;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Response structure for GET tool.
 */
public class ToolchainTool extends GenericModel {

  /**
   * Current configuration state of the tool.
   */
  public interface State {
    /** configured. */
    String CONFIGURED = "configured";
    /** configuring. */
    String CONFIGURING = "configuring";
    /** misconfigured. */
    String MISCONFIGURED = "misconfigured";
    /** unconfigured. */
    String UNCONFIGURED = "unconfigured";
  }

  protected String id;
  @SerializedName("resource_group_id")
  protected String resourceGroupId;
  protected String crn;
  @SerializedName("tool_type_id")
  protected String toolTypeId;
  @SerializedName("toolchain_id")
  protected String toolchainId;
  @SerializedName("toolchain_crn")
  protected String toolchainCrn;
  protected String href;
  protected ToolModelReferent referent;
  protected String name;
  @SerializedName("updated_at")
  protected Date updatedAt;
  protected Map<String, Object> parameters;
  protected String state;

  protected ToolchainTool() { }

  /**
   * Gets the id.
   *
   * Tool ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the resourceGroupId.
   *
   * Resource group where the tool is located.
   *
   * @return the resourceGroupId
   */
  public String getResourceGroupId() {
    return resourceGroupId;
  }

  /**
   * Gets the crn.
   *
   * Tool CRN.
   *
   * @return the crn
   */
  public String getCrn() {
    return crn;
  }

  /**
   * Gets the toolTypeId.
   *
   * The unique name of the provisioned tool. A table of `tool_type_id` values corresponding to each tool integration
   * can be found in the &lt;a
   * href="https://cloud.ibm.com/docs/ContinuousDelivery?topic=ContinuousDelivery-integrations"&gt;Configuring tool
   * integrations page&lt;/a&gt;.
   *
   * @return the toolTypeId
   */
  public String getToolTypeId() {
    return toolTypeId;
  }

  /**
   * Gets the toolchainId.
   *
   * ID of toolchain which the tool is bound to.
   *
   * @return the toolchainId
   */
  public String getToolchainId() {
    return toolchainId;
  }

  /**
   * Gets the toolchainCrn.
   *
   * CRN of toolchain which the tool is bound to.
   *
   * @return the toolchainCrn
   */
  public String getToolchainCrn() {
    return toolchainCrn;
  }

  /**
   * Gets the href.
   *
   * URI representing the tool.
   *
   * @return the href
   */
  public String getHref() {
    return href;
  }

  /**
   * Gets the referent.
   *
   * Information on URIs to access this resource through the UI or API.
   *
   * @return the referent
   */
  public ToolModelReferent getReferent() {
    return referent;
  }

  /**
   * Gets the name.
   *
   * Name of the tool.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the updatedAt.
   *
   * Latest tool update timestamp.
   *
   * @return the updatedAt
   */
  public Date getUpdatedAt() {
    return updatedAt;
  }

  /**
   * Gets the parameters.
   *
   * Unique key-value pairs representing parameters to be used to create the tool. A list of parameters for each tool
   * integration can be found in the &lt;a
   * href="https://cloud.ibm.com/docs/ContinuousDelivery?topic=ContinuousDelivery-integrations"&gt;Configuring tool
   * integrations page&lt;/a&gt;.
   *
   * @return the parameters
   */
  public Map<String, Object> getParameters() {
    return parameters;
  }

  /**
   * Gets the state.
   *
   * Current configuration state of the tool.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }
}

