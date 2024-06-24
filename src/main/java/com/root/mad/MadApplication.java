package com.root.mad;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MadApplication {

    public static void main(String[] args) {
        final Dotenv dotenv = Dotenv.configure().load();
        dotenv.entries().forEach(entry -> System.out.println(entry.getKey() + "=" + entry.getValue()));
        SpringApplication.run(MadApplication.class, args);
    }

}
