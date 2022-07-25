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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Tekton pipeline trigger.
 *
 * Classes which extend this class:
 * - TriggerManualTrigger
 * - TriggerScmTrigger
 * - TriggerTimerTrigger
 * - TriggerGenericTrigger
 */
public class Trigger extends GenericModel {

  protected String type;
  protected String name;
  protected String href;
  @SerializedName("event_listener")
  protected String eventListener;
  protected String id;
  @SerializedName("properties")
  protected List<TriggerPropertiesItem> xProperties;
  protected List<String> tags;
  protected Worker worker;
  @SerializedName("max_concurrent_runs")
  protected Long maxConcurrentRuns;
  protected Boolean disabled;
  @SerializedName("scm_source")
  protected TriggerScmSource scmSource;
  protected Events events;
  protected String cron;
  protected String timezone;
  protected GenericSecret secret;
  @SerializedName("webhook_url")
  protected String webhookUrl;

  protected Trigger() {
  }

  /**
   * Gets the type.
   *
   * Trigger type.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the name.
   *
   * Trigger name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the href.
   *
   * API URL for interacting with the trigger.
   *
   * @return the href
   */
  public String getHref() {
    return href;
  }

  /**
   * Gets the eventListener.
   *
   * Event listener name. The name of the event listener to which the trigger is associated. The event listeners are
   * defined in the definition repositories of the Tekton pipeline.
   *
   * @return the eventListener
   */
  public String getEventListener() {
    return eventListener;
  }

  /**
   * Gets the id.
   *
   * ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the xProperties.
   *
   * Trigger properties.
   *
   * @return the xProperties
   */
  public List<TriggerPropertiesItem> getXProperties() {
    return xProperties;
  }

  /**
   * Gets the tags.
   *
   * Trigger tags array.
   *
   * @return the tags
   */
  public List<String> getTags() {
    return tags;
  }

  /**
   * Gets the worker.
   *
   * Worker used to run the trigger. If not specified the trigger will use the default pipeline worker.
   *
   * @return the worker
   */
  public Worker getWorker() {
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
  public Long getMaxConcurrentRuns() {
    return maxConcurrentRuns;
  }

  /**
   * Gets the disabled.
   *
   * Flag whether the trigger is disabled. If omitted the trigger is enabled by default.
   *
   * @return the disabled
   */
  public Boolean isDisabled() {
    return disabled;
  }

  /**
   * Gets the scmSource.
   *
   * SCM source repository for a Git trigger. Only needed for Git triggers.
   *
   * @return the scmSource
   */
  public TriggerScmSource getScmSource() {
    return scmSource;
  }

  /**
   * Gets the events.
   *
   * Only needed for Git triggers. Events object defines the events to which this Git trigger listens.
   *
   * @return the events
   */
  public Events getEvents() {
    return events;
  }

  /**
   * Gets the cron.
   *
   * Only needed for timer triggers. Cron expression for timer trigger. Maximum frequency is every 5 minutes.
   *
   * @return the cron
   */
  public String getCron() {
    return cron;
  }

  /**
   * Gets the timezone.
   *
   * Only needed for timer triggers. Timezone for timer trigger.
   *
   * @return the timezone
   */
  public String getTimezone() {
    return timezone;
  }

  /**
   * Gets the secret.
   *
   * Only needed for generic webhook trigger type. Secret used to start generic webhook trigger.
   *
   * @return the secret
   */
  public GenericSecret getSecret() {
    return secret;
  }

  /**
   * Gets the webhookUrl.
   *
   * Webhook URL that can be used to trigger pipeline runs.
   *
   * @return the webhookUrl
   */
  public String getWebhookUrl() {
    return webhookUrl;
  }
}

