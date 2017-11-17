package com.lin.encryptdemo.utlis;

import android.util.Base64;
import android.util.Log;

/**
 * @author ljz.
 * @date 2017/11/17.
 * 描述：加密工具类
 */

public class EncryptUtlis {

    public static String encrypt(String data, String key) {
        try {
            // base64编码
            byte[] data1 = Base64.encode(data.getBytes(), Base64.DEFAULT);
            // md5加密
            byte[] data2 = AESUtlis.encrypt(data1, MD5Utlis.Md5(key));
            // base64编码
            byte[] data3 = Base64.encode(data2, Base64.DEFAULT);
            return new String(data3);
        } catch (Exception e) {
            Log.e("组合加密错误", "：" + e);
        }
        return null;
    }


    public static String decrypt(String data, String key) {
        try {
            // base64解码
            byte[] data1 = Base64.decode(data.getBytes(), Base64.DEFAULT);
            // md5解密
            byte[] data2 = AESUtlis.decrypt(data1, MD5Utlis.Md5(key));
            // base64解码
            byte[] data3 = Base64.decode(data2, Base64.DEFAULT);
            return new String(data3);
        } catch (Exception e) {
            Log.e("组合解密错误", "：" + e);
        }
        return null;
    }
}
