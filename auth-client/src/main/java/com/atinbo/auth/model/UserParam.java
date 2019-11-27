package com.atinbo.auth.model;


import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author 陈路嘉
 */
@Data
@Accessors(chain = true)
public class UserParam implements Serializable {
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机
     */
    private String phone;
    /**
     * 头像
     */
    private String avatar;
}
