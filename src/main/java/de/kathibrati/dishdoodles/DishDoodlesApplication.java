package de.kathibrati.dishdoodles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class DishDoodlesApplication {

    public static void main(String[] args) {
        SpringApplication.run(DishDoodlesApplication.class, args);
    }

}
