package com.atinbo.auth.user.feign;


import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 用户失败回退工厂类
 */
@Component
public class UserClientFallbackFactory implements FallbackFactory<UserClientFallback> {

    @Override
    public UserClientFallback create(Throwable throwable) {
        UserClientFallback fallback = new UserClientFallback();
        fallback.setCause(throwable);
        return fallback;
    }
}
