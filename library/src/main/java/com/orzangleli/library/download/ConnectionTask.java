package com.orzangleli.library.download;

import android.text.TextUtils;

import com.orzangleli.library.Yomi;
import com.orzangleli.library.log.YomiLog;
import com.orzangleli.library.util.StringUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>description：
 * <p>===============================
 * <p>creator：lixiancheng
 * <p>create time：2017/11/3 下午8:03
 * <p>===============================
 * <p>reasons for modification：
 * <p>Modifier：
 * <p>Modify time：
 * <p>@version
 */

public class ConnectionTask {

    private DownloadModel model;
    private DownloadHeader header;
    private String eTag;

    private Map<String, List<String>> requestHeader;
    private List<String> redirectedUrlList;

    private DownloadURLConnection connection;

    public void connect() {
        try {
            URL url = new URL(model.getUrl());
            connection = new DownloadURLConnection(url);

            addUserRequiredHeader(connection);
            addRangeHeader(connection);

            connection.execute();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }

    void addUserRequiredHeader(DownloadURLConnection connection) {
        final Map<String, List<String>> additionHeaders;
        if (header != null) {
            additionHeaders = header.getHeaders();

            if (additionHeaders != null) {
                YomiLog.v(model.getId() + " add outside header: " + additionHeaders.toString());

                String name;
                List<String> list;

                // add addition headers which is provided by the user
                Set<Map.Entry<String, List<String>>> entries = additionHeaders.entrySet();
                for (Map.Entry<String, List<String>> e : entries) {
                    name = e.getKey();
                    list = e.getValue();
                    if (list != null) {
                        for (String value : list) {
                            connection.addHeader(name, value);
                        }
                    }
                }

            }
        }
    }

    void addRangeHeader(DownloadURLConnection connection) {

        if (!StringUtils.isEmpty(eTag)) {
            connection.addHeader("If-Match", eTag);
        }
        final String range;
        if (model.getEndPos() == 0) {
            range = StringUtils.formatString("bytes=%d-", model.getSoFar());
        } else {
            range = StringUtils.formatString("bytes=%d-%d", model.getSoFar(), model.getEndPos());
        }
        connection.addHeader("Range", range);
    }


}
