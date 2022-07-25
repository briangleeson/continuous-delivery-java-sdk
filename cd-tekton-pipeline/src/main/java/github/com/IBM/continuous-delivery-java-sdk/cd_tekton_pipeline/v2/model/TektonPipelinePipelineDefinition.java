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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Tekton pipeline definition object. If this property is absent or empty, the pipeline has no definitions added.
 */
public class TektonPipelinePipelineDefinition extends GenericModel {

  /**
   * The pipeline definition status.
   */
  public interface Status {
    /** updated. */
    String UPDATED = "updated";
    /** outdated. */
    String OUTDATED = "outdated";
    /** updating. */
    String UPDATING = "updating";
    /** failed. */
    String FAILED = "failed";
  }

  protected String status;
  protected String id;

  /**
   * Gets the status.
   *
   * The pipeline definition status.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
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
}

