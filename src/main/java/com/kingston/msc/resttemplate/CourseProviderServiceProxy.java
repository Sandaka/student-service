package com.kingston.msc.resttemplate;

//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Sandaka Wijesinghe.
 * Date: 6/19/22
 */

//@FeignClient(name="course-provider-service", url = "http://localhost:8080")//Service Id of course-provider-service service
public interface CourseProviderServiceProxy {

    @RequestMapping("/cps/course/courseFeign")
    public String testCPService();
}
