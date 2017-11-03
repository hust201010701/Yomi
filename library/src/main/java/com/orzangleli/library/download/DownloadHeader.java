package com.orzangleli.library.download;

import com.orzangleli.library.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>description：
 * <p>===============================
 * <p>creator：lixiancheng
 * <p>create time：2017/11/3 下午7:50
 * <p>===============================
 * <p>reasons for modification：
 * <p>Modifier：
 * <p>Modify time：
 * <p>@version
 */

class DownloadHeader {
    /**
     * http header
     */
    private HashMap<String, List<String>> header;

    private void addHeader(String name,String value) {
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(value)) {
            throw new NullPointerException("Try to put null name or value into header");
        }
        if (header == null) {
            header = new HashMap<>();
        }
        if (!header.containsKey(name)) {
            List<String> tempList = new ArrayList<>();
            tempList.add(value);
            header.put(name, tempList);
        } else {
            List<String> tempList = header.get(name);
            if (tempList == null) {
                tempList = new ArrayList<>();
            }
            tempList.add(value);
            header.put(name, tempList);
        }
    }




}
