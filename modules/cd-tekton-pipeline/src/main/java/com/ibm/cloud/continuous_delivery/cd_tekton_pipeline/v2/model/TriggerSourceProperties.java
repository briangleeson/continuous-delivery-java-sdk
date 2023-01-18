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
 * Properties of the source, which define the URL of the repository and a branch or pattern.
 */
public class TriggerSourceProperties extends GenericModel {

  protected String url;
  protected String branch;
  protected String pattern;
  @SerializedName("blind_connection")
  protected Boolean blindConnection;
  @SerializedName("hook_id")
  protected String hookId;
  protected Tool tool;

  protected TriggerSourceProperties() { }

  /**
   * Gets the url.
   *
   * URL of the repository to which the trigger is listening.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Gets the branch.
   *
   * Name of a branch from the repo. One of branch or pattern must be specified, but only one or the other.
   *
   * @return the branch
   */
  public String getBranch() {
    return branch;
  }

  /**
   * Gets the pattern.
   *
   * Git branch or tag pattern to listen to, specify one of branch or pattern only. When specifying a tag to listen to,
   * you can also specify a simple glob pattern such as '!test' or '*master' to match against multiple tags/branches in
   * the repository.
   *
   * @return the pattern
   */
  public String getPattern() {
    return pattern;
  }

  /**
   * Gets the blindConnection.
   *
   * True if the repository server is not addressable on the public internet. IBM Cloud will not be able to validate the
   * connection details you provide.
   *
   * @return the blindConnection
   */
  public Boolean isBlindConnection() {
    return blindConnection;
  }

  /**
   * Gets the hookId.
   *
   * ID of the webhook from the repo. Computed upon creation of the trigger.
   *
   * @return the hookId
   */
  public String getHookId() {
    return hookId;
  }

  /**
   * Gets the tool.
   *
   * Reference to the repository tool in the parent toolchain.
   *
   * @return the tool
   */
  public Tool getTool() {
    return tool;
  }
}

