package com.atinbo.auth.user.model;

import lombok.Data;

import java.io.Serializable;


/**
 * 用户角色权限
 *
 * @author breggor
 */
@Data
public class UserRolePermDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户基本信息
     */
    private UserDTO user;

    /**
     * 角色集合
     */
    private Long[] roles;

    /**
     * 权限标识集合
     */
    private String[] permissions;
}
