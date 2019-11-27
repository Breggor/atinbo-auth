package com.atinbo.auth.model;


import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author breggor
 */
@Data
@Accessors(chain = true)
public class UserDTO implements Serializable {

    private Integer userId;
    /**
     * 用户名
     */
    private String username;

    private String password;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 简介
     */
    private String phone;
    /**
     * 头像
     */
    private String avatar;
}
