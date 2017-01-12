package com.rmtd.herry.mvppratice.utils;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by meloDu on 2017/1/11.
 * 日志输出管理
 */
public class LogUtils {
    public static final boolean LOG_ENABLE = true;
    public static final boolean TOAST_ENABLE = true;

    public static void i(String tag, String message) {
        if (LOG_ENABLE) {
            Log.i(tag, message);
            // log2view(tag, message);
            // LogDoc.i("["+tag+"] "+message);
        }
    }

    public static void e(String tag, String message) {
        if (LOG_ENABLE) {
            Log.e(tag, message);
            // LogDoc.i("["+tag+"] "+message);
        }
    }

    public static void c(String s) {
        // e("hj", "" + s);
    }

    public static void b(String s) {
        // e("hj", "" + s);
    }

    public static void a(String s) {
        // e("hj", "" + s);
    }

    public static void h(String s) {
        // e("hj", "" + s);
    }

    public static void j(String s) {
        // e("hj", "" + s);
    }

    public static void hj(String s) {
        // e("hj", "" + s);
    }

    public static void d(String tag, String message) {
        if (LOG_ENABLE)
            Log.d(tag, message);
    }


    private static final String TEST_TAG = "TEST_TAG";

    public static void msg(String message) {

    }

    private static List<String> logs1 = new ArrayList<String>();

    public static synchronized void log2view(String message) {

    }



    private static final int log_limit = 10 * 1024 * 1024;



    public static synchronized void clearLogs() {
        LogUtils.i("LogUtil", "清空日志");
        logs1.clear();
    }

    public static synchronized List<String> getLogs() {
        LogUtils.i("LogUtil", "获取日志");
        return logs1;
    }

    public static synchronized void cleanAppLog() {
//		LogDoc.clean();
    }

    public static synchronized void cleanSipLog() {
        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            return;
        }
        File f = new File(Environment.getExternalStorageDirectory()
                + "/WukongLog/appLog.txt");
        if (f.exists()) {
            try {
                FileWriter wf = new FileWriter(f);
                wf.write("");
                wf.flush();
                wf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
