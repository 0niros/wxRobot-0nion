package cn.com.oniros;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "cn.com.oniros.dao")
public class WxRobotApplication {
    public static void main( String[] args ) {
        SpringApplication.run(WxRobotApplication.class, args);
    }
}
