package com.orzangleli.library.download;

import android.Manifest;

import com.orzangleli.library.util.AppUtils;
import com.orzangleli.library.util.StringUtils;

/**
 * <p>description：Base Thread for download file
 * <p>===============================
 * <p>creator：李先成
 * <p>create time：2017/11/3 下午2:23
 * <p>===============================
 * <p>reasons for modification：
 * <p>Modifier：
 * <p>Modify time：
 * <p>@version
 */

public class DownloadRunnable implements Runnable {

    private static final int MAX_BUFFER_LENGTH = 1024 * 4; // 4096

    /**
     * default retry times when connect or download fail
     */
    private final int DEFAULT_RETRY_COUNT = 5;

    /**
     * basic download model
     */
    private DownloadModel downloadModel;

    /**
     * only download file when wifi is avaliable
     */
    private boolean isWifiRequired;

    /**
     * inner callback , after receiving events do inner something.
     */
    private InnerDownloadCallback innerDownloadCallback;


    private DownloadHeader header;

    private ConnectionTask connectionTask;

    private boolean isPaused = false;


    @Override
    public void run() {
        // check whether task has been canceled
        if (DownloadStatus.isCanceled(downloadModel.getStatus().get())) {
            innerDownloadCallback.onCancel(downloadModel);
            return;
        }
        if (isPaused) {
            innerDownloadCallback.onCancel(downloadModel);
            return;
        }
        if (checkNetworkBeforeConnection()) {
            return;
        }







    }

    /**
     * check isWifiRequired and network state
     * Return false when the task need wifi, Yomi can't access wifi state permission
     * and current network state is not wifi.
     */
    private boolean checkNetworkBeforeConnection() {
        // 1. check whether need access-network-state permission?
        if (isWifiRequired &&
                !AppUtils.checkPermission(Manifest.permission.ACCESS_NETWORK_STATE)) {
            innerDownloadCallback.onException(downloadModel, new IllegalAccessException(
                    StringUtils.formatString("Task[%d] can't start the download runnable," +
                                    " because this task require wifi, but user application " +
                                    "nor current process has %s, so we can't check whether " +
                                    "the network type connection.", downloadModel.getId(),
                            Manifest.permission.ACCESS_NETWORK_STATE)));
            return false;
        }

        if (isWifiRequired && !AppUtils.isNetworkNotOnWifiType()) {
            innerDownloadCallback.onException(downloadModel, new IllegalAccessException(
                    StringUtils.formatString("Task[%d] can't start the download runnable," +
                                    " because this task require wifi, but current network state is not wifi",
                            downloadModel.getId())));
            return false;
        }

        return true;
    }

}
