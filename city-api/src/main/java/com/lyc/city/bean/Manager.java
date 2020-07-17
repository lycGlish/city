package com.lyc.city.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 管理员实体类
 * @author lyc
 * @date 2020/7/7 14:33
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manager implements Serializable {

    // 管理员id
    private Integer managerId;

    // 名字
    private String managerName;

    // 密码
    private String password;

    // 头像url
    private String avatar;

    // 邮箱
    private String email;

    // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
