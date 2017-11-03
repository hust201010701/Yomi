package com.orzangleli.library.download;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * <p>description：Base download data model
 * <p>===============================
 * <p>creator：lixiancheng
 * <p>create time：2017/11/3 下午2:31
 * <p>===============================
 * <p>reasons for modification：
 * <p>Modifier：
 * <p>Modify time：
 * <p>@version
 */

class DownloadModel {

    /**
     * unique id for every download task
     */
    private String id;

    /**
     * download url
     */
    private String url;

    /**
     * local path for saving download file
     */
    private String path;

    /**
     * directory of local path
     */
    private String pathAdDirectory;

    /**
     * filename of local path
     */
    private String filename;

    /**
     * download status
     */
    private AtomicInteger status;

    /**
     * How much has been downloaded?
     */
    private AtomicLong soFar;

    /**
     * How much should be downloaded?
     */
    private long total;

    /**
     * the start position for the download file.
     * In some case, you need download a file with multi-threads.
     * Every thread download a part of the file.
     * This field means the start position of the part.
     */
    private long startPos;

    /**
     * the end position for the download file.
     * In some case, you need download a file with multi-threads.
     * Every thread downloads a part of the file.
     * This field means the end position of the part.
     */
    private long endPos;

    /**
     * error message while downloading file
     */
    private String errMsg;

    /**
     * an attribute in request head which is unique identifier for server files.
     * eTag would be changed when server file has been changed.
     */
    private String eTag;

    /**
     * the connection count that current download task has used
     */
    private int connectionCount;


    // -------------------------------------------------------- getter and setter -------------------------------------------------------- //

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPathAdDirectory() {
        return pathAdDirectory;
    }

    public void setPathAdDirectory(String pathAdDirectory) {
        this.pathAdDirectory = pathAdDirectory;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public AtomicInteger getStatus() {
        return status;
    }

    public void setStatus(AtomicInteger status) {
        this.status = status;
    }

    public AtomicLong getSoFar() {
        return soFar;
    }

    public void setSoFar(AtomicLong soFar) {
        this.soFar = soFar;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getStartPos() {
        return startPos;
    }

    public void setStartPos(long startPos) {
        this.startPos = startPos;
    }

    public long getEndPos() {
        return endPos;
    }

    public void setEndPos(long endPos) {
        this.endPos = endPos;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String geteTag() {
        return eTag;
    }

    public void seteTag(String eTag) {
        this.eTag = eTag;
    }

    public int getConnectionCount() {
        return connectionCount;
    }

    public void setConnectionCount(int connectionCount) {
        this.connectionCount = connectionCount;
    }
}