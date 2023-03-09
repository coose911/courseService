package com.codeclan.courseservice.courseservice.Components;

import com.codeclan.courseservice.courseservice.Models.Booking;
import com.codeclan.courseservice.courseservice.Models.Course;
import com.codeclan.courseservice.courseservice.Models.Customer;
import com.codeclan.courseservice.courseservice.Repositories.BookingRepository;
import com.codeclan.courseservice.courseservice.Repositories.CourseRepository;
import com.codeclan.courseservice.courseservice.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {
        Course software = new Course("software", "edinburgh", 5);
        courseRepository.save(software);
        Course data = new Course("data", "london", 3);
        courseRepository.save(data);
        Course ux = new Course("ux", "glasgow", 4);
        courseRepository.save(ux);

        Customer marcus = new Customer("marcus", "edinburgh", 32);
        customerRepository.save(marcus);
        Customer maggie = new Customer("maggie", "dublin", 31);
        customerRepository.save(maggie);
        Customer dan = new Customer("dan", "spain", 26);
        customerRepository.save(dan);

        Booking summerCourse = new Booking("9/3/2023", marcus, software);
        bookingRepository.save(summerCourse);
        Booking winterCourse = new Booking("11/9/2024", maggie, data);
        bookingRepository.save(winterCourse);
        Booking springCourse = new Booking("30/3/2023", dan, ux);
        bookingRepository.save(springCourse);
    }

}
