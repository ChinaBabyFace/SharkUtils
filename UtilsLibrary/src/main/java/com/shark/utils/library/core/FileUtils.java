package com.shark.utils.library.core;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

public class FileUtils {
    public static void copyFile(FileInputStream fileInputStream, FileOutputStream fileOutputStream) throws IOException {
        FileChannel inputChannel = fileInputStream.getChannel();
        FileChannel outputChannel = fileOutputStream.getChannel();
        outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
    }

    public static void copyFile(InputStream fileInputStream, OutputStream fileOutputStream) throws IOException {
        int byteCount = 0;
        byte[] buffer = new byte[1024];
        while ((byteCount = fileInputStream.read(buffer)) > 0) {
            fileOutputStream.write(buffer, 0, byteCount);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
