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

public class NativeObjectTest {

    native public PersistedObject createPersistedObject();

    native public PersistedObject getPersistedInstance(PersistedObject object);

    native public void destroyPersistedObject(PersistedObject object);

    public void persist() throws Exception {
        PersistedObject object = createPersistedObject();

        // Now create a new empty object, but copy the nPtr field to it. Note that
        // the i field is *not* copied; that value is stored natively and should
        // be retrieved in the call to getPersistedInstance.
        PersistedObject emptyInstance = new PersistedObject();

        // The native test should be able to fetch the previous instance via nPtr,
        // and return to us the same instance data in a new object.
        PersistedObject result = getPersistedInstance(emptyInstance);

        // Always clean up after yourself, kids!
        destroyPersistedObject(object);
    }

    native public void persistInvalidClass() throws Exception;

    native public void persistNullObject() throws Exception;

    public void destroyPersistedObject() throws Exception {
        PersistedObject object = createPersistedObject();

        destroyPersistedObject(object);

    }

    native public void nativeIsPersistenceEnabled() throws Exception;

    native public void isPersistenceEnabledWithoutInit() throws Exception;

    native public void destroyInvalidClass() throws Exception;

    native public void destroyNullObject() throws Exception;

    public void destroyFromJava() throws Exception {
        PersistedObject object = createPersistedObject();
        object.destroy();
    }
}
