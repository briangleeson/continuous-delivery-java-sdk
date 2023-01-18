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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Source repository for a Git trigger. Only required for Git triggers. The referenced repository URL must match the URL
 * of a repository tool integration in the parent toolchain. Obtain the list of integrations from the toolchain API
 * https://cloud.ibm.com/apidocs/toolchain#list-tools.
 */
public class TriggerSource extends GenericModel {

  protected String type;
  @SerializedName("properties")
  protected TriggerSourceProperties xProperties;

  protected TriggerSource() { }

  /**
   * Gets the type.
   *
   * The only supported source type is "git", indicating that the source is a git repository.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the xProperties.
   *
   * Properties of the source, which define the URL of the repository and a branch or pattern.
   *
   * @return the xProperties
   */
  public TriggerSourceProperties getXProperties() {
    return xProperties;
  }
}

