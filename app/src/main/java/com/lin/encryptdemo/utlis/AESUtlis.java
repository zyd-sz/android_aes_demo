package com.lin.encryptdemo.utlis;

import android.util.Log;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author ljz.
 * @date 2017/11/17.
 * 描述：AES加解密工具类
 */

public class AESUtlis {

    private static final String KEY_ALGORITHM = "AES";
    private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS7Padding";

    private static Key toKey(byte[] key) throws Exception {
        //实例化DES密钥
        //生成密钥
        SecretKey secretKey = new SecretKeySpec(key, KEY_ALGORITHM);
        return secretKey;
    }


    public static byte[] encrypt(byte[] data, String key) {
        try {
            //还原密钥
            Key k = toKey(key.getBytes());
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM, "BC");
            //初始化，设置为加密模式
            cipher.init(Cipher.ENCRYPT_MODE, k);
            //执行操作
            return cipher.doFinal(data);
        } catch (Exception e) {
            Log.e("AES256加密错误", "：" + e);
        }
        return null;
    }


    public static byte[] decrypt(byte[] data, String key) {
        try {
            Key k = toKey(key.getBytes());
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            //初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, k);
            //执行操作
            return cipher.doFinal(data);
        } catch (Exception e) {
            Log.e("AES256解密错误", "：" + e);
        }
        return null;
    }
}
