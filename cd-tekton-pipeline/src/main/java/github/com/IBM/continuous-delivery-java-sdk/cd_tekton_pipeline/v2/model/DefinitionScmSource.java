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
 * SCM source for Tekton pipeline definition.
 */
public class DefinitionScmSource extends GenericModel {

  protected String url;
  protected String branch;
  protected String tag;
  protected String path;
  @SerializedName("service_instance_id")
  protected String serviceInstanceId;

  /**
   * Builder.
   */
  public static class Builder {
    private String url;
    private String branch;
    private String tag;
    private String path;
    private String serviceInstanceId;

    private Builder(DefinitionScmSource definitionScmSource) {
      this.url = definitionScmSource.url;
      this.branch = definitionScmSource.branch;
      this.tag = definitionScmSource.tag;
      this.path = definitionScmSource.path;
      this.serviceInstanceId = definitionScmSource.serviceInstanceId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param url the url
     * @param path the path
     */
    public Builder(String url, String path) {
      this.url = url;
      this.path = path;
    }

    /**
     * Builds a DefinitionScmSource.
     *
     * @return the new DefinitionScmSource instance
     */
    public DefinitionScmSource build() {
      return new DefinitionScmSource(this);
    }

    /**
     * Set the url.
     *
     * @param url the url
     * @return the DefinitionScmSource builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }

    /**
     * Set the branch.
     *
     * @param branch the branch
     * @return the DefinitionScmSource builder
     */
    public Builder branch(String branch) {
      this.branch = branch;
      return this;
    }

    /**
     * Set the tag.
     *
     * @param tag the tag
     * @return the DefinitionScmSource builder
     */
    public Builder tag(String tag) {
      this.tag = tag;
      return this;
    }

    /**
     * Set the path.
     *
     * @param path the path
     * @return the DefinitionScmSource builder
     */
    public Builder path(String path) {
      this.path = path;
      return this;
    }

    /**
     * Set the serviceInstanceId.
     *
     * @param serviceInstanceId the serviceInstanceId
     * @return the DefinitionScmSource builder
     */
    public Builder serviceInstanceId(String serviceInstanceId) {
      this.serviceInstanceId = serviceInstanceId;
      return this;
    }
  }

  protected DefinitionScmSource() { }

  protected DefinitionScmSource(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.url,
      "url cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.path,
      "path cannot be null");
    url = builder.url;
    branch = builder.branch;
    tag = builder.tag;
    path = builder.path;
    serviceInstanceId = builder.serviceInstanceId;
  }

  /**
   * New builder.
   *
   * @return a DefinitionScmSource builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the url.
   *
   * URL of the definition repository.
   *
   * @return the url
   */
  public String url() {
    return url;
  }

  /**
   * Gets the branch.
   *
   * A branch from the repo. One of branch or tag must be specified, but only one or the other.
   *
   * @return the branch
   */
  public String branch() {
    return branch;
  }

  /**
   * Gets the tag.
   *
   * A tag from the repo. One of branch or tag must be specified, but only one or the other.
   *
   * @return the tag
   */
  public String tag() {
    return tag;
  }

  /**
   * Gets the path.
   *
   * The path to the definition's yaml files.
   *
   * @return the path
   */
  public String path() {
    return path;
  }

  /**
   * Gets the serviceInstanceId.
   *
   * ID of the SCM repository service instance.
   *
   * @return the serviceInstanceId
   */
  public String serviceInstanceId() {
    return serviceInstanceId;
  }
}

