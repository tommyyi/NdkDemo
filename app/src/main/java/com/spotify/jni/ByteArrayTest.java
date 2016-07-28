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

public class ByteArrayTest {

    private byte[] getTestByteArray() {
        byte[] data = new byte[10];
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) i;
        }
        return data;
    }

    public native void createNewByteArray() throws Exception;

    public native void createNewByteArrayWithData() throws Exception;


    public native void createNewByteArrayWithDataCopy() throws Exception;

    public native void nativeCreateNewByteArrayWithJavaData(byte[] data);


    public void createNewByteArrayWithJavaData() throws Exception {
        nativeCreateNewByteArrayWithJavaData(getTestByteArray());
    }


    public native void createNewByteArrayWithNull() throws Exception;


    public native void createNewByteArrayWithNullAndNonZeroLength() throws Exception;

    public native byte[] nativeGetTestJavaByteArray();


    public void getJavaByteArray() throws Exception {
        byte[] result = nativeGetTestJavaByteArray();
        byte[] expected = getTestByteArray();
    }


    public native void setData() throws Exception;


    public native void setDataWithCopy() throws Exception;

    public native void nativeSetJavaByteArray(byte[] data, int expectedSize);


    public void setJavaData() throws Exception {
        byte[] expected = getTestByteArray();
        nativeSetJavaByteArray(expected, expected.length);
    }


    public void setJavaDataWithNull() throws Exception {
        nativeSetJavaByteArray(null, 0);
    }
}