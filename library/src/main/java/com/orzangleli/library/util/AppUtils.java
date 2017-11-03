package com.orzangleli.library.util;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.orzangleli.library.log.YomiLog;

/**
 * <p>description：
 * <p>===============================
 * <p>creator：lixiancheng
 * <p>create time：2017/11/3 下午8:32
 * <p>===============================
 * <p>reasons for modification：
 * <p>Modifier：
 * <p>Modify time：
 * <p>@version
 */

public class AppUtils {

    private static Context APP_CONTEXT;

    public static void holdContext(Context context) {
        APP_CONTEXT = context;
    }

    public static Context getAppContext() {
        return APP_CONTEXT;
    }

    public static boolean checkPermission(String permission) {
        final int perm = AppUtils.getAppContext().checkCallingOrSelfPermission(permission);
        return perm == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * check current network state is wifi or not
     * @return
     */
    public static boolean isNetworkNotOnWifiType() {
        final ConnectivityManager manager = (ConnectivityManager) AppUtils.getAppContext().
                getSystemService(Context.CONNECTIVITY_SERVICE);

        if (manager == null) {
            YomiLog.e("fail to get connectivity manager");
            return false;
        }
        final NetworkInfo info = manager.getActiveNetworkInfo();
        return info == null || info.getType() != ConnectivityManager.TYPE_WIFI;
    }

}
