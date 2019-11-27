package com.atinbo.auth.user.feign;


import com.atinbo.auth.user.model.UserRolePermDTO;
import com.atinbo.model.Outcome;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * 用户feign接口
 *
 * @author breggor
 */
@FeignClient(name = "${atinbo.usercenter.serviceName:user-center-service}", fallbackFactory = UserClientFallbackFactory.class)
public interface IUserClient {
    /**
     * 通过用户名查询用户、角色信息
     *
     * @param username 用户名
     * @param from     调用标志
     * @return R
     */
    @GetMapping("/user/{username}")
    Outcome<UserRolePermDTO> user(@PathVariable("username") String username, @RequestHeader("from") String from);

    /**
     * 通过社交账号查询用户、角色信息
     *
     * @param account appid@code
     * @return
     */
    @GetMapping("/social/{account}")
    Outcome<UserRolePermDTO> social(@PathVariable("account") String account);
}
