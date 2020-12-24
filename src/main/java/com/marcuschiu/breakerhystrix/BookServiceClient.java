package com.marcuschiu.breakerhystrix;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * make sure you run book-service application
 */
@FeignClient("book-service")
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
