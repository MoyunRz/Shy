package com.springmvc.utils;

import java.io.*;

public class FileUtil {
    /**
     *  获取文件的后缀
     * @param file
     * @return
     */
    public static String getFileSuffix(String file)
    {
        return file.replace("/.+\\./","").toLowerCase();
    }

    /**
     * 将文本内容写出到文件
     * @param path 文件绝对路径
     * @param value 要写入的内容
     * @return
     * @throws IOException
     */
    public static boolean writeFile(String path,String value) throws IOException {


        // 字符输入流FileWriter
        // 打开指定路径的文件
        FileWriter writer = new FileWriter(path);
        BufferedWriter bw = new BufferedWriter(writer);
        // 写入字符
        bw.write(value);
        // 关闭写入
        bw.close();

        // 关闭文档
        writer.close();



        return true;
    }
}
