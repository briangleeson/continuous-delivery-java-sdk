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
 * Tekton pipeline definition entry object, consisting of a repository url, a repository path and a branch or tag. The
 * referenced repository URL must match the URL of a repository tool integration in the parent toolchain. Obtain the
 * list of integrations from the toolchain API https://cloud.ibm.com/apidocs/toolchain#list-tools. The branch or tag of
 * the definition must match against a corresponding branch or tag in the chosen repository, and the path must match a
 * subfolder in the repository.
 */
public class Definition extends GenericModel {

  protected DefinitionSource source;
  protected String id;

  protected Definition() { }

  /**
   * Gets the source.
   *
   * Source repository containing the Tekton pipeline definition.
   *
   * @return the source
   */
  public DefinitionSource getSource() {
    return source;
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
}

