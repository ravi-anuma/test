/*
package com.test.TestProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class FizzBuzzApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FizzBuzzApiApplication.class, args);
    }
}

@RestController
@RequestMapping("/api")
class FizzBuzzController {

    @GetMapping("/fizzbuzz/{number}")
    public String fizzBuzz(@PathVariable int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "fizz buzz";
        } else if (number % 3 == 0) {
            return "fizz";
        } else if (number % 5 == 0) {
            return "buzz";
        } else {
            return String.valueOf(number);
        }
    }
}
*/
