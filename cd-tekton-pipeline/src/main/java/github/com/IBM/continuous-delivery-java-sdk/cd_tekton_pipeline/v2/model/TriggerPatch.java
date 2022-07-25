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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.GsonSingleton;

/**
 * Tekton pipeline trigger object used for updating the trigger.
 */
public class TriggerPatch extends GenericModel {

  /**
   * Trigger type.
   */
  public interface Type {
    /** manual. */
    String MANUAL = "manual";
    /** scm. */
    String SCM = "scm";
    /** timer. */
    String TIMER = "timer";
    /** generic. */
    String GENERIC = "generic";
  }

  protected String type;
  protected String name;
  @SerializedName("event_listener")
  protected String eventListener;
  protected List<String> tags;
  protected Worker worker;
  @SerializedName("max_concurrent_runs")
  protected Long maxConcurrentRuns;
  protected Boolean disabled;
  protected GenericSecret secret;
  protected String cron;
  protected String timezone;
  @SerializedName("scm_source")
  protected TriggerScmSource scmSource;
  protected Events events;

  /**
   * Builder.
   */
  public static class Builder {
    private String type;
    private String name;
    private String eventListener;
    private List<String> tags;
    private Worker worker;
    private Long maxConcurrentRuns;
    private Boolean disabled;
    private GenericSecret secret;
    private String cron;
    private String timezone;
    private TriggerScmSource scmSource;
    private Events events;

    private Builder(TriggerPatch triggerPatch) {
      this.type = triggerPatch.type;
      this.name = triggerPatch.name;
      this.eventListener = triggerPatch.eventListener;
      this.tags = triggerPatch.tags;
      this.worker = triggerPatch.worker;
      this.maxConcurrentRuns = triggerPatch.maxConcurrentRuns;
      this.disabled = triggerPatch.disabled;
      this.secret = triggerPatch.secret;
      this.cron = triggerPatch.cron;
      this.timezone = triggerPatch.timezone;
      this.scmSource = triggerPatch.scmSource;
      this.events = triggerPatch.events;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a TriggerPatch.
     *
     * @return the new TriggerPatch instance
     */
    public TriggerPatch build() {
      return new TriggerPatch(this);
    }

    /**
     * Adds an tags to tags.
     *
     * @param tags the new tags
     * @return the TriggerPatch builder
     */
    public Builder addTags(String tags) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(tags,
        "tags cannot be null");
      if (this.tags == null) {
        this.tags = new ArrayList<String>();
      }
      this.tags.add(tags);
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the TriggerPatch builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the TriggerPatch builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the eventListener.
     *
     * @param eventListener the eventListener
     * @return the TriggerPatch builder
     */
    public Builder eventListener(String eventListener) {
      this.eventListener = eventListener;
      return this;
    }

    /**
     * Set the tags.
     * Existing tags will be replaced.
     *
     * @param tags the tags
     * @return the TriggerPatch builder
     */
    public Builder tags(List<String> tags) {
      this.tags = tags;
      return this;
    }

    /**
     * Set the worker.
     *
     * @param worker the worker
     * @return the TriggerPatch builder
     */
    public Builder worker(Worker worker) {
      this.worker = worker;
      return this;
    }

    /**
     * Set the maxConcurrentRuns.
     *
     * @param maxConcurrentRuns the maxConcurrentRuns
     * @return the TriggerPatch builder
     */
    public Builder maxConcurrentRuns(long maxConcurrentRuns) {
      this.maxConcurrentRuns = maxConcurrentRuns;
      return this;
    }

    /**
     * Set the disabled.
     *
     * @param disabled the disabled
     * @return the TriggerPatch builder
     */
    public Builder disabled(Boolean disabled) {
      this.disabled = disabled;
      return this;
    }

    /**
     * Set the secret.
     *
     * @param secret the secret
     * @return the TriggerPatch builder
     */
    public Builder secret(GenericSecret secret) {
      this.secret = secret;
      return this;
    }

    /**
     * Set the cron.
     *
     * @param cron the cron
     * @return the TriggerPatch builder
     */
    public Builder cron(String cron) {
      this.cron = cron;
      return this;
    }

    /**
     * Set the timezone.
     *
     * @param timezone the timezone
     * @return the TriggerPatch builder
     */
    public Builder timezone(String timezone) {
      this.timezone = timezone;
      return this;
    }

    /**
     * Set the scmSource.
     *
     * @param scmSource the scmSource
     * @return the TriggerPatch builder
     */
    public Builder scmSource(TriggerScmSource scmSource) {
      this.scmSource = scmSource;
      return this;
    }

    /**
     * Set the events.
     *
     * @param events the events
     * @return the TriggerPatch builder
     */
    public Builder events(Events events) {
      this.events = events;
      return this;
    }
  }

