package com.nit.city.util;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class CityUtil {
    /**
     * @param 表示要访问的API的地址 =后面表示传递的参数
     */
    private static final String SERVICE_URL = "http://api.map.baidu.com/geocoding/v3/?address=";
    /**
     * @param 表示成功传递参数的返回值为200
     */
    private static final int SUCCESS = 200;

    public static String httpUrlConnectionPost(String address) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 给访问路径加上传递的参数 url
        String do_url = SERVICE_URL + address + "&output=json&ak=CsItNKwRaLZ8GXXaeyQI6kRozCMrtKcF&callback=showLocation";
        // api设定的是做post方法,可以更改为get
        HttpGet httpGet = new HttpGet(do_url);
        // 获取执行后的response
        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            // 判断访问连接状态是不是200
            if (statusCode == SUCCESS) {
                HttpEntity entity = response.getEntity();
                return EntityUtils.toString(entity, "utf-8");
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
