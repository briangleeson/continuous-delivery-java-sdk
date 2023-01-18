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

import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.PipelineRun;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.PipelineRunWorker;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.PipelineRunsCollection;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.Property;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.RunDefinition;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.RunPipeline;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.RunsFirstPage;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.RunsLastPage;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.RunsNextPage;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.TriggerManualTrigger;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.TriggerProperty;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.UserInfo;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.Worker;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the PipelineRunsCollection model.
 */
public class PipelineRunsCollectionTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPipelineRunsCollection() throws Throwable {
    PipelineRunsCollection pipelineRunsCollectionModel = new PipelineRunsCollection();
    assertNull(pipelineRunsCollectionModel.getPipelineRuns());
    assertNull(pipelineRunsCollectionModel.getLimit());
    assertNull(pipelineRunsCollectionModel.getFirst());
    assertNull(pipelineRunsCollectionModel.getNext());
    assertNull(pipelineRunsCollectionModel.getLast());
  }
}