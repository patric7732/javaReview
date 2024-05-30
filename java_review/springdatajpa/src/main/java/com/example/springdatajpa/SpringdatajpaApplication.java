package com.example.springdatajpa;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class SpringdatajpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(UserRepository repository){
		return args -> {
//			// 생성 create
//			User user = new User("patric", "patric@exam.com");
//			repository.save(user);
//			log.info("사용자 추가 : " + user.getName());
//
//			// 삭제 delete
//			repository.delete(user);
//			log.info("사용자 삭제 : " + user.getName());

			// 조회
//			List<User> users = repository.findByName("Jeon");
//			users.forEach(user -> log.info(user.getName() + "::" + user.getEmail()));

//			List<User> users = repository.findByEmail("jeon@exam.com");
//			users.forEach(user -> log.info(user.getEmail()));

			List<User> users = repository.findByNameAndEmail("Jeon", "jeon@exam.com");
			users.forEach(user -> log.info(user.getName() + " :: " + user.getEmail()));
		};
	}
}
