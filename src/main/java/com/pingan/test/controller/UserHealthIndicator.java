package com.pingan.test.controller;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * 扩展端点
 */
@Component
public class UserHealthIndicator extends AbstractHealthIndicator {

    /**
     * 扩展/actuator/health功能，添加其他健康状态信息
     * @param builder
     * @throws Exception
     */
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        builder.up().withDetail("shutup",false);
        builder.down().withDetail("ztw",true);
    }

}
