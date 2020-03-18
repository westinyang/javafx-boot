package com.ceadeal.javafxboot.util;

import com.ceadeal.javafxboot.Application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;

public class PathUtil {

    /**
     * 获取当前运行的目录
     *
     * @return
     */
    public static String getRunPath() {
        /**
         * 方法一：获取当前可执行jar包所在目录
         */
        String filePath = System.getProperty("java.class.path");
        String pathSplit = System.getProperty("path.separator");//得到当前操作系统的分隔符，windows下是";",linux下是":"
        /**
         * 若没有其他依赖，则filePath的结果应当是该可运行jar包的绝对路径，
         * 此时我们只需要经过字符串解析，便可得到jar所在目录
         */
        if (filePath.contains(pathSplit)) {
            filePath = filePath.substring(0, filePath.indexOf(pathSplit));
        } else if (filePath.endsWith(".jar")) {//截取路径中的jar包名,可执行jar包运行的结果里包含".jar"
            filePath = filePath.substring(0, filePath.lastIndexOf(File.separator) + 1);
        }
        return filePath;
    }

    public static String getJarPath() {
        /**
         * 方法二：获取当前可执行jar包所在目录
         */
        String filePath = "";
        URL url = Application.class.getProtectionDomain().getCodeSource().getLocation();
        try {
            filePath = URLDecoder.decode(url.getPath(), "utf-8");// 转化为utf-8编码，支持中文
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (filePath.endsWith(".jar")) {// 可执行jar包运行的结果里包含".jar"
            // 获取jar包所在目录
            filePath = filePath.substring(0, filePath.lastIndexOf("/") + 1);
        }

        File file = new File(filePath);
        filePath = file.getAbsolutePath();//得到windows下的正确路径
        return filePath;
    }

    public static String getExePath() {
        return new File("").getAbsolutePath();
    }

}
