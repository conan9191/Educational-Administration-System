package com.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageUtil {
    /** 
     * 对字符串进行MD5加密 
     *  
     * @param input 
     * @return 
     */  
    public static String getMD5Str(String input) {  
        try {  
            MessageDigest m = MessageDigest.getInstance("MD5");  
            m.update(input.getBytes());  
            byte[] md5Data = m.digest();  
            return byteArrayToHex(md5Data);  
            // return byteArrayToHex2(md5Data);  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }  
        return null;  
  
    }  
  
    /** 
     * 将字节数组换成成16进制的字符串 
     *  
     * @param byteArray 
     * @return 
     */  
    private static String byteArrayToHex(byte[] byteArray) {  
        char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',  
                'A', 'B', 'C', 'D', 'E', 'F' };  
        char[] resultCharArray = new char[byteArray.length * 2];  
        int index = 0;  
        for (byte b : byteArray) {  
            resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];  
            resultCharArray[index++] = hexDigits[b & 0xf];  
        }  
        return new String(resultCharArray);  
    }  
  
}
