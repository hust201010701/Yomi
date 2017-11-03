package com.orzangleli.library.download;

/**
 * <p>description：
 * <p>===============================
 * <p>creator：lixiancheng
 * <p>create time：2017/11/3 下午4:56
 * <p>===============================
 * <p>reasons for modification：
 * <p>Modifier：
 * <p>Modify time：
 * <p>@version
 */

public class DownloadStatus {

    public final static int Pending = 0;
    public final static int Started = 1;
    public final static int Uploading = 2;
    public final static int Completed = 3;
    public final static int Errored = 4;
    public final static int Paused = 5;
    public final static int Canceled = 6;
    public final static int Retried = 7;
    public final static int OverLimit = 8;
    public final static int Exceptioned = 9;
    public final static int Failed = 10;
    public final static int Successed = 11;
    public final static int BlockStarted = 12;
    public final static int BlockCompleted = 13;

    // all tasks in a set have been compeleted
    public final static int AllTaskCompleted = 999;

    // whether the task is avaliable for continue downloading
    public static boolean isAvaliable(int status) {
        return status != Canceled && status != Errored;
    }

    // whether the task has been canceled
    public static boolean isCanceled(int status) {
        return status == Canceled;
    }

}
