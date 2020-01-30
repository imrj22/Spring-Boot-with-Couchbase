package com.couchbase.StudentDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.couchbase.StudentDB")
@SpringBootApplication
public class SpringBootWithCouchbaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithCouchbaseApplication.class, args);
	}

}
