package com.marcuschiu.breakerhystrix;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * make sure you run book-service application
 * @FeignClient("book-service")
 * - service discovery via eureka server
 * @FeignClient(name = "unknown", url = "http://localhost:8083")
 * - unknown service, fallback onto http://localhost:8083
 */
@FeignClient("book-service")
//@FeignClient(name = "unknown", url = "http://localhost:8083")
public interface BookServiceClient {

    /**
     * calling this m
     * @return
     */
    @RequestMapping("/books")
    String books();

    @RequestMapping("/books/local-service-instance")
    String getLocalServiceInstance();
}
