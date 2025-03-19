package group.practices.java.eurekaserverdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerdemoApplication.class, args);
    }

}
