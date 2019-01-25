package com.wxb.app.utils;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * 操作assets资源文件
 */
public class FileUtil {
    private static final int BYTE_BUF_SIZE = 2048;

    /**
     * 获取asset目录下json文件
     * @param fileName file name
     * @param context context
     * @return String
     */
    public static String getAssetJson(String fileName, Context context) {
        //将json数据变成字符串
        StringBuilder stringBuilder = new StringBuilder();
        try {
            //获取assets资源管理器
            AssetManager assetManager = context.getAssets();
            //通过管理器打开文件并读取
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    /**
     * Copies a file from assets.
     *
     * @param context    application context used to discover assets.
     * @param assetName  the relative file name within assets.
     * @param targetName the target file name, always over write the existing file.
     * @throws IOException if operation fails.
     */
    public static void copy(Context context, String assetName, String targetName) throws IOException {

        File targetFile = null;
        InputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            AssetManager assets = context.getAssets();
            targetFile = new File(targetName);
            if (!targetFile.getParentFile().exists()) {
                targetFile.getParentFile().mkdirs();
            }
            if (!targetFile.exists()) {
                targetFile.createNewFile();
            }
            inputStream = assets.open(assetName);
            outputStream = new FileOutputStream(targetFile, false /* append */);
            copy(inputStream, outputStream);
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    private static void copy(InputStream from, OutputStream to) throws IOException {
        byte[] buf = new byte[BYTE_BUF_SIZE];
        while (true) {
            int r = from.read(buf);
            if (r == -1) {
                break;
            }
            to.write(buf, 0, r);
        }
    }

    /**
     * 获取文件内容
     *
     * @param path file path
     * @return String
     */
    public static String getFileOutputString(String path) {
        try {
            File file = new File(path);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"), 8192);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append("\n").append(line);
            }
            bufferedReader.close();
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
