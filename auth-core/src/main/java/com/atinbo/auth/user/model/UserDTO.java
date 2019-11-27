package com.atinbo.auth.user.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户基本信息
 *
 * @author breggor
 */
@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 删除
     */
    public static final String STATUS_DEL = "1";
    /**
     * 正常
     */
    public static final String STATUS_NORMAL = "0";

    /**
     * 锁定
     */
    public static final String STATUS_LOCK = "9";

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
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
     * 锁定标记
     */
    private String lockFlag;

    /**
     * 简介
     */
    private String phone;
    /**
     * 头像
     */
    private String avatar;

    /**
     * 部门ID
     */
    private Integer deptId;

    /**
     * 微信openid
     */
    private String wxOpenid;

    /**
     * QQ openid
     */
    private String qqOpenid;

}
