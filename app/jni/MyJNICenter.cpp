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

#include "MyJNICenter.h"

void MyJNICenter::initialize(JNIEnv *env) {
  setClass(env);

  addNativeMethod("checkIMSI", (void*)checkIMSI, kTypeBool, kTypeString, NULL);
  registerNativeMethods(env);
}

jboolean MyJNICenter::checkIMSI(JNIEnv *env, jobject, jstring jstringpara)
{
	JavaString providedImsi(env,jstringpara);

	jclass mainActivityClass = env->FindClass("tiantian/ndkdemo/MainActivity");
	jmethodID getStory = env->GetStaticMethodID(mainActivityClass, "getIMSI", "()Ljava/lang/String;");
	jstring ret = (jstring)env->CallStaticObjectMethod(mainActivityClass, getStory);

	JavaString imsi(env,ret);
	if (imsi.get().compare(providedImsi.get())==0)
	{
		return true;
	}
	else
	{
		return false;
	}
}
