package com.other.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2019/11/18 14:32
 */
public class BIOServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            byte[] data = new byte[1024];
            int len;
            while ((len = inputStream.read(data)) != -1) {
                System.out.println(new String(data, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
