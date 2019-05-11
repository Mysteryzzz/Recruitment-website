package com.cn.util;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/7
 */

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

import java.io.IOException;
import java.io.InputStream;

;

public class QiniuUtil {

    private static final String ACCESS_KEY = "FYZ2-x4KSE3guIf2VLwx7ufC-UOYd9sFuZ3IAjzF";
    private static final String SECRET_KEY = "6PyHxCRo_DPJ6-B7G-R4Sl4JgxsiUUI1rUz3ZpEp";
    private static final String BUCKET = "trickmaster";
    private static final String PATH = "files.trickmaster.cn";


    public static String fileUpload(InputStream file, String fileName) {


        Configuration configuration = new Configuration(Zone.zone2());
        UploadManager uploadManager = new UploadManager(configuration);


        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        String upToken = auth.uploadToken(BUCKET);
        try {
            byte[] fileStream = new byte[file.available()];
            file.read(fileStream);
            Response response = uploadManager.put(fileStream, fileName, upToken);
            // 解析上传成功的结果
            DefaultPutRet putRet = JsonUtil.json2Obj(response.bodyString(), DefaultPutRet.class);

            String returnPath = PATH + "/" + putRet.key;
            return "http://" + returnPath;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "error in uploading";
    }


}
