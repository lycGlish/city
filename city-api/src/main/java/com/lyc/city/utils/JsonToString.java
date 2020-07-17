package com.lyc.city.utils;

/**
 * json转String工具
 * @author lyc
 * @date 2020/7/9 16:41
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
