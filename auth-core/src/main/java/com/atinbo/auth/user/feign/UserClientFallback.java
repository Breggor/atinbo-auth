package com.atinbo.auth.user.feign;

import com.atinbo.auth.user.model.UserRolePermDTO;
import com.atinbo.model.Outcome;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 用户feign失败回退
 *
 * @author breggor
 */
@Slf4j
@Component
public class UserClientFallback implements IUserClient {

    @Setter
    private Throwable cause;

    /**
     * 通过用户名查询用户、角色信息
     *
     * @param username 用户名
     * @param from     内外标志
     * @return
     */
    @Override
    public Outcome<UserRolePermDTO> user(String username, String from) {
        log.error("feign 查询用户信息失败:{}", username, cause);
        return Outcome.failure(cause.getMessage());
    }

    /**
     * 通过社交账号查询用户、角色信息
     *
     * @param account appid@code
     * @return
     */
    @Override
    public Outcome<UserRolePermDTO> social(String account) {
        log.error("feign 查询用户信息失败:{}", account, cause);
        return Outcome.failure(cause.getMessage());
    }
}
