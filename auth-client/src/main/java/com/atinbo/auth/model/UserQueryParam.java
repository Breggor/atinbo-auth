package com.atinbo.auth.model;


import com.atinbo.model.PageParam;
import com.atinbo.model.QueryParam;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 用户查询参数
 *
 * @author 陈路嘉
 */
@Data
@Accessors(chain = true)
public class UserQueryParam extends PageParam implements QueryParam {

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
