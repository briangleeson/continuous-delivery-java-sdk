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

/**
 * Git type trigger, which automatically triggers a pipeline run when the Tekton Pipeline Service receives a
 * corresponding Git webhook event.
 */
public class TriggerScmTrigger extends Trigger {

  /**
   * List of events. Supported options are 'push' Git webhook events, 'pull_request_closed' Git webhook events and
   * 'pull_request' for 'open pull request' or 'update pull request' Git webhook events.
   */
  public interface Events {
    /** push. */
    String PUSH = "push";
    /** pull_request. */
    String PULL_REQUEST = "pull_request";
    /** pull_request_closed. */
    String PULL_REQUEST_CLOSED = "pull_request_closed";
  }


  protected TriggerScmTrigger() { }
}

