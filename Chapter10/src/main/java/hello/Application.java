package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Application  入口类
 * ComponentScan  要扫描哪些组件
 * @author shengfulankuli
 * @create 2021-12-29 20:31
 */
@SpringBootApplication
@ComponentScan("com.course")
public class Application {

        public static void main(String[] args) {
                SpringApplication.run(Application.class,args);
        }

}
