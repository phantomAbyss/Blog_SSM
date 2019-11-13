package com.wy.blog.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtils {

    /**
     * MD5加密
     * @param str
     * @return
     */
    public static String strToMD5(String str){
        String MD5Str = null;
        try {
            if(str != null && str.length() >= 1){
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                md5.update(str.getBytes());
                byte[] digest = md5.digest();

                int i = 0;
                StringBuffer buffer = new StringBuffer("");
                for(int offset = 0;offset < digest.length;offset++){
                    i = digest[offset];
                    if(i < 0)
                       i += 256;
                    if(i < 16)
                        buffer.append("0");
                    buffer.append(Integer.toHexString(i));
                }
                MD5Str = buffer.toString();
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return MD5Str;
    }


    /**
     * 根据邮箱获取路径
     * @param email
     * @return
     */
    public static String getAvatar(String email){
        String emailMD5 = strToMD5(email);
        //设置图片大小32px
        String avatar = "http://cn.gravatar.com/avatar/" + emailMD5 + "?s=128&d=identicon&r=PG";
        return avatar;
    }
}
