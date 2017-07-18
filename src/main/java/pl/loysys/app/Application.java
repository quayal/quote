package pl.loysys.app;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableJpaRepositories
public class Application {


    public static void main(String[] args) {
       SpringApplication.run(Application.class);
    }

}

