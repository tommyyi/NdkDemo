LOCAL_PATH := $(call my-dir)

#######################################
#include $(CLEAR_VARS)
#LOCAL_MODULE := jnihelper
#LOCAL_SRC_FILES := D:\CODE\Practice\NdkDemo\jnihelper\output\shared\obj\local\armeabi-v7a/libjnihelper_shared.so
#include $(PREBUILT_SHARED_LIBRARY)
#######################################
#include $(CLEAR_VARS)
#LOCAL_MODULE := jnihelper
#LOCAL_SRC_FILES := D:\CODE\Practice\NdkDemo\jnihelper\output\static\obj\local\armeabi-v7a/libjnihelper_static.a
#include $(PREBUILT_STATIC_LIBRARY)
########################################
include $(CLEAR_VARS)

$(call import-add-path,$(LOCAL_PATH)/../../jnihelper/output)

LOCAL_MODULE :=hello_jni

LOCAL_SRC_FILES := tiantian_ndkdemo_MainActivity.cpp JniEntrance.cpp MyJNICenter.cpp
#LOCAL_SRC_FILES += $(wildcard $(LOCAL_PATH)/jnihelpertest/*.cpp)

LOCAL_C_INCLUDES := $(LOCAL_PATH)
#LOCAL_C_INCLUDES += $(LOCAL_PATH)/jnihelpertest
LOCAL_C_INCLUDES += $(LOCAL_PATH)/../../jnihelper/header
LOCAL_C_INCLUDES += $(shell ls -FR $(LOCAL_C_INCLUDES) | grep $(LOCAL_PATH)/$ )
LOCAL_C_INCLUDES := $(LOCAL_C_INCLUDES:$(LOCAL_PATH)/%:=$(LOCAL_PATH)/%)

LOCAL_LDLIBS := -llog
LOCAL_STATIC_LIBRARIES := jnihelper_static
#LOCAL_SHARED_LIBRARIES := jnihelper_shared
#LOCAL_STATIC_LIBRARIES := jnihelper
#LOCAL_SHARED_LIBRARIES := jnihelper
include $(BUILD_SHARED_LIBRARY)

$(call import-module,static/jni)
#$(call import-module,shared/jni)