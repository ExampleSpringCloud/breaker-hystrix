package com.marcuschiu.breakerhystrix;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("book-service")
public interface BookServiceClient {
    @RequestMapping("/books")
    String greeting();

    @RequestMapping("/books/local-service-instance")
    String getInstanceServiceInfo();
}
