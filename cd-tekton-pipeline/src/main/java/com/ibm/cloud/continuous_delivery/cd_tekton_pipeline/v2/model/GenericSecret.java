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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Only needed for generic webhook trigger type. Secret used to start generic webhook trigger.
 */
public class GenericSecret extends GenericModel {

  /**
   * Secret type.
   */
  public interface Type {
    /** token_matches. */
    String TOKEN_MATCHES = "token_matches";
    /** digest_matches. */
    String DIGEST_MATCHES = "digest_matches";
    /** internal_validation. */
    String INTERNAL_VALIDATION = "internal_validation";
  }

  /**
   * Secret location, not needed if secret type is `internal_validation`.
   */
  public interface Source {
    /** header. */
    String HEADER = "header";
    /** payload. */
    String PAYLOAD = "payload";
    /** query. */
    String QUERY = "query";
  }

  /**
   * Algorithm used for `digest_matches` secret type. Only needed for `digest_matches` secret type.
   */
  public interface Algorithm {
    /** md4. */
    String MD4 = "md4";
    /** md5. */
    String MD5 = "md5";
    /** sha1. */
    String SHA1 = "sha1";
    /** sha256. */
    String SHA256 = "sha256";
    /** sha384. */
    String SHA384 = "sha384";
    /** sha512. */
    String SHA512 = "sha512";
    /** sha512_224. */
    String SHA512_224 = "sha512_224";
    /** sha512_256. */
    String SHA512_256 = "sha512_256";
    /** ripemd160. */
    String RIPEMD160 = "ripemd160";
  }

  protected String type;
  protected String value;
  protected String source;
  @SerializedName("key_name")
  protected String keyName;
  protected String algorithm;

  /**
   * Builder.
   */
  public static class Builder {
    private String type;
    private String value;
    private String source;
    private String keyName;
    private String algorithm;

    /**
     * Instantiates a new Builder from an existing GenericSecret instance.
     *
     * @param genericSecret the instance to initialize the Builder with
     */
    private Builder(GenericSecret genericSecret) {
      this.type = genericSecret.type;
      this.value = genericSecret.value;
      this.source = genericSecret.source;
      this.keyName = genericSecret.keyName;
      this.algorithm = genericSecret.algorithm;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a GenericSecret.
     *
     * @return the new GenericSecret instance
     */
    public GenericSecret build() {
      return new GenericSecret(this);
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the GenericSecret builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the GenericSecret builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }

    /**
     * Set the source.
     *
     * @param source the source
     * @return the GenericSecret builder
     */
    public Builder source(String source) {
      this.source = source;
      return this;
    }

    /**
     * Set the keyName.
     *
     * @param keyName the keyName
     * @return the GenericSecret builder
     */
    public Builder keyName(String keyName) {
      this.keyName = keyName;
      return this;
    }

    /**
     * Set the algorithm.
     *
     * @param algorithm the algorithm
     * @return the GenericSecret builder
     */
    public Builder algorithm(String algorithm) {
      this.algorithm = algorithm;
      return this;
    }
  }

  protected GenericSecret() { }

  protected GenericSecret(Builder builder) {
    type = builder.type;
    value = builder.value;
    source = builder.source;
    keyName = builder.keyName;
    algorithm = builder.algorithm;
  }

  /**
   * New builder.
   *
   * @return a GenericSecret builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the type.
   *
   * Secret type.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the value.
   *
   * Secret value, not needed if secret type is `internal_validation`.
   *
   * @return the value
   */
  public String value() {
    return value;
  }

  /**
   * Gets the source.
   *
   * Secret location, not needed if secret type is `internal_validation`.
   *
   * @return the source
   */
  public String source() {
    return source;
  }

  /**
   * Gets the keyName.
   *
   * Secret name, not needed if type is `internal_validation`.
   *
   * @return the keyName
   */
  public String keyName() {
    return keyName;
  }

  /**
   * Gets the algorithm.
   *
   * Algorithm used for `digest_matches` secret type. Only needed for `digest_matches` secret type.
   *
   * @return the algorithm
   */
  public String algorithm() {
    return algorithm;
  }
}

