package com.orzangleli.library.util;

import java.util.Locale;

/**
 * <p>description：
 * <p>===============================
 * <p>creator：lixiancheng
 * <p>create time：2017/11/3 下午7:56
 * <p>===============================
 * <p>reasons for modification：
 * <p>Modifier：
 * <p>Modify time：
 * <p>@version
 */

public class StringUtils {
    public static boolean isEmpty (String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        return false;
    }
    public static String formatString(final String msg, Object... args) {
        return String.format(Locale.ENGLISH, msg, args);
    }
}
