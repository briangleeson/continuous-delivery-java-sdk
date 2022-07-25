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
 * Trigger Property object.
 */
public class TriggersTriggersItemTriggerTimerTriggerPropertiesItem extends GenericModel {

  /**
   * Property type.
   */
  public interface Type {
    /** SECURE. */
    String SECURE = "SECURE";
    /** TEXT. */
    String TEXT = "TEXT";
    /** INTEGRATION. */
    String INTEGRATION = "INTEGRATION";
    /** SINGLE_SELECT. */
    String SINGLE_SELECT = "SINGLE_SELECT";
    /** APPCONFIG. */
    String APPCONFIG = "APPCONFIG";
  }

  protected String name;
  protected String value;
  @SerializedName("enum")
  protected List<String> xEnum;
  @SerializedName("default")
  protected String xDefault;
  protected String type;
  protected String path;
  protected String href;

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
   * String format property value.
   *
   * @return the value
   */
  public String getValue() {
    return value;
  }

  /**
   * Gets the xEnum.
   *
   * Options for SINGLE_SELECT property type.
   *
   * @return the xEnum
   */
  public List<String> getXEnum() {
    return xEnum;
  }

  /**
   * Gets the xDefault.
   *
   * Default option for SINGLE_SELECT property type.
   *
   * @return the xDefault
   */
  public String getXDefault() {
    return xDefault;
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
   * property path for INTEGRATION type properties.
   *
   * @return the path
   */
  public String getPath() {
    return path;
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

