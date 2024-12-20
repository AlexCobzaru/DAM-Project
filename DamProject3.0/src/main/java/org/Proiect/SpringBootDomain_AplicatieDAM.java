package org.Proiect;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.logging.Logger;

@SpringBootApplication

public class SpringBootDomain_AplicatieDAM extends SpringBootServletInitializer
{
	private static Logger logger = Logger.getLogger(SpringBootDomain_AplicatieDAM.class.getName());
	
	public static void main(String[] args) {
		logger.info("Loading ... :: SpringBoot - AplicatieDAM Default Settings ...  ");
		SpringApplication.run(SpringBootDomain_AplicatieDAM.class, args);
	}
	@Bean
	public ModelMapper setupModelMapper(){
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration()
				.setFieldMatchingEnabled(true)
				.setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
				.setSkipNullEnabled(true);
		return mapper;
	}
}