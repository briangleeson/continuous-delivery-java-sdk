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

import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.model.Property;
import com.ibm.cloud.continuous_delivery.cd_tekton_pipeline.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Property model.
 */
public class PropertyTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testProperty() throws Throwable {
    Property propertyModel = new Property.Builder()
      .name("testString")
      .value("testString")
      .href("testString")
      .xEnum(java.util.Arrays.asList("testString"))
      .type("secure")
      .path("testString")
      .build();
    assertEquals(propertyModel.name(), "testString");
    assertEquals(propertyModel.value(), "testString");
    assertEquals(propertyModel.href(), "testString");
    assertEquals(propertyModel.xEnum(), java.util.Arrays.asList("testString"));
    assertEquals(propertyModel.type(), "secure");
    assertEquals(propertyModel.path(), "testString");

    String json = TestUtilities.serialize(propertyModel);

    Property propertyModelNew = TestUtilities.deserialize(json, Property.class);
    assertTrue(propertyModelNew instanceof Property);
    assertEquals(propertyModelNew.name(), "testString");
    assertEquals(propertyModelNew.value(), "testString");
    assertEquals(propertyModelNew.href(), "testString");
    assertEquals(propertyModelNew.type(), "secure");
    assertEquals(propertyModelNew.path(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPropertyError() throws Throwable {
    new Property.Builder().build();
  }

}