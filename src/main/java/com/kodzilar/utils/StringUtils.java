package com.kodzilar.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtils {

    public static String getEncodeSHA512(String text) {
        String encodeStirng = "";
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            byte[] bytes = messageDigest.digest(text.getBytes());
            StringBuilder sb = new StringBuilder();

            for(int i=0;i<bytes.length;i++){
                sb.append(Integer.toString( (bytes[i] & 0xff) + 0x100, 16 ).substring(1));
            }
            encodeStirng = sb.toString();
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return encodeStirng;
    }
}