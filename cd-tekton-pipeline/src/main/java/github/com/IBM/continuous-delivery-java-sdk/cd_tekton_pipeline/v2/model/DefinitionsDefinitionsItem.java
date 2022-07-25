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
 * Tekton pipeline definition entry object.
 */
public class DefinitionsDefinitionsItem extends GenericModel {

  @SerializedName("scm_source")
  protected DefinitionScmSource scmSource;
  @SerializedName("service_instance_id")
  protected String serviceInstanceId;
  protected String id;
  protected String href;

  /**
   * Gets the scmSource.
   *
   * Scm source for tekton pipeline defintion.
   *
   * @return the scmSource
   */
  public DefinitionScmSource getScmSource() {
    return scmSource;
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
   * Gets the id.
   *
   * UUID.
   *
   * @return the id
   */
  public String getId() {
    return id;
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

