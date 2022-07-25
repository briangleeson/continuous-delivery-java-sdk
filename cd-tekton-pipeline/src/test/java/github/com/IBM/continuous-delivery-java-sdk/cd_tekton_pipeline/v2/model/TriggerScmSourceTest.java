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
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.TriggerScmSource;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the TriggerScmSource model.
 */
public class TriggerScmSourceTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testTriggerScmSource() throws Throwable {
    TriggerScmSource triggerScmSourceModel = new TriggerScmSource.Builder()
      .url("testString")
      .branch("testString")
      .pattern("testString")
      .blindConnection(true)
      .hookId("testString")
      .serviceInstanceId("testString")
      .build();
    assertEquals(triggerScmSourceModel.url(), "testString");
    assertEquals(triggerScmSourceModel.branch(), "testString");
    assertEquals(triggerScmSourceModel.pattern(), "testString");
    assertEquals(triggerScmSourceModel.blindConnection(), Boolean.valueOf(true));
    assertEquals(triggerScmSourceModel.hookId(), "testString");
    assertEquals(triggerScmSourceModel.serviceInstanceId(), "testString");

    String json = TestUtilities.serialize(triggerScmSourceModel);

    TriggerScmSource triggerScmSourceModelNew = TestUtilities.deserialize(json, TriggerScmSource.class);
    assertTrue(triggerScmSourceModelNew instanceof TriggerScmSource);
    assertEquals(triggerScmSourceModelNew.url(), "testString");
    assertEquals(triggerScmSourceModelNew.branch(), "testString");
    assertEquals(triggerScmSourceModelNew.pattern(), "testString");
    assertEquals(triggerScmSourceModelNew.blindConnection(), Boolean.valueOf(true));
    assertEquals(triggerScmSourceModelNew.hookId(), "testString");
    assertEquals(triggerScmSourceModelNew.serviceInstanceId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testTriggerScmSourceError() throws Throwable {
    new TriggerScmSource.Builder().build();
  }

}