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

import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updateTektonPipeline options.
 */
public class UpdateTektonPipelineOptions extends GenericModel {

  protected String id;
  protected Map<String, Object> tektonPipelinePatch;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private Map<String, Object> tektonPipelinePatch;

    private Builder(UpdateTektonPipelineOptions updateTektonPipelineOptions) {
      this.id = updateTektonPipelineOptions.id;
      this.tektonPipelinePatch = updateTektonPipelineOptions.tektonPipelinePatch;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param id the id
     */
    public Builder(String id) {
      this.id = id;
    }

    /**
     * Builds a UpdateTektonPipelineOptions.
     *
     * @return the new UpdateTektonPipelineOptions instance
     */
    public UpdateTektonPipelineOptions build() {
      return new UpdateTektonPipelineOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the UpdateTektonPipelineOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the tektonPipelinePatch.
     *
     * @param tektonPipelinePatch the tektonPipelinePatch
     * @return the UpdateTektonPipelineOptions builder
     */
    public Builder tektonPipelinePatch(Map<String, Object> tektonPipelinePatch) {
      this.tektonPipelinePatch = tektonPipelinePatch;
      return this;
    }
  }

  protected UpdateTektonPipelineOptions() { }

  protected UpdateTektonPipelineOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    id = builder.id;
    tektonPipelinePatch = builder.tektonPipelinePatch;
  }

  /**
   * New builder.
   *
   * @return a UpdateTektonPipelineOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * ID of current instance.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the tektonPipelinePatch.
   *
   * JSON Merge-Patch content for update_tekton_pipeline.
   *
   * @return the tektonPipelinePatch
   */
  public Map<String, Object> tektonPipelinePatch() {
    return tektonPipelinePatch;
  }
}