  protected TriggerPatch() { }

  protected TriggerPatch(Builder builder) {
    type = builder.type;
    name = builder.name;
    eventListener = builder.eventListener;
    tags = builder.tags;
    worker = builder.worker;
    maxConcurrentRuns = builder.maxConcurrentRuns;
    disabled = builder.disabled;
    secret = builder.secret;
    cron = builder.cron;
    timezone = builder.timezone;
    scmSource = builder.scmSource;
    events = builder.events;
  }

  /**
   * New builder.
   *
   * @return a TriggerPatch builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the type.
   *
   * Trigger type.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the name.
   *
   * Trigger name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the eventListener.
   *
   * Event listener name. The name of the event listener to which the trigger is associated. The event listeners are
   * defined in the definition repositories of the Tekton pipeline.
   *
   * @return the eventListener
   */
  public String eventListener() {
    return eventListener;
  }

  /**
   * Gets the tags.
   *
   * Trigger tags array. Optional tags for the trigger.
   *
   * @return the tags
   */
  public List<String> tags() {
    return tags;
  }

  /**
   * Gets the worker.
   *
   * Worker used to run the trigger. If not specified the trigger will use the default pipeline worker.
   *
   * @return the worker
   */
  public Worker worker() {
    return worker;
  }

  /**
   * Gets the maxConcurrentRuns.
   *
   * Defines the maximum number of concurrent runs for this trigger. Omit this property to disable the concurrency
   * limit.
   *
   * @return the maxConcurrentRuns
   */
  public Long maxConcurrentRuns() {
    return maxConcurrentRuns;
  }

  /**
   * Gets the disabled.
   *
   * Defines if this trigger is disabled.
   *
   * @return the disabled
   */
  public Boolean disabled() {
    return disabled;
  }

  /**
   * Gets the secret.
   *
   * Only needed for generic webhook trigger type. Secret used to start generic webhook trigger.
   *
   * @return the secret
   */
  public GenericSecret secret() {
    return secret;
  }

  /**
   * Gets the cron.
   *
   * Only needed for timer triggers. Cron expression for timer trigger.
   *
   * @return the cron
   */
  public String cron() {
    return cron;
  }

  /**
   * Gets the timezone.
   *
   * Only needed for timer triggers. Timezone for timer trigger.
   *
   * @return the timezone
   */
  public String timezone() {
    return timezone;
  }

  /**
   * Gets the scmSource.
   *
   * SCM source repository for a Git trigger. Only needed for Git triggers.
   *
   * @return the scmSource
   */
  public TriggerScmSource scmSource() {
    return scmSource;
  }

  /**
   * Gets the events.
   *
   * Only needed for Git triggers. Events object defines the events to which this Git trigger listens.
   *
   * @return the events
   */
  public Events events() {
    return events;
  }

  /**
   * Construct a JSON merge-patch from the TriggerPatch.
   *
   * Note that properties of the TriggerPatch with null values are not represented in the constructed
   * JSON merge-patch object, but can be explicitly set afterward to signify a property delete.
   *
   * @return a JSON merge-patch for the TriggerPatch
   */
  public Map<String, Object> asPatch() {
    return GsonSingleton.getGson().fromJson(this.toString(), Map.class);
  }

}

