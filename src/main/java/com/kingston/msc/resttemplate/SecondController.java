package com.kingston.msc.resttemplate;

import com.kingston.msc.entity.Tags;
import com.kingston.msc.repository.TagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sandaka Wijesinghe.
 * Date: 10/18/21
 */

@RestController
@RequestMapping("/sts")
public class SecondController {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    private CourseProviderServiceProxy courseProviderServiceProxy;

    @Autowired
    private TagsRepository tagsRepository;

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
    @GetMapping("/testCPFeign")
    public String testCPFeign() {
        System.out.println("feign method works...");
        String text = courseProviderServiceProxy.testCPService();
        return text;
    }


    // get tags by names test route
    @GetMapping("/tags")
    public List<Tags> findAllTagsByName(){

        List<String> tagList = new ArrayList<>();
        tagList.add("Java");
        tagList.add("Spring boot");

        return tagsRepository.findTagsByTagNameIn(tagList);
    }
}
