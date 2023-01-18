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
 * The replaceTektonPipelineDefinition options.
 */
public class ReplaceTektonPipelineDefinitionOptions extends GenericModel {

  protected String pipelineId;
  protected String definitionId;
  protected DefinitionSource source;

  /**
   * Builder.
   */
  public static class Builder {
    private String pipelineId;
    private String definitionId;
    private DefinitionSource source;

    /**
     * Instantiates a new Builder from an existing ReplaceTektonPipelineDefinitionOptions instance.
     *
     * @param replaceTektonPipelineDefinitionOptions the instance to initialize the Builder with
     */
    private Builder(ReplaceTektonPipelineDefinitionOptions replaceTektonPipelineDefinitionOptions) {
      this.pipelineId = replaceTektonPipelineDefinitionOptions.pipelineId;
      this.definitionId = replaceTektonPipelineDefinitionOptions.definitionId;
      this.source = replaceTektonPipelineDefinitionOptions.source;
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
     * @param source the source
     */
    public Builder(String pipelineId, String definitionId, DefinitionSource source) {
      this.pipelineId = pipelineId;
      this.definitionId = definitionId;
      this.source = source;
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
     * Set the source.
     *
     * @param source the source
     * @return the ReplaceTektonPipelineDefinitionOptions builder
     */
    public Builder source(DefinitionSource source) {
      this.source = source;
      return this;
    }
  }

  protected ReplaceTektonPipelineDefinitionOptions() { }

  protected ReplaceTektonPipelineDefinitionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.pipelineId,
      "pipelineId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.definitionId,
      "definitionId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.source,
      "source cannot be null");
    pipelineId = builder.pipelineId;
    definitionId = builder.definitionId;
    source = builder.source;
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
   * Gets the source.
   *
   * Source repository containing the Tekton pipeline definition.
   *
   * @return the source
   */
  public DefinitionSource source() {
    return source;
  }
}

