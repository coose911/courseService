package com.codeclan.courseservice.courseservice.Repositories;

import com.codeclan.courseservice.courseservice.Models.Booking;
import com.codeclan.courseservice.courseservice.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseName(String course);
    List<Customer> findByTownAndBookingsCourseName(String town, String name);

    List<Customer> findByAgeAndTownAndBookingsCourseName(int age, String courseTown, String name);

}
