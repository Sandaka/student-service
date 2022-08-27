package com.kingston.msc.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sandaka Wijesinghe.
 * Date: 10/18/21
 */

@RestController
@RequestMapping("/sts/consumer")
public class SecondController {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

//    @Autowired
//    private CourseProviderServiceProxy courseProviderServiceProxy;

    @GetMapping("/message")
    public String test() {
        return "Student service works...";
    }

    /*
     * This is with RestTemplate
     * */
    @GetMapping("/testCP")
    public String testCP() {
        String text = restTemplateBuilder.build().getForObject("http://localhost:8080/cps/course/coursetest", String.class);
        //ResponseEntity responseEntity = restTemplateBuilder.build().getForEntity("http://localhost:8080/cps/course/coursetest",)
        return text;
    }

    /*
    * This is with Feign
    * */
//    @GetMapping("/testCPFeign")
//    public String testCPFeign() {
//        System.out.println("feign method works...");
//        String text = courseProviderServiceProxy.testCPService();
//        return text;
//    }
}
