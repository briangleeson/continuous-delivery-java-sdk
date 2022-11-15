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

import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.PipelineRunWorker;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.PipelineRunsCollectionPipelineRunsItem;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.Property;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.TriggerManualTrigger;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.TriggerManualTriggerPropertiesItem;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.UserInfo;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.Worker;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the PipelineRunsCollectionPipelineRunsItem model.
 */
public class PipelineRunsCollectionPipelineRunsItemTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPipelineRunsCollectionPipelineRunsItem() throws Throwable {
    PipelineRunsCollectionPipelineRunsItem pipelineRunsCollectionPipelineRunsItemModel = new PipelineRunsCollectionPipelineRunsItem();
    assertNull(pipelineRunsCollectionPipelineRunsItemModel.getId());
    assertNull(pipelineRunsCollectionPipelineRunsItemModel.getUserInfo());
    assertNull(pipelineRunsCollectionPipelineRunsItemModel.getStatus());
    assertNull(pipelineRunsCollectionPipelineRunsItemModel.getDefinitionId());
    assertNull(pipelineRunsCollectionPipelineRunsItemModel.getWorker());
    assertNull(pipelineRunsCollectionPipelineRunsItemModel.getPipelineId());
    assertNull(pipelineRunsCollectionPipelineRunsItemModel.getListenerName());
    assertNull(pipelineRunsCollectionPipelineRunsItemModel.getTrigger());
    assertNull(pipelineRunsCollectionPipelineRunsItemModel.getEventParamsBlob());
    assertNull(pipelineRunsCollectionPipelineRunsItemModel.getTriggerHeaders());
    assertNull(pipelineRunsCollectionPipelineRunsItemModel.getXProperties());
    assertNull(pipelineRunsCollectionPipelineRunsItemModel.getCreatedAt());
    assertNull(pipelineRunsCollectionPipelineRunsItemModel.getUpdatedAt());
    assertNull(pipelineRunsCollectionPipelineRunsItemModel.getRunUrl());
    assertNull(pipelineRunsCollectionPipelineRunsItemModel.getHref());
  }
}