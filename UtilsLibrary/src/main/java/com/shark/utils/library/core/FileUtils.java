package com.shark.utils.library.core;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtils {
    public static void copyToPrivateFolder(Context context, InputStream inputStream, String nameForSave) {
        try {

            OutputStream outputStream = context.openFileOutput(nameForSave, Context.MODE_PRIVATE);
            byte[] cache = new byte[1024];
            while (inputStream.read(cache) != -1) {
                outputStream.write(cache);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
