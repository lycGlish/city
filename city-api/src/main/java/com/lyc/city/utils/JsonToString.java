package com.lyc.city.utils;

/**
 * @author lyc
 */
public class JsonToString {
    public static String getJsonToString(String jsonUrl){
        String stringUrl = "";
        if (jsonUrl != null && !"".equals(jsonUrl)) {
            for (int i = 0; i < jsonUrl.length(); i++) {
                if (jsonUrl.charAt(i) >= 48 && jsonUrl.charAt(i) <= 57) {
                    stringUrl += jsonUrl.charAt(i);
                }
            }

        }
        return stringUrl;
    }
}
