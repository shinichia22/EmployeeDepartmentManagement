package com.empdep.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;



@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class EmpDepCrudApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(EmpDepCrudApplication.class, args);
	}

}
