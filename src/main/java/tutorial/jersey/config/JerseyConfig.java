package tutorial.jersey.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import tutorial.jersey.controller.JerseyController;
import tutorial.jersey.controller.JerseyControllerXml;

@Configuration
@ApplicationPath("/rest")
public class JerseyConfig extends ResourceConfig {
	 public JerseyConfig() {
        register(JerseyController.class);//返回json格式
        register(JerseyControllerXml.class);//返回xml格式
        //packages("com.vergilyn.demo.springboot.jersey"); // 通过packages注册。
     }
}
