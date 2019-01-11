package com.marcuschiu.breakerhystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Hystrix
public class BookService {

    @Autowired
    BookServiceClient bookServiceClient;

    @HystrixCommand(fallbackMethod = "reliable")
    public String getBookServiceLocalServiceInstance() {
        return bookServiceClient.getLocalServiceInstance();
    }

    public String reliable() {
        return "book-service application is down";
    }
}
