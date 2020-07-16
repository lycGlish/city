package com.lyc.city.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lyc
 * @date 2020/7/7 14:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manager implements Serializable {
    private Integer managerId;

    private String managerName;

    private String password;

    private String avatar;

    private String email;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
