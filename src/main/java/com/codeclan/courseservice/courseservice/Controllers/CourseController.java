package com.codeclan.courseservice.courseservice.Controllers;

import com.codeclan.courseservice.courseservice.Models.Course;
import com.codeclan.courseservice.courseservice.Repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCourses(
            @RequestParam(required = false, name = "rating") Integer rating,
            @RequestParam(required = false, name="customer") String customer
    ){
        if(customer != null){
            return new ResponseEntity<>(courseRepository.findByBookingsCustomerName(customer), HttpStatus.OK);
        }
        if (rating != null){
            return new ResponseEntity<>(courseRepository.findByRating(rating), HttpStatus.OK);
        }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }
}
