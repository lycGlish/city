package com.lyc.city.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 * @author lyc
 * @date 2020/7/6 9:46
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    // 用户id
    private Integer userId;

    // 名称
    private String userName;

    // 密码
    private String password;

    // 头像url
    private String avatar;

    // 邮箱
    private String email;

    // 激活状态
    private String flag;

    // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}