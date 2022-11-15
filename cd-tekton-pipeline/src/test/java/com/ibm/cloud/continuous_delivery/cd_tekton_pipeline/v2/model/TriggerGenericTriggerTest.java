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

import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.GenericSecret;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.TriggerGenericTrigger;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.TriggerGenericTriggerPropertiesItem;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.Worker;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the TriggerGenericTrigger model.
 */
public class TriggerGenericTriggerTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testTriggerGenericTrigger() throws Throwable {
    TriggerGenericTrigger triggerGenericTriggerModel = new TriggerGenericTrigger();
    assertNull(triggerGenericTriggerModel.getType());
    assertNull(triggerGenericTriggerModel.getName());
    assertNull(triggerGenericTriggerModel.getHref());
    assertNull(triggerGenericTriggerModel.getEventListener());
    assertNull(triggerGenericTriggerModel.getId());
    assertNull(triggerGenericTriggerModel.getXProperties());
    assertNull(triggerGenericTriggerModel.getTags());
    assertNull(triggerGenericTriggerModel.getWorker());
    assertNull(triggerGenericTriggerModel.getMaxConcurrentRuns());
    assertNull(triggerGenericTriggerModel.isEnabled());
    assertNull(triggerGenericTriggerModel.getSecret());
    assertNull(triggerGenericTriggerModel.getWebhookUrl());
  }
}