package com.spotify.jni;

public class JavaStringArrayTest {
    private String[] getTestJavaStringArray() {
        return new String[] {"abc", "def", "ghi", "ążń"};
    }


    public native void createNewJavaStringArray() throws Exception;


    public native void createNewJavaStringArrayWithData() throws Exception;


    public native void createNewJavaStringArrayWithDataCopy() throws Exception;


    public void createNewJavaStringArrayWithJavaData() throws Exception {
        nativeCreateNewJavaStringArrayWithJavaData(getTestJavaStringArray());
    }

    private native void nativeCreateNewJavaStringArrayWithJavaData(String[] elements);


    public native void createNewJavaStringArrayWithNull() throws Exception;


    public native void createNewJavaStringArrayWithNullAndNonZeroLength() throws Exception;

    public native String[] nativeGetTestJavaStringArray();


    public void getJavaStringArray() throws Exception {
        String[] result = nativeGetTestJavaStringArray();
        String[] expected = getTestJavaStringArray();
    }


    public native void setData() throws Exception;


    public native void setDataWithCopy() throws Exception;

    public native void nativeSetJavaStringArray(String[] data, int expectedSize);


    public void setJavaData() throws Exception {
        String[] expected = getTestJavaStringArray();
        nativeSetJavaStringArray(expected, expected.length);
    }


    public void setJavaDataWithNull() throws Exception {
        nativeSetJavaStringArray(null, 0);
    }
}
