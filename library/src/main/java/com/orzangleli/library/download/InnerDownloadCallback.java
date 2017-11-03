package com.orzangleli.library.download;

import java.net.HttpURLConnection;

/**
 * <p>description：inner callback
 * <p>===============================
 * <p>creator：lixiancheng
 * <p>create time：2017/11/3 下午3:17
 * <p>===============================
 * <p>reasons for modification：
 * <p>Modifier：
 * <p>Modify time：
 * <p>@version
 */

public interface InnerDownloadCallback {

    void onPending(DownloadModel model);

    void onStart(DownloadModel model);

    void onUploading(DownloadModel model, float percent);

    void onComplete(DownloadModel model, String url);

    void onError(DownloadModel model, Exception ex);

    void onException(DownloadModel model, Exception ex);

    void onFail(DownloadModel model, int failCode);

    void onRetry(DownloadModel model);

    void onCancel(DownloadModel model);

    void onPause(DownloadModel model);

    void onResume(DownloadModel model);

    void onBlockStart(DownloadModel model);

    void onBlockComplete(DownloadModel model);

}
