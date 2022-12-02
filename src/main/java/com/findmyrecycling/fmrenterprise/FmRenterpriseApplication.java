package com.findmyrecycling.fmrenterprise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FmRenterpriseApplication  {

    public static void main(String[] args) {
        SpringApplication.run(FmRenterpriseApplication.class, args);
    }

}
