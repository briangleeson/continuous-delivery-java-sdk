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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Model describing toolchain resource.
 */
public class ToolchainModel extends GenericModel {

  protected String id;
  protected String name;
  protected String description;
  @SerializedName("account_id")
  protected String accountId;
  protected String location;
  @SerializedName("resource_group_id")
  protected String resourceGroupId;
  protected String crn;
  protected String href;
  @SerializedName("ui_href")
  protected String uiHref;
  @SerializedName("created_at")
  protected Date createdAt;
  @SerializedName("updated_at")
  protected Date updatedAt;
  @SerializedName("created_by")
  protected String createdBy;

  protected ToolchainModel() { }

  /**
   * Gets the id.
   *
   * Toolchain ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the name.
   *
   * Toolchain name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * Describes the toolchain.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the accountId.
   *
   * Account ID where toolchain can be found.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the location.
   *
   * Toolchain region.
   *
   * @return the location
   */
  public String getLocation() {
    return location;
  }

  /**
   * Gets the resourceGroupId.
   *
   * Resource group where the toolchain is located.
   *
   * @return the resourceGroupId
   */
  public String getResourceGroupId() {
    return resourceGroupId;
  }

  /**
   * Gets the crn.
   *
   * Toolchain CRN.
   *
   * @return the crn
   */
  public String getCrn() {
    return crn;
  }

  /**
   * Gets the href.
   *
   * URI that can be used to retrieve toolchain.
   *
   * @return the href
   */
  public String getHref() {
    return href;
  }

  /**
   * Gets the uiHref.
   *
   * URL of a user-facing user interface for this toolchain.
   *
   * @return the uiHref
   */
  public String getUiHref() {
    return uiHref;
  }

  /**
   * Gets the createdAt.
   *
   * Toolchain creation timestamp.
   *
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the updatedAt.
   *
   * Latest toolchain update timestamp.
   *
   * @return the updatedAt
   */
  public Date getUpdatedAt() {
    return updatedAt;
  }

  /**
   * Gets the createdBy.
   *
   * Identity that created the toolchain.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }
}

