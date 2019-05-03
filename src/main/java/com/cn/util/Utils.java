package com.cn.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/2
 */
public class Utils {

    public static File makefile(String path) throws IOException {

        if (path == null || "".equals(path.trim())){
            return null;
        }

        String dirPath = path.substring(0, path.lastIndexOf("\\"));
        int index = path.lastIndexOf(".");
        // 全路径，保存文件后缀
        if (index > 0) {
            File dir = new File(dirPath);
            //先建目录
            if (!dir.exists()) {
                dir.mkdirs();
                dir = null;
            }

            File file = new File(path);
            //再建文件
            if (!file.exists()) {
                file.createNewFile();
            }
            return file;
        } else {
            //直接建目录
            File dir = new File(dirPath);
            if (!dir.exists()) {
                dir.mkdirs();
                dir = null;
            }
            return dir;
        }

    }

    public static void upload(MultipartFile file,String path) throws IOException
    {
            file.transferTo(new File(path));

    }

    public static String makeFileName(String filename){
        //为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
        return UUID.randomUUID().toString() + "_" + filename;
    }
}
