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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Trigger property object.
 */
public class TriggerProperty extends GenericModel {

  /**
   * Property type.
   */
  public interface Type {
    /** secure. */
    String SECURE = "secure";
    /** text. */
    String TEXT = "text";
    /** integration. */
    String INTEGRATION = "integration";
    /** single_select. */
    String SINGLE_SELECT = "single_select";
    /** appconfig. */
    String APPCONFIG = "appconfig";
  }

  protected String name;
  protected String value;
  protected String href;
  @SerializedName("enum")
  protected List<String> xEnum;
  protected String type;
  protected String path;

  protected TriggerProperty() { }

  /**
   * Gets the name.
   *
   * Property name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the value.
   *
   * Property value. Any string value is valid.
   *
   * @return the value
   */
  public String getValue() {
    return value;
  }

  /**
   * Gets the href.
   *
   * API URL for interacting with the trigger property.
   *
   * @return the href
   */
  public String getHref() {
    return href;
  }

  /**
   * Gets the xEnum.
   *
   * Options for `single_select` property type. Only needed for `single_select` property type.
   *
   * @return the xEnum
   */
  public List<String> getXEnum() {
    return xEnum;
  }

  /**
   * Gets the type.
   *
   * Property type.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the path.
   *
   * A dot notation path for `integration` type properties only, that selects a value from the tool integration. If left
   * blank the full tool integration data will be used.
   *
   * @return the path
   */
  public String getPath() {
    return path;
  }
}

