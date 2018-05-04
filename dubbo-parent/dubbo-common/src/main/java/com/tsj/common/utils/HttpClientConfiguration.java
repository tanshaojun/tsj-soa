package com.tsj.common.utils;

public class HttpClientConfiguration {

    private static final String DEFAULT_USER_AGENT = HttpInfoUtils.getDefaultUserAgent();
    public static final int DEFAULT_CONNECTION_REQUEST_TIMEOUT = -1;
    public static final int DEFAULT_MAX_CONNECTIONS = 512;
    public static final int DEFAULT_VALIDATE_AFTER_INACTIVITY = 2 * 1000;
    public static final int DEFAULT_CONNECTION_TIMEOUT = 50 * 1000;
    public static final int DEFAULT_MAX_RETRIES = 3;
    public static final long DEFAULT_RETRY_INTERVAL = 50;

    private String userAgent = DEFAULT_USER_AGENT;
    private int connectionRequestTimeout = DEFAULT_CONNECTION_REQUEST_TIMEOUT;
    private int connectionTimeout = DEFAULT_CONNECTION_TIMEOUT;
    private int socketTimeout = DEFAULT_CONNECTION_TIMEOUT;
    private int maxConnections = DEFAULT_MAX_CONNECTIONS;
    private int maxRetries = DEFAULT_MAX_RETRIES;
    private long retryInterval = DEFAULT_RETRY_INTERVAL;

    public int getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public int getValidateAfterInactivity() {
        return DEFAULT_VALIDATE_AFTER_INACTIVITY;
    }

    public int getConnectionRequestTimeout() {
        return connectionRequestTimeout;
    }

    public void setConnectionRequestTimeout(int connectionRequestTimeout) {
        this.connectionRequestTimeout = connectionRequestTimeout;
    }

    public int getMaxRetries() {
        return maxRetries;
    }

    public void setMaxRetries(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    public long getRetryInterval() {
        return retryInterval;
    }

    public void setRetryInterval(long retryInterval) {
        this.retryInterval = retryInterval;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public int getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

}
