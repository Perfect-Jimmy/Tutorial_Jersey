package tutorial.jersey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JerseyApp{
	
    public static void main( String[] args ){
        SpringApplication.run(JerseyApp.class, args);
    }
    
    @RequestMapping("/hello")
    public String hello(){
    	System.out.println("Hello");
    	return "Hello";
    }
}
