package com.lyc.city.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * restFul公共类
 * @author lyc
 * @date 2020/7/7 14:39
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    // 状态码
    private Integer code;

    // 状态消息
    private String message;

    // 返回数据
    private T data;

    // 提供无返回数据方法
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
