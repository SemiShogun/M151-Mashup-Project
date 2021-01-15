package ch.bbw.jl.idunno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class IdunnoApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdunnoApplication.class, args);
    }

}
