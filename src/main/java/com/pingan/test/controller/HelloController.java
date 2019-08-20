package com.pingan.test.controller;

import com.pingan.test.entity.ResponseData;
import com.pingan.test.service.AsyncService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Environment
 * 1、spring boot的默认配置文件是application.properties
 * 2、在application.properties里配置server.port,应用会读取配置文件端口号来启动tomcat
 * 3、获取配置文件的key不存在时，不会报错，返回的是null
 *
 * @Value方式取配置
 *
 * 多环境配置
 * 1、通过在application.properties的spring.profiles.active=dev激活不同环境下的配置
 * 2、若application.properties和application-dev.properties同时存在，则优先读取dev配置，
 * 若没有，再从application.properties读取
 *
 *
 *
 */
@RestController
public class HelloController {

    protected Log logger = LogFactory.getLog(this.getClass());

    //注入对象
    @Autowired
    private Environment env;

    @Value("${server.port}")
    private String port1;

    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/hello")
    public String hello() {
        String port = env.getProperty("server.port1");
//        return "hello spring boot!";
        logger.info("environment port:"+port);
        return port;
    }

    /**
     * @GetMapping其实就是@RequestMapping(method="RequestMethod.Get")
     * @return
     */
    @GetMapping("/hello1")
    public String hello1() {
        return port1;
    }

    @RequestMapping("/testAsync")
    public ResponseData testAsync() throws InterruptedException {
        asyncService.testAsync();
        ResponseData r = new ResponseData();
        r.setStatus(true);
        r.setCode("200");
        r.setMessage("success");
        return r;
    }
}
