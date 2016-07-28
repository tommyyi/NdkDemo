/*
 * Copyright (c) 2014 Spotify AB
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.spotify.jni;

public class ClassRegistryTest {

    
    native public void createRegistry() throws Exception;


    native public void addClass() throws Exception;

    native public void addNullClass() throws Exception;

    native public void addClassWithEmptyName() throws Exception;

    native public void addClassWithNullName() throws Exception;

    native public void addClassWithoutInfo() throws Exception;


    native public void addClassMultipleTimes() throws Exception;


    native public void get() throws Exception;


    native public void getWithBracketOperator() throws Exception;

    native public void getNullClass() throws Exception;


    native public void getInvalidClass() throws Exception;

    native public void nativeNewInstance(TestObject instance);


    public void newInstance() throws Exception {
        TestObject testObject = TestObject.createTestObject();
        nativeNewInstance(testObject);
    }

    native public void nativeNewInstanceWithNull(TestObject instance);


    public void newInstanceWithNull() throws Exception {
        nativeNewInstanceWithNull(null);
    }
}
