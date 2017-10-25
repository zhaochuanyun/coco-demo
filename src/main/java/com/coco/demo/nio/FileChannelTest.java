package com.coco.demo.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * http://ifeve.com/channels/
 * 
 * @author mvpzhao
 *
 */
public class FileChannelTest {

    public static void main(String[] args) throws Exception {
        RandomAccessFile aFile = new RandomAccessFile("/Users/mvpzhao/Data/temp.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            System.out.println("Read " + bytesRead);
            buf.flip();

            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }

}
