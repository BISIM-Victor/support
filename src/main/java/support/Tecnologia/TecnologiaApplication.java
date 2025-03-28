package support.Tecnologia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TecnologiaApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TecnologiaApplication.class, args);
		System.out.println("Aplicacion Iniciada...");
	}

}
