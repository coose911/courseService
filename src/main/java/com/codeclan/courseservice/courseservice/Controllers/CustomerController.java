package com.codeclan.courseservice.courseservice.Controllers;

import com.codeclan.courseservice.courseservice.Models.Customer;
import com.codeclan.courseservice.courseservice.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(
            @RequestParam(required = false, name = "course") String course,
            @RequestParam(required = false, name = "town") String town,
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(required = false, name = "age") Integer age,
            @RequestParam(required = false, name = "courseTown") String courseTown
//            @RequestParam(required = false, name = "name") String name


    ){
        if(age != null && courseTown != null && name != null)
            return new ResponseEntity<>(customerRepository.findByAgeAndTownAndBookingsCourseName(age, courseTown, name), HttpStatus.OK);

        if (course != null){
            return new ResponseEntity<>(customerRepository.findByBookingsCourseName(course), HttpStatus.OK);
        }
        if (town != null && name != null){
            return new ResponseEntity<>(customerRepository.findByTownAndBookingsCourseName(town, name), HttpStatus.OK);
        }

        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
}
