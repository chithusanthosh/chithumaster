package com.chithu.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(scanBasePackages = { "com.chithu.app.database", "com.chithu.app.entity", 
		"com.chithu.app.rowmapper", "com.chithu.app.user.dao","com.chithu.app.user.dao.impl",
		"com.chithu.app.usercontroller"})
@EntityScan("com.chithu.app*")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

