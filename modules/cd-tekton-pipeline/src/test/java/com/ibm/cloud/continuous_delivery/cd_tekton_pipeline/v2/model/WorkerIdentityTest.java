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

import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.WorkerIdentity;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the WorkerIdentity model.
 */
public class WorkerIdentityTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testWorkerIdentity() throws Throwable {
    WorkerIdentity workerIdentityModel = new WorkerIdentity.Builder()
      .id("testString")
      .build();
    assertEquals(workerIdentityModel.id(), "testString");

    String json = TestUtilities.serialize(workerIdentityModel);

    WorkerIdentity workerIdentityModelNew = TestUtilities.deserialize(json, WorkerIdentity.class);
    assertTrue(workerIdentityModelNew instanceof WorkerIdentity);
    assertEquals(workerIdentityModelNew.id(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testWorkerIdentityError() throws Throwable {
    new WorkerIdentity.Builder().build();
  }

}