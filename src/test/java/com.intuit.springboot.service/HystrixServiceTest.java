package com.intuit.springboot.service;

import com.intuit.springboot.Main;
import com.intuit.springboot.api.HystrixApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
@WebAppConfiguration
public class HystrixServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(HystrixServiceTest.class);

    @Autowired
    private HystrixApi hystrixApi;

    @Test
    public void test() {

        for(int i=0; i< 200; i++) {
            try {
                Thread.sleep(1000);
                String response = hystrixApi.remoteCall(""+i);
                logger.info("Calling the remote service " + i + " and the response is '" + response + "'");
            }catch(Exception e) {
                logger.error("Error thrown", e);
            }

        }
    }

}