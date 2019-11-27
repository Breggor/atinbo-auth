package com.atinbo.auth.fallback;

import com.atinbo.auth.feign.IUserClient;
import com.atinbo.auth.model.UserDTO;
import com.atinbo.auth.model.UserParam;
import com.atinbo.auth.model.UserQueryParam;

import com.atinbo.model.*;

/**
 * 用户fallback
 *
 * @author breggor
 */
public class UserClientFallback implements IUserClient {
    @Override
    public Outcome<UserDTO> create(UserParam req) {
        return Outcome.<UserDTO>failure("接口异常");
    }

    @Override
    public Outcome<Pagable<UserDTO>> findAllByPage(UserQueryParam param) {
        return Outcome.failure("接口异常");
    }

    @Override
    public Outcome<UserDTO> findUsersById(Long userId) {
        return Outcome.failure("接口异常");
    }

    @Override
    public Outcome<UserDTO> modifyUser(Long userId, UserParam param) {
        return Outcome.failure("接口异常");
    }

    @Override
    public boolean deleteUserById(Long userId) {
        return false;
    }


}
