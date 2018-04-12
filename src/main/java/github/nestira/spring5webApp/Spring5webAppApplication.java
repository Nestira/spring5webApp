package github.nestira.spring5webApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ImportResource("classpath:config.xml")
public class Spring5webAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring5webAppApplication.class, args);
	}
}
