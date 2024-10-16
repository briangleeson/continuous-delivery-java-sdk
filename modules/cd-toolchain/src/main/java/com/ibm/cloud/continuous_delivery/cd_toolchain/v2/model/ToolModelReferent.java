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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Information on URIs to access this resource through the UI or API.
 */
public class ToolModelReferent extends GenericModel {

  @SerializedName("ui_href")
  protected String uiHref;
  @SerializedName("api_href")
  protected String apiHref;

  protected ToolModelReferent() { }

  /**
   * Gets the uiHref.
   *
   * URI representing this resource through the UI.
   *
   * @return the uiHref
   */
  public String getUiHref() {
    return uiHref;
  }

  /**
   * Gets the apiHref.
   *
   * URI representing this resource through an API.
   *
   * @return the apiHref
   */
  public String getApiHref() {
    return apiHref;
  }
}

