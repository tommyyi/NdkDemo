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

public class JavaClassTest {


    native public void createJavaClass() throws Exception;


    native public void isInitialized() throws Exception;


    native public void getCanonicalName() throws Exception;


    native public void getSimpleName() throws Exception;


    native public void merge() throws Exception;

    native public void nativeSetJavaObject(TestObject object);


    public void setJavaObject() throws Exception {
        TestObject object = TestObject.createTestObject();
        nativeSetJavaObject(object);
    }

    native public TestObject nativeToJavaObject();


    public void toJavaObject() throws Exception {
        TestObject object = nativeToJavaObject();
    }


    native public void getCachedMethod() throws Exception;

    native public void getInvalidCachedMethod() throws Exception;

    native public void getCachedMethodOnUninitialized() throws Exception;


    native public void getCachedField() throws Exception;

    native public void getInvalidCachedField() throws Exception;

    native public void getCachedFieldOnUninitialized() throws Exception;

    native public void cacheInvalidField() throws Exception;

    native public void cacheInvalidMethod() throws Exception;
}
