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
 * The deleteTektonPipelineProperty options.
 */
public class DeleteTektonPipelinePropertyOptions extends GenericModel {

  protected String pipelineId;
  protected String propertyName;

  /**
   * Builder.
   */
  public static class Builder {
    private String pipelineId;
    private String propertyName;

    private Builder(DeleteTektonPipelinePropertyOptions deleteTektonPipelinePropertyOptions) {
      this.pipelineId = deleteTektonPipelinePropertyOptions.pipelineId;
      this.propertyName = deleteTektonPipelinePropertyOptions.propertyName;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param pipelineId the pipelineId
     * @param propertyName the propertyName
     */
    public Builder(String pipelineId, String propertyName) {
      this.pipelineId = pipelineId;
      this.propertyName = propertyName;
    }

    /**
     * Builds a DeleteTektonPipelinePropertyOptions.
     *
     * @return the new DeleteTektonPipelinePropertyOptions instance
     */
    public DeleteTektonPipelinePropertyOptions build() {
      return new DeleteTektonPipelinePropertyOptions(this);
    }

    /**
     * Set the pipelineId.
     *
     * @param pipelineId the pipelineId
     * @return the DeleteTektonPipelinePropertyOptions builder
     */
    public Builder pipelineId(String pipelineId) {
      this.pipelineId = pipelineId;
      return this;
    }

    /**
     * Set the propertyName.
     *
     * @param propertyName the propertyName
     * @return the DeleteTektonPipelinePropertyOptions builder
     */
    public Builder propertyName(String propertyName) {
      this.propertyName = propertyName;
      return this;
    }
  }

  protected DeleteTektonPipelinePropertyOptions() { }

  protected DeleteTektonPipelinePropertyOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.pipelineId,
      "pipelineId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.propertyName,
      "propertyName cannot be empty");
    pipelineId = builder.pipelineId;
    propertyName = builder.propertyName;
  }

  /**
   * New builder.
   *
   * @return a DeleteTektonPipelinePropertyOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the pipelineId.
   *
   * The Tekton pipeline ID.
   *
   * @return the pipelineId
   */
  public String pipelineId() {
    return pipelineId;
  }

  /**
   * Gets the propertyName.
   *
   * The property name.
   *
   * @return the propertyName
   */
  public String propertyName() {
    return propertyName;
  }
}

