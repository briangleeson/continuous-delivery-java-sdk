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
 * Tekton pipeline trigger object.
 *
 * Classes which extend this class:
 * - TriggersTriggersItemTriggerDuplicateTrigger
 * - TriggersTriggersItemTriggerManualTrigger
 * - TriggersTriggersItemTriggerScmTrigger
 * - TriggersTriggersItemTriggerTimerTrigger
 * - TriggersTriggersItemTriggerGenericTrigger
 */
public class TriggersTriggersItem extends GenericModel {

  @SerializedName("source_trigger_id")
  protected String sourceTriggerId;
  protected String name;
  protected String type;
  @SerializedName("event_listener")
  protected String eventListener;
  protected String id;
  @SerializedName("properties")
  protected List<TriggerPropertiesItem> xProperties;
  protected List<String> tags;
  protected Worker worker;
  protected Concurrency concurrency;
  protected Boolean disabled;
  @SerializedName("scm_source")
  protected TriggerScmSource scmSource;
  protected Events events;
  @SerializedName("service_instance_id")
  protected String serviceInstanceId;
  protected String cron;
  protected String timezone;
  protected GenericSecret secret;
  protected String href;

  protected TriggersTriggersItem() {
  }

  /**
   * Gets the sourceTriggerId.
   *
   * source trigger ID to clone from.
   *
   * @return the sourceTriggerId
   */
  public String getSourceTriggerId() {
    return sourceTriggerId;
  }

  /**
   * Gets the name.
   *
   * name of the duplicated trigger.
   *
   * @return the name
   */
  public String getName() {
    return name;
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
   * Gets the eventListener.
   *
   * Event listener name.
   *
   * @return the eventListener
   */
  public String getEventListener() {
    return eventListener;
  }

  /**
   * Gets the id.
   *
   * Id.
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
   * Trigger worker used to run the trigger, the trigger worker overrides the default pipeline worker.If not exist, this
   * trigger uses default pipeline worker.
   *
   * @return the worker
   */
  public Worker getWorker() {
    return worker;
  }

  /**
   * Gets the concurrency.
   *
   * Concurrency object.
   *
   * @return the concurrency
   */
  public Concurrency getConcurrency() {
    return concurrency;
  }

  /**
   * Gets the disabled.
   *
   * flag whether the trigger is disabled.
   *
   * @return the disabled
   */
  public Boolean isDisabled() {
    return disabled;
  }

  /**
   * Gets the scmSource.
   *
   * Scm source for git type tekton pipeline trigger.
   *
   * @return the scmSource
   */
  public TriggerScmSource getScmSource() {
    return scmSource;
  }

  /**
   * Gets the events.
   *
   * Needed only for git trigger type. Events object defines the events this git trigger listening to.
   *
   * @return the events
   */
  public Events getEvents() {
    return events;
  }

  /**
   * Gets the serviceInstanceId.
   *
   * UUID.
   *
   * @return the serviceInstanceId
   */
  public String getServiceInstanceId() {
    return serviceInstanceId;
  }

  /**
   * Gets the cron.
   *
   * Needed only for timer trigger type. Cron expression for timer trigger. Maximum frequency is every 5 minutes.
   *
   * @return the cron
   */
  public String getCron() {
    return cron;
  }

  /**
   * Gets the timezone.
   *
   * Needed only for timer trigger type. Timezones for timer trigger.
   *
   * @return the timezone
   */
  public String getTimezone() {
    return timezone;
  }

  /**
   * Gets the secret.
   *
   * Needed only for generic trigger type. Secret used to start generic trigger.
   *
   * @return the secret
   */
  public GenericSecret getSecret() {
    return secret;
  }

  /**
   * Gets the href.
   *
   * General href URL.
   *
   * @return the href
   */
  public String getHref() {
    return href;
  }
}

