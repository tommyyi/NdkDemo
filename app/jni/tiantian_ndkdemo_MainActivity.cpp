#include "tiantian_ndkdemo_MainActivity.h"
#include <jni.h>
#include "JavaString.h"
#include <string.h>

using namespace std;
using namespace spotify::jni;

JNIEXPORT jstring JNICALL Java_tiantian_ndkdemo_MainActivity_getstringfromC(JNIEnv *jniEnv, jobject jobj)
{
	jclass mainActivityClass = jniEnv->FindClass("tiantian/ndkdemo/MainActivity");
	jmethodID getStory = jniEnv->GetStaticMethodID(mainActivityClass, "getStory", "()Ljava/lang/String;");
	jstring ret=(jstring)jniEnv->CallStaticObjectMethod(mainActivityClass, getStory);
	
	std::string info = "i need";
	JavaString javaString = JavaString(info);

	return javaString.toJavaString(jniEnv);
}