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
 * Default pipeline worker used to run the pipeline.
 */
public class Worker extends GenericModel {

  protected String name;
  protected String type;
  protected String id;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String type;
    private String id;

    private Builder(Worker worker) {
      this.name = worker.name;
      this.type = worker.type;
      this.id = worker.id;
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
     * Builds a Worker.
     *
     * @return the new Worker instance
     */
    public Worker build() {
      return new Worker(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the Worker builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the Worker builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the Worker builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }
  }

  protected Worker() { }

  protected Worker(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.id,
      "id cannot be null");
    name = builder.name;
    type = builder.type;
    id = builder.id;
  }

  /**
   * New builder.
   *
   * @return a Worker builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * Name of the worker. Computed based on the worker ID.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the type.
   *
   * Type of the worker. Computed based on the worker ID.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the id.
   *
   * ID of the worker.
   *
   * @return the id
   */
  public String id() {
    return id;
  }
}

