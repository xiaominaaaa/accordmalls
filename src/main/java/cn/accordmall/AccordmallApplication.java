package cn.accordmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@MapperScan("cn.accordmall.mapper")
@EnableOpenApi
public class AccordmallApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccordmallApplication.class, args);
    }

}
