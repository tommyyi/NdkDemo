LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE :=jnihelper_shared

LOCAL_SRC_FILES := $(wildcard $(LOCAL_PATH)/../../../src/*.cpp)

LOCAL_C_INCLUDES := $(LOCAL_PATH)/../../../header
LOCAL_C_INCLUDES += $(shell ls -FR $(LOCAL_C_INCLUDES) | grep $(LOCAL_PATH)/$ )
LOCAL_C_INCLUDES := $(LOCAL_C_INCLUDES:$(LOCAL_PATH)/%:=$(LOCAL_PATH)/%)

include $(BUILD_SHARED_LIBRARY)