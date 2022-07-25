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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Concurrency object.
 */
public class Concurrency extends GenericModel {

  @SerializedName("max_concurrent_runs")
  protected Long maxConcurrentRuns;

  /**
   * Builder.
   */
  public static class Builder {
    private Long maxConcurrentRuns;

    private Builder(Concurrency concurrency) {
      this.maxConcurrentRuns = concurrency.maxConcurrentRuns;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Concurrency.
     *
     * @return the new Concurrency instance
     */
    public Concurrency build() {
      return new Concurrency(this);
    }

    /**
     * Set the maxConcurrentRuns.
     *
     * @param maxConcurrentRuns the maxConcurrentRuns
     * @return the Concurrency builder
     */
    public Builder maxConcurrentRuns(long maxConcurrentRuns) {
      this.maxConcurrentRuns = maxConcurrentRuns;
      return this;
    }
  }

  protected Concurrency() { }

  protected Concurrency(Builder builder) {
    maxConcurrentRuns = builder.maxConcurrentRuns;
  }

  /**
   * New builder.
   *
   * @return a Concurrency builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the maxConcurrentRuns.
   *
   * Defines the maximum number of concurrent runs for this trigger.
   *
   * @return the maxConcurrentRuns
   */
  public Long maxConcurrentRuns() {
    return maxConcurrentRuns;
  }
}

