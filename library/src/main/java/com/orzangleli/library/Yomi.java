package com.orzangleli.library;

import android.content.Context;

import com.orzangleli.library.util.AppUtils;

/**
 * <p>description：Yomi 下载库入口
 * <p>===============================
 * <p>creator：李先成
 * <p>create time：2017/10/30 下午11:35
 * <p>===============================
 * <p>reasons for modification：
 * <p>Modifier：
 * <p>Modify time：
 * <p>@version
 */

public class Yomi {
    /**
     * initialize with context
     * @param context application context
     */
    public static void initialize (Context context) {
        AppUtils.holdContext(context);
    }


}
