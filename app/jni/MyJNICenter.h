/*
 * Copyright (c) 2014 SPOTIFY AB
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

#ifndef __JavaStringTest_h__
#define __JavaStringTest_h__

#include "JniHelpers.h"
#include "JniEntrance.h"

using namespace std;
using namespace spotify::jni;

class EXPORT MyJNICenter : public JavaClass {
public:
  MyJNICenter() : JavaClass() {}
  MyJNICenter(JNIEnv *env) : JavaClass(env) {
    initialize(env);
  }
  ~MyJNICenter() {}

  void initialize(JNIEnv *env);
  void mapFields() {}
  const char* getCanonicalName() const {
    return MAKE_CANONICAL_NAME(PACKAGE, MyJNICenter);
  }

private:
  static jboolean checkIMSI(JNIEnv *, jobject, jstring);
};

#endif // __JavaStringTest_h__
