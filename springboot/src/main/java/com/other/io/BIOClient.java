package com.other.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2019/11/18 14:32
 */
public class BIOClient {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 1234);
            while (true) {
                try {
                    socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                    socket.getOutputStream().flush();
                    Thread.sleep(2000);
                } catch (Exception e) {
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
