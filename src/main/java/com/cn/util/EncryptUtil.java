package com.cn.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.UUID;

public class EncryptUtil {

    private static String DEFAULT_ENCODING = "UTF-8";
    private static String SHA_256 = "SHA-256";
    private static String MD5 = "MD5";

    public static String encryptByMD5(String str){
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8位字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            //一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    public static String encrypt(String password, String salt) {

        String encryptString = digest(password + salt, SHA_256, DEFAULT_ENCODING);
        return encryptString;
    }

    public static String createSalt() {
        return UUID.randomUUID().toString();
    }

    public static String digest(String str, String alg, String charEncoding) {
        try {
            byte[] data = str.getBytes(charEncoding);
            MessageDigest md = MessageDigest.getInstance(alg);
            return HexUtil.toHex(md.digest(data));
        } catch (Exception var5) {
            throw new RuntimeException("digest fail!", var5);
        }
    }


    public static void main(String[] args) {
        System.out.println(encryptByMD5("970725"));
    }

}
