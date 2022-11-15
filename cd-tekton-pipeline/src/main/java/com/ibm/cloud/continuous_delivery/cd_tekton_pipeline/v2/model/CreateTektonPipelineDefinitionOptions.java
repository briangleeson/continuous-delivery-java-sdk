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
package com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createTektonPipelineDefinition options.
 */
public class CreateTektonPipelineDefinitionOptions extends GenericModel {

  protected String pipelineId;
  protected DefinitionSource source;

  /**
   * Builder.
   */
  public static class Builder {
    private String pipelineId;
    private DefinitionSource source;

    /**
     * Instantiates a new Builder from an existing CreateTektonPipelineDefinitionOptions instance.
     *
     * @param createTektonPipelineDefinitionOptions the instance to initialize the Builder with
     */
    private Builder(CreateTektonPipelineDefinitionOptions createTektonPipelineDefinitionOptions) {
      this.pipelineId = createTektonPipelineDefinitionOptions.pipelineId;
      this.source = createTektonPipelineDefinitionOptions.source;
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
     */
    public Builder(String pipelineId) {
      this.pipelineId = pipelineId;
    }

    /**
     * Builds a CreateTektonPipelineDefinitionOptions.
     *
     * @return the new CreateTektonPipelineDefinitionOptions instance
     */
    public CreateTektonPipelineDefinitionOptions build() {
      return new CreateTektonPipelineDefinitionOptions(this);
    }

    /**
     * Set the pipelineId.
     *
     * @param pipelineId the pipelineId
     * @return the CreateTektonPipelineDefinitionOptions builder
     */
    public Builder pipelineId(String pipelineId) {
      this.pipelineId = pipelineId;
      return this;
    }

    /**
     * Set the source.
     *
     * @param source the source
     * @return the CreateTektonPipelineDefinitionOptions builder
     */
    public Builder source(DefinitionSource source) {
      this.source = source;
      return this;
    }
  }

  protected CreateTektonPipelineDefinitionOptions() { }

  protected CreateTektonPipelineDefinitionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.pipelineId,
      "pipelineId cannot be empty");
    pipelineId = builder.pipelineId;
    source = builder.source;
  }

  /**
   * New builder.
   *
   * @return a CreateTektonPipelineDefinitionOptions builder
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

