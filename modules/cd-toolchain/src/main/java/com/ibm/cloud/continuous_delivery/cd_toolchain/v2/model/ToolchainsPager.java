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

import com.ibm.cloud.continuous_delivery.cd_toolchain.v2.CdToolchain;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * ToolchainsPager can be used to simplify the use of the "listToolchains" method.
 */
public class ToolchainsPager {
  private static class PageContext {
    private String next;
    public String getNext() {
      return next;
    }
    public void setNext(String next) {
      this.next = next;
    }
  }

  protected boolean hasNext;
  protected ListToolchainsOptions options;
  protected CdToolchain client;
  protected PageContext pageContext;

  // Hide the default ctor.
  protected ToolchainsPager() { }

  /**
   * Constructs a new ToolchainsPager instance with the specified client and options model instance.
   * @param client the CdToolchain instance to be used to invoke the "listToolchains" method
   * @param options the ListToolchainsOptions instance to be used to invoke the "listToolchains" method
   */
  public ToolchainsPager(CdToolchain client, ListToolchainsOptions options) {
    if (options.start() != null) {
      throw new IllegalArgumentException("The options 'start' field should not be set");
    }

    this.hasNext = true;
    this.client = client;
    this.options = options.newBuilder().build();
    this.pageContext = new PageContext();
  }

  /**
   * Returns true if there are more results to be retrieved.
   * @return boolean
   */
  public boolean hasNext() {
    return hasNext;
  }

  /**
   * Returns the next page of results.
   * @return a List&lt;ToolchainModel&gt; that contains the next page of results
   */
  public List<ToolchainModel> getNext() {
    if (!hasNext()) {
      throw new NoSuchElementException("No more results available");
    }

    ListToolchainsOptions.Builder builder = this.options.newBuilder();
    if (this.pageContext.getNext() != null) {
      builder.start(this.pageContext.getNext());
    }
    this.options = builder.build();

    ToolchainCollection result = client.listToolchains(options).execute().getResult();

    String next = null;
    if (result.getNext() != null) {
      next = result.getNext().getStart();
    }
    this.pageContext.setNext(next);
    if (next == null) {
      this.hasNext = false;
    }

    return result.getToolchains();
  }

  /**
   * Returns all results by invoking getNext() repeatedly until all pages of results have been retrieved.
   * @return a List&lt;ToolchainModel&gt; containing all results returned by the "listToolchains" method
   */
  public List<ToolchainModel> getAll() {
    List<ToolchainModel> results = new ArrayList<>();
    while (hasNext()) {
      List<ToolchainModel> nextPage = getNext();
      results.addAll(nextPage);
    }
    return results;
  }
}
