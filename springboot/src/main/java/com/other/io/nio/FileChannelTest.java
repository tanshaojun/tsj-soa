package com.other.io.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 复制内容
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/9 17:10
 */
public class FileChannelTest {


    public static void main(String[] args) throws Exception {
        FileOutputStream outputStream = new FileOutputStream("c:\\tansj\\f1.txt");
        FileChannel outputStreamChannel = outputStream.getChannel();

        FileInputStream inputStream = new FileInputStream("c:\\tansj\\f.txt");
        ByteBuffer buffer = ByteBuffer.allocate(5);
        FileChannel inputStreamChannel = inputStream.getChannel();
        while (true) {
            buffer.clear();
            int read = inputStreamChannel.read(buffer);
            if (-1 == read) break;
            buffer.flip();
            outputStreamChannel.write(buffer);
        }

        inputStream.close();
        outputStream.close();
    }


}
