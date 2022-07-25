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
 * The replaceTektonPipelineDefinition options.
 */
public class ReplaceTektonPipelineDefinitionOptions extends GenericModel {

  protected String pipelineId;
  protected String definitionId;
  protected DefinitionScmSource scmSource;
  protected String id;

  /**
   * Builder.
   */
  public static class Builder {
    private String pipelineId;
    private String definitionId;
    private DefinitionScmSource scmSource;
    private String id;

    private Builder(ReplaceTektonPipelineDefinitionOptions replaceTektonPipelineDefinitionOptions) {
      this.pipelineId = replaceTektonPipelineDefinitionOptions.pipelineId;
      this.definitionId = replaceTektonPipelineDefinitionOptions.definitionId;
      this.scmSource = replaceTektonPipelineDefinitionOptions.scmSource;
      this.id = replaceTektonPipelineDefinitionOptions.id;
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
     * @param definitionId the definitionId
     */
    public Builder(String pipelineId, String definitionId) {
      this.pipelineId = pipelineId;
      this.definitionId = definitionId;
    }

    /**
     * Builds a ReplaceTektonPipelineDefinitionOptions.
     *
     * @return the new ReplaceTektonPipelineDefinitionOptions instance
     */
    public ReplaceTektonPipelineDefinitionOptions build() {
      return new ReplaceTektonPipelineDefinitionOptions(this);
    }

    /**
     * Set the pipelineId.
     *
     * @param pipelineId the pipelineId
     * @return the ReplaceTektonPipelineDefinitionOptions builder
     */
    public Builder pipelineId(String pipelineId) {
      this.pipelineId = pipelineId;
      return this;
    }

    /**
     * Set the definitionId.
     *
     * @param definitionId the definitionId
     * @return the ReplaceTektonPipelineDefinitionOptions builder
     */
    public Builder definitionId(String definitionId) {
      this.definitionId = definitionId;
      return this;
    }

    /**
     * Set the scmSource.
     *
     * @param scmSource the scmSource
     * @return the ReplaceTektonPipelineDefinitionOptions builder
     */
    public Builder scmSource(DefinitionScmSource scmSource) {
      this.scmSource = scmSource;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the ReplaceTektonPipelineDefinitionOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }
  }

  protected ReplaceTektonPipelineDefinitionOptions() { }

  protected ReplaceTektonPipelineDefinitionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.pipelineId,
      "pipelineId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.definitionId,
      "definitionId cannot be empty");
    pipelineId = builder.pipelineId;
    definitionId = builder.definitionId;
    scmSource = builder.scmSource;
    id = builder.id;
  }

  /**
   * New builder.
   *
   * @return a ReplaceTektonPipelineDefinitionOptions builder
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
   * Gets the definitionId.
   *
   * The definition ID.
   *
   * @return the definitionId
   */
  public String definitionId() {
    return definitionId;
  }

  /**
   * Gets the scmSource.
   *
   * SCM source for Tekton pipeline definition.
   *
   * @return the scmSource
   */
  public DefinitionScmSource scmSource() {
    return scmSource;
  }

  /**
   * Gets the id.
   *
   * UUID.
   *
   * @return the id
   */
  public String id() {
    return id;
  }
}

