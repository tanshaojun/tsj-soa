package com.tsj.common.utils;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ServiceUnavailableRetryStrategy;
import org.apache.http.protocol.HttpContext;

public class HttpServiceUnavailableRetryStrategy implements ServiceUnavailableRetryStrategy {

    private int maxRetries;
    private long retryInterval;

    public HttpServiceUnavailableRetryStrategy() {
        this(3, 50);
    }

    public HttpServiceUnavailableRetryStrategy(int maxRetries) {
        this(3, 50);
    }

    public HttpServiceUnavailableRetryStrategy(int maxRetries, long retryInterval) {
        if (maxRetries < 1) {
            throw new IllegalArgumentException(
                    "[HttpServiceUnavailableRetryStrategy] MaxRetries must be greater than 1");
        }
        if (retryInterval < 1) {
            throw new IllegalArgumentException(
                    "[HttpServiceUnavailableRetryStrategy] Retry interval must be greater than 1");
        }
        this.maxRetries = maxRetries;
        this.retryInterval = retryInterval;
    }

    @Override
    public boolean retryRequest(HttpResponse response, int executionCount, HttpContext context) {
        return executionCount <= maxRetries
                && (response.getStatusLine().getStatusCode() == HttpStatus.SC_INTERNAL_SERVER_ERROR
                        || response.getStatusLine().getStatusCode() == HttpStatus.SC_SERVICE_UNAVAILABLE
                        || response.getStatusLine().getStatusCode() == HttpStatus.SC_GATEWAY_TIMEOUT);
    }

    @Override
    public long getRetryInterval() {
        return retryInterval;
    }

}
