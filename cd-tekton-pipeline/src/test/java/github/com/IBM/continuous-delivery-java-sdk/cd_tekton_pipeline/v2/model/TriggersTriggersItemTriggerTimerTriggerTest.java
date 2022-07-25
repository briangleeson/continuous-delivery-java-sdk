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
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.Concurrency;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.TriggersTriggersItemTriggerTimerTrigger;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.TriggersTriggersItemTriggerTimerTriggerPropertiesItem;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.model.Worker;
import github.com/IBM/continuous-delivery-java-sdk.cd_tekton_pipeline.v2.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the TriggersTriggersItemTriggerTimerTrigger model.
 */
public class TriggersTriggersItemTriggerTimerTriggerTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testTriggersTriggersItemTriggerTimerTrigger() throws Throwable {
    TriggersTriggersItemTriggerTimerTrigger triggersTriggersItemTriggerTimerTriggerModel = new TriggersTriggersItemTriggerTimerTrigger();
    assertNull(triggersTriggersItemTriggerTimerTriggerModel.getHref());
    assertNull(triggersTriggersItemTriggerTimerTriggerModel.getType());
    assertNull(triggersTriggersItemTriggerTimerTriggerModel.getName());
    assertNull(triggersTriggersItemTriggerTimerTriggerModel.getEventListener());
    assertNull(triggersTriggersItemTriggerTimerTriggerModel.getId());
    assertNull(triggersTriggersItemTriggerTimerTriggerModel.getXProperties());
    assertNull(triggersTriggersItemTriggerTimerTriggerModel.getTags());
    assertNull(triggersTriggersItemTriggerTimerTriggerModel.getWorker());
    assertNull(triggersTriggersItemTriggerTimerTriggerModel.getConcurrency());
    assertNull(triggersTriggersItemTriggerTimerTriggerModel.isDisabled());
    assertNull(triggersTriggersItemTriggerTimerTriggerModel.getCron());
    assertNull(triggersTriggersItemTriggerTimerTriggerModel.getTimezone());
  }
}