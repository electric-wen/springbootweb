package com.pingan.test.controller;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * 添加新的监控端点
 */
@Component
@Endpoint(id="ztwEndPoint")
public class UserEndpoint {

    @ReadOperation
    public List<Map<String, Object>> health() {
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("userId",1001);
        map.put("userName","周涛文");
        list.add(map);
        return list;
    }

}
