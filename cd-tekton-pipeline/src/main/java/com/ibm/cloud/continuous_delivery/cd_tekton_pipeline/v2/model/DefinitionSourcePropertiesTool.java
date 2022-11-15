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
 * Reference to the repository tool, in the parent toolchain, that contains the pipeline definition.
 */
public class DefinitionSourcePropertiesTool extends GenericModel {

  protected String id;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;

    /**
     * Instantiates a new Builder from an existing DefinitionSourcePropertiesTool instance.
     *
     * @param definitionSourcePropertiesTool the instance to initialize the Builder with
     */
    private Builder(DefinitionSourcePropertiesTool definitionSourcePropertiesTool) {
      this.id = definitionSourcePropertiesTool.id;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a DefinitionSourcePropertiesTool.
     *
     * @return the new DefinitionSourcePropertiesTool instance
     */
    public DefinitionSourcePropertiesTool build() {
      return new DefinitionSourcePropertiesTool(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the DefinitionSourcePropertiesTool builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }
  }

  protected DefinitionSourcePropertiesTool() { }

  protected DefinitionSourcePropertiesTool(Builder builder) {
    id = builder.id;
  }

  /**
   * New builder.
   *
   * @return a DefinitionSourcePropertiesTool builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * ID of the repository tool instance in the parent toolchain.
   *
   * @return the id
   */
  public String id() {
    return id;
  }
}

