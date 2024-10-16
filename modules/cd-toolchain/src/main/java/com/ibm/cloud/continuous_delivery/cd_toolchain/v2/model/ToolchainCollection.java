/*
 * (C) Copyright IBM Corp. 2024.
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

package com.ibm.cloud.continuous_delivery.cd_toolchain.v2.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Response structure for GET toolchains.
 */
public class ToolchainCollection extends GenericModel {

  @SerializedName("total_count")
  protected Long totalCount;
  protected Long limit;
  protected ToolchainCollectionFirst first;
  protected ToolchainCollectionPrevious previous;
  protected ToolchainCollectionNext next;
  protected ToolchainCollectionLast last;
  protected List<ToolchainModel> toolchains;

  protected ToolchainCollection() { }

  /**
   * Gets the totalCount.
   *
   * Total number of toolchains found in collection.
   *
   * @return the totalCount
   */
  public Long getTotalCount() {
    return totalCount;
  }

  /**
   * Gets the limit.
   *
   * Maximum number of toolchains returned from collection.
   *
   * @return the limit
   */
  public Long getLimit() {
    return limit;
  }

  /**
   * Gets the first.
   *
   * Information about retrieving first toolchain results from the collection.
   *
   * @return the first
   */
  public ToolchainCollectionFirst getFirst() {
    return first;
  }

  /**
   * Gets the previous.
   *
   * Information about retrieving previous toolchain results from the collection.
   *
   * @return the previous
   */
  public ToolchainCollectionPrevious getPrevious() {
    return previous;
  }

  /**
   * Gets the next.
   *
   * Information about retrieving next toolchain results from the collection.
   *
   * @return the next
   */
  public ToolchainCollectionNext getNext() {
    return next;
  }

  /**
   * Gets the last.
   *
   * Information about retrieving last toolchain results from the collection.
   *
   * @return the last
   */
  public ToolchainCollectionLast getLast() {
    return last;
  }

  /**
   * Gets the toolchains.
   *
   * Toolchain results returned from the collection.
   *
   * @return the toolchains
   */
  public List<ToolchainModel> getToolchains() {
    return toolchains;
  }
}

