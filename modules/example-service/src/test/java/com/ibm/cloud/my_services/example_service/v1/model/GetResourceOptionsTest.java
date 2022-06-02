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

package com.ibm.cloud.my_services.example_service.v1.model;

import com.ibm.cloud.my_services.example_service.v1.model.GetResourceOptions;
import com.ibm.cloud.my_services.example_service.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetResourceOptions model.
 */
public class GetResourceOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetResourceOptions() throws Throwable {
    GetResourceOptions getResourceOptionsModel = new GetResourceOptions.Builder()
      .resourceId("1")
      .build();
    assertEquals(getResourceOptionsModel.resourceId(), "1");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetResourceOptionsError() throws Throwable {
    new GetResourceOptions.Builder().build();
  }

}