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
 * Response structure for GET tools.
 */
public class ToolchainToolCollection extends GenericModel {

  protected Long limit;
  @SerializedName("total_count")
  protected Long totalCount;
  protected ToolchainToolCollectionFirst first;
  protected ToolchainToolCollectionPrevious previous;
  protected ToolchainToolCollectionNext next;
  protected ToolchainToolCollectionLast last;
  protected List<ToolModel> tools;

  protected ToolchainToolCollection() { }

  /**
   * Gets the limit.
   *
   * Maximum number of tools returned from collection.
   *
   * @return the limit
   */
  public Long getLimit() {
    return limit;
  }

  /**
   * Gets the totalCount.
   *
   * Total number of tools found in collection.
   *
   * @return the totalCount
   */
  public Long getTotalCount() {
    return totalCount;
  }

  /**
   * Gets the first.
   *
   * Information about retrieving first tool results from the collection.
   *
   * @return the first
   */
  public ToolchainToolCollectionFirst getFirst() {
    return first;
  }

  /**
   * Gets the previous.
   *
   * Information about retrieving previous tool results from the collection.
   *
   * @return the previous
   */
  public ToolchainToolCollectionPrevious getPrevious() {
    return previous;
  }

  /**
   * Gets the next.
   *
   * Information about retrieving next tool results from the collection.
   *
   * @return the next
   */
  public ToolchainToolCollectionNext getNext() {
    return next;
  }

  /**
   * Gets the last.
   *
   * Information about retrieving last tool results from the collection.
   *
   * @return the last
   */
  public ToolchainToolCollectionLast getLast() {
    return last;
  }

  /**
   * Gets the tools.
   *
   * Tool results returned from the collection.
   *
   * @return the tools
   */
  public List<ToolModel> getTools() {
    return tools;
  }
}

