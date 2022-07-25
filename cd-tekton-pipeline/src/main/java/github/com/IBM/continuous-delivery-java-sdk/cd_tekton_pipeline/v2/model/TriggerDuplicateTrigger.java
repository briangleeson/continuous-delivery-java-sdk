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

/**
 * request body to duplicate trigger.
 */
public class TriggerDuplicateTrigger extends Trigger {


  /**
   * Builder.
   */
  public static class Builder {
    private String sourceTriggerId;
    private String name;

    public Builder(Trigger triggerDuplicateTrigger) {
      this.sourceTriggerId = triggerDuplicateTrigger.sourceTriggerId;
      this.name = triggerDuplicateTrigger.name;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param sourceTriggerId the sourceTriggerId
     * @param name the name
     */
    public Builder(String sourceTriggerId, String name) {
      this.sourceTriggerId = sourceTriggerId;
      this.name = name;
    }

    /**
     * Builds a TriggerDuplicateTrigger.
     *
     * @return the new TriggerDuplicateTrigger instance
     */
    public TriggerDuplicateTrigger build() {
      return new TriggerDuplicateTrigger(this);
    }

    /**
     * Set the sourceTriggerId.
     *
     * @param sourceTriggerId the sourceTriggerId
     * @return the TriggerDuplicateTrigger builder
     */
    public Builder sourceTriggerId(String sourceTriggerId) {
      this.sourceTriggerId = sourceTriggerId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the TriggerDuplicateTrigger builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }
  }

  protected TriggerDuplicateTrigger() { }

  protected TriggerDuplicateTrigger(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.sourceTriggerId,
      "sourceTriggerId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    sourceTriggerId = builder.sourceTriggerId;
    name = builder.name;
  }

  /**
   * New builder.
   *
   * @return a TriggerDuplicateTrigger builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

