/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shenyu.plugin.ai.common.strategy;

import org.apache.shenyu.common.enums.AiModelProviderEnum;
import org.apache.shenyu.plugin.ai.common.strategy.openai.OpenAI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AiModelFactoryTest {

    @Test
    void testCreateAiModelWithValidProvider() {
        AiModel aiModel = AiModelFactory.createAiModel(AiModelProviderEnum.OPEN_AI);
        assertNotNull(aiModel);
        assertTrue(aiModel instanceof OpenAI);
    }

    @Test
    void testCreateAiModelWithNullProvider() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            AiModelFactory.createAiModel(null);
        });
        assertEquals("not supported provider", exception.getMessage());
    }
}
