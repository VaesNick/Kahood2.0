package Kahood2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication(scanBasePackages = "Kahood2.*")
public class Application{
    public static void main(String[] args) {
        // Launch the application
        SpringApplication.run(Application.class, args);
    }
}

