package com.jie.hardlibrary;

public class HardControl {
    public static native int ledOpen();
    public static native void ledClose();
    public static native int ledCtrl(int which, int status);

    static {
        System.loadLibrary("hardcontrol");
    }
}