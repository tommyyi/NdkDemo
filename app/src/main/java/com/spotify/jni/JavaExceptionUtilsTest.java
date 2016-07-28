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


public class JavaExceptionUtilsTest {

    // TODO: Need to test checkException, not sure how

    public native void nativeThrowException() throws Exception;

    public void throwException() throws Exception {
        try {
            nativeThrowException();
        } catch (Exception e) {
            throw e;
        }
    }

    public native void nativeThrowExceptionWithFormatString() throws Exception;


    public void testThrowExceptionWithFormatString() throws Exception {
        try {
            nativeThrowExceptionWithFormatString();
        } catch (Exception e) {
            String expected = TestConstants.TEST_STRING + ", " + TestConstants.TEST_INTEGER;
        }
    }

    public native void nativeThrowRuntimeException() throws Exception;

    public void throwRuntimeException() throws Exception {
        try {
            nativeThrowRuntimeException();
        } catch (RuntimeException e) {
            throw e;
        }
    }

    public native void nativeThrowExceptionOfType() throws Exception;

    public void throwExceptionOfType() throws Exception {
        try {
            nativeThrowExceptionOfType();
        } catch (UnsupportedOperationException e) {
            throw e;
        }
    }
}
