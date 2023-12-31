package com.jpa.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.entities.User;
import com.jpa.test.dao.UserRepository;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		
		/*
		 * Below code add single and multiple user to DB                                                                                                                                                                                                                                     
		 */
		
		/*
		User user = new User();
		user.setName("Durgesh Kumar Tiwari");
		user.setCity("Pune");
		
		User user1 = new User();
		user1.setName("Durgesh Kumar Tiwari");
		user1.setCity("Pune");

		//save single user
		//User user1 = userRepository.save(user);
		
		//below way you can save multiple user
		ArrayList<User> users = new ArrayList<User>();
		users.add(user1);
		users.add(user);
		Iterable<User> result = userRepository.saveAll(users);
		
		for(User value : result) {
			   System.out.println(value);
		}	
		
		*/
		
		
		/*
		 * Below code update the record
		 */
		/*
		Optional<User> optional = userRepository.findById(1);
		User user = optional.get();
		System.out.println(user);
		user.setName("Anil Kumbale");
		userRepository.save(user);
		*/
		
		/*
		 * Iterate all records
		 */
		/*
		Iterable<User> itr = userRepository.findAll();
		Iterator<User> iterator = itr.iterator();
		
		while(iterator.hasNext()) {
			User user2=(User) iterator.next();
			System.out.println(user2);
		}
		*/
		
		/*
		 * Delete record
		 */
		//userRepository.deleteById(1);
		/*
		List<User> users = userRepository.findByName("Durgesh Kumar Tiwari");
		for(User u: users) {
			System.out.println(u);
		}
		*/
		
		List<User> allUsers = userRepository.getAllUsers();
		for(User u: allUsers) {
			System.out.println(u);
		}
		
	}
}
