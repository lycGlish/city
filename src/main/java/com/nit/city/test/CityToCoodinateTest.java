package com.nit.city.test;

import com.nit.city.util.CityUtil;

public class CityToCoodinateTest {

    public static void main(String[] args) {
        String str = CityUtil.httpUrlConnectionPost("江西省上饶信州区五三大道");
        str = str.substring(27);
        str = str.substring(0,str.length() - 1);
        System.out.println(str);
//        JSONObject json = JSONObject.fromObject(str);
//        if(json.get("status").toString().equals("0")){
//            double lng=json.getJSONObject("result").getJSONObject("location").getDouble("lng");
//            double lat=json.getJSONObject("result").getJSONObject("location").getDouble("lat");
//            System.out.println("经度：" + lng + "--- 纬度：" + lat);
//            System.out.println(str);
//            System.out.println(lng);
//            System.out.println(lat);
//        }else{
//            System.out.println("未找到相匹配的经纬度！");
//        }
    }
}
