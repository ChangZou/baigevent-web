package top.qingxing.baigeventweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class BaigeApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaigeApplication.class, args);
    }

}
