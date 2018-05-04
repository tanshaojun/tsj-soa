package com.tsj.common.utils;

public class HttpInfoUtils {

    private static final String USER_AGENT_PREFIX = "wallet-core-java";
    private static final String HTTP_UTILS_VERSION = "1.0.0";
    private static String defaultUserAgent = null;

    public static String getDefaultUserAgent() {
        if (defaultUserAgent == null) {
            defaultUserAgent = USER_AGENT_PREFIX + "/" + HTTP_UTILS_VERSION + "(" + System.getProperty("os.name") + "/"
                    + System.getProperty("os.version") + "/" + System.getProperty("os.arch") + ";"
                    + System.getProperty("java.version") + ")";
        }
        return defaultUserAgent;
    }
}