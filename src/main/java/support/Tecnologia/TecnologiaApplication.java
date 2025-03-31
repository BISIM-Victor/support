package support.Tecnologia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import support.Tecnologia.config.DatasourceConfig;

@SpringBootApplication
public class TecnologiaApplication extends SpringBootServletInitializer {

	private final DatasourceConfig datasourceConfig;

	@Autowired
	public TecnologiaApplication(DatasourceConfig datasourceConfig) {
		this.datasourceConfig = datasourceConfig;
	}

	public static void main(String[] args) {
		SpringApplication.run(TecnologiaApplication.class, args);
		System.out.println("Aplicación Iniciada...");
	}

	@Bean
	public CommandLineRunner printDatasourceUrl() {
		return args -> System.out.println("Base de datos configurada: " + datasourceConfig.getDatasourceUrl());
	}
}
