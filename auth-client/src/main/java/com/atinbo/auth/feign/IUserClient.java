package com.atinbo.auth.feign;

import com.atinbo.auth.fallback.UserClientFallback;
import com.atinbo.auth.model.UserDTO;
import com.atinbo.auth.model.UserParam;
import com.atinbo.auth.model.UserQueryParam;
import com.atinbo.model.Outcome;
import com.atinbo.model.Pagable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 用户接口
 *
 * @author breggor
 */
@FeignClient(name = "user-service", fallback = UserClientFallback.class)
public interface IUserClient {
    /**
     * 创建用户
     *
     * @param param
     * @return Outcome
     */
    @PostMapping("/users")
    Outcome create(@RequestBody UserParam param);

    /**
     * 用户根据分页查找
     *
     * @param param
     * @return Outcome
     */
    @GetMapping("/users/search")
    Outcome<Pagable<UserDTO>> findAllByPage(@RequestBody UserQueryParam param);

    /**
     * 用户根据id进行查找
     *
     * @param userId
     * @return Outcome
     */
    @GetMapping("/users/{userId}")
    Outcome<UserDTO> findUsersById(@PathVariable(value = "userId") Long userId);

    /**
     * 根据id修改用户信息
     *
     * @param userId
     * @param param
     * @return Outcome
     */
    @PutMapping("/users/{userId}")
    Outcome<UserDTO> modifyUser(@PathVariable(value = "userId") Long userId, @RequestBody UserParam param);

    /**
     * 根据用户id进行删除
     *
     * @param userId
     * @return boolean
     */
    @DeleteMapping("/user/{userId}")
    boolean deleteUserById(@PathVariable(value = "userId") Long userId);
}
