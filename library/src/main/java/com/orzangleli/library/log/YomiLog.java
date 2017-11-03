package com.orzangleli.library.log;


import android.util.Log;

/**
 * <p>description：日志打印 工具类
 * <p>===============================
 * <p>creator：李先成
 * <p>create time：2017/11/3 下午2:10
 * <p>===============================
 * <p>reasons for modification：
 * <p>Modifier：
 * <p>Modify time：
 * <p>@version
 */

public class YomiLog {

    private static final String TAG = "YomiLog";
    private static boolean isDebug = false;

    public static void i(String msg) {
        if (isDebug) {
            Log.i(TAG, msg);
        }
    }
    public static void d(String msg) {
        if (isDebug) {
            Log.d(TAG, msg);
        }
    }
    public static void v(String msg) {
        if (isDebug) {
            Log.v(TAG,msg);
        }
    }
    public static void w(String msg) {
        if (isDebug) {
            Log.w(TAG, msg);
        }
    }
    public static void e(String msg) {
        if (isDebug) {
            Log.e(TAG, msg);
        }
    }


}
