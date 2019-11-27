package com.atinbo.auth.service;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ArrayUtil;
import com.atinbo.model.Outcome;
import com.atinbo.auth.consts.AuthConsts;
import com.atinbo.security.model.LoginUser;
import com.atinbo.auth.user.feign.IUserClient;
import com.atinbo.auth.user.model.UserDTO;
import com.atinbo.auth.user.model.UserRolePermDTO;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户详细信息
 *
 * @author breggor
 */
@Slf4j
@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final IUserClient userClient;
    private final CacheManager cacheManager;

    /**
     * 用户密码登录
     *
     * @param username 用户名
     * @return
     */
    @Override
    @SneakyThrows
    public UserDetails loadUserByUsername(String username) {
        Cache cache = cacheManager.getCache("user_details");
        if (cache != null && cache.get(username) != null) {
            return (LoginUser) cache.get(username).get();
        }

        Outcome<UserRolePermDTO> result = userClient.user(username, AuthConsts.FROM_INNER);
        UserDetails userDetails = getUserDetails(result);
        cache.put(username, userDetails);
        return userDetails;
    }

    /**
     * 构建userdetails
     *
     * @param result 用户信息
     * @return
     */
    private UserDetails getUserDetails(Outcome<UserRolePermDTO> result) {
        if (result == null || result.getData() == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        UserRolePermDTO info = result.getData();
        Set<String> dbAuthsSet = new HashSet<>();
        if (ArrayUtil.isNotEmpty(info.getRoles())) {
            // 获取角色
            Arrays.stream(info.getRoles()).forEach(role -> dbAuthsSet.add(AuthConsts.ROLE + role));
            // 获取资源
            dbAuthsSet.addAll(Arrays.asList(info.getPermissions()));
        }

        UserDTO user = info.getUser();
        // 构造security用户
        return LoginUser.of(user.getUserId(), user.getUsername(), user.getPassword(), dbAuthsSet, MapUtil.<String, Object>builder("dept_id", user.getDeptId()).build());
    }
}
