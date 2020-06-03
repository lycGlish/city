package com.nit.city.test;

import com.nit.city.util.PythonUtil;

public class PythonTest {

    public static void main(String[] args) {
        String str = PythonUtil.httpUrlConnectionPost("http://120.26.65.52:80/group1/M00/00/00/rBAc3l6ei-6AZUZuAAAL9PJVLeE894.jpg");
        String str2 = "";
        if (str != null && !"".equals(str)) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                    str2 += str.charAt(i);
                }
            }

        }
        System.out.println(str2);
    }
}
