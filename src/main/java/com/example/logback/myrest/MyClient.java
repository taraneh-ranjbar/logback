package com.example.logback.myrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by taraneh on 7/17/2020.
 */
@RestController
@RequestMapping("/client")
public class MyClient {

    Logger logger = LoggerFactory.getLogger(MyClient.class);

    @GetMapping("/test")
    public String getTest(){
        try {
            RestTemplate rest = new RestTemplate();
            String url = "http://localhost:1040/server/register"; //this projc there is at the my github with the name is myserver
            MyBody body = new MyBody();
            body.setAge(32);
            body.setName("sampleName" + System.nanoTime());
            HttpEntity<MyBody> request = new HttpEntity<MyBody>(body);
            ResponseEntity<String> res = rest.exchange(url, HttpMethod.POST, request, String.class);
            logger.info("res is {}", res.getBody());
            return res.getBody().toString();
        }catch (Exception ex ){
            ex.printStackTrace();
        }
        return "true";
    }

}
