package com.kingston.msc.resttemplate;

import com.kingston.msc.model.StudentPostDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Sandaka Wijesinghe.
 * Date: 6/19/22
 */

@FeignClient(name = "COURSE-PROVIDER-SERVICE", url = "http://localhost:8080")
//Service Id of course-provider-service service
public interface CourseProviderServiceProxy {

    @RequestMapping("/cps/courseFeign")
    String testCPService();

    @RequestMapping("/cps/reg_id/{id}")
    long getRegIdBySmsUserId(@PathVariable(value = "id") long id);

    @RequestMapping("/cps/students_by_regIds")
    List<StudentPostDto> getStudentsByRegIds();
}
