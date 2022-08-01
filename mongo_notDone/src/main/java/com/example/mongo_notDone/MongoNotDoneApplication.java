package com.example.mongo_notDone;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import repository.UserRepository;

@SpringBootApplication
public class MongoNotDoneApplication implements CommandLineRunner {

	private final UserRepository userRepository;

	@Autowired
	public MongoNotDoneApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(MongoNotDoneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(userRepository.findAll().isEmpty()){
			userRepository.save(new User("u1", "pw1"));
			userRepository.save(new User("u2", "pw2"));
		}

		userRepository.findAll().forEach(System.out::println);
	}

}
