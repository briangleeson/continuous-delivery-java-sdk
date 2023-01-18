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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Logs for a Tekton pipeline run step.
 */
public class StepLog extends GenericModel {

  protected String data;
  protected String id;

  protected StepLog() { }

  /**
   * Gets the data.
   *
   * The raw log content of the step. Only included when fetching an individual log object.
   *
   * @return the data
   */
  public String getData() {
    return data;
  }

  /**
   * Gets the id.
   *
   * Step log ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }
}

