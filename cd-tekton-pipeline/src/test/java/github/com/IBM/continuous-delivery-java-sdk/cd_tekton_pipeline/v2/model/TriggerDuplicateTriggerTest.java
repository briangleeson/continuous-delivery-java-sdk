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

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.TriggerDuplicateTrigger;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the TriggerDuplicateTrigger model.
 */
public class TriggerDuplicateTriggerTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testTriggerDuplicateTrigger() throws Throwable {
    TriggerDuplicateTrigger triggerDuplicateTriggerModel = new TriggerDuplicateTrigger.Builder()
      .sourceTriggerId("testString")
      .name("start-deploy")
      .build();
    assertEquals(triggerDuplicateTriggerModel.sourceTriggerId(), "testString");
    assertEquals(triggerDuplicateTriggerModel.name(), "start-deploy");

    String json = TestUtilities.serialize(triggerDuplicateTriggerModel);

    TriggerDuplicateTrigger triggerDuplicateTriggerModelNew = TestUtilities.deserialize(json, TriggerDuplicateTrigger.class);
    assertTrue(triggerDuplicateTriggerModelNew instanceof TriggerDuplicateTrigger);
    assertEquals(triggerDuplicateTriggerModelNew.sourceTriggerId(), "testString");
    assertEquals(triggerDuplicateTriggerModelNew.name(), "start-deploy");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testTriggerDuplicateTriggerError() throws Throwable {
    new TriggerDuplicateTrigger.Builder().build();
  }

}