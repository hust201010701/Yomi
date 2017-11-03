package com.orzangleli.yomi;

import android.app.Application;

import com.orzangleli.library.Yomi;

/**
 * <p>description：
 * <p>===============================
 * <p>creator：lixiancheng
 * <p>create time：2017/11/3 下午8:36
 * <p>===============================
 * <p>reasons for modification：
 * <p>Modifier：
 * <p>Modify time：
 * <p>@version
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Yomi.initialize(this.getApplicationContext());
    }
}
