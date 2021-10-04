package com.exam;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repo.QuizRepository;
import com.exam.service.UserService;

@SpringBootApplication
public class ExamPortalApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public QuizRepository quizRepository;

    public static void main(String[] args) {


        SpringApplication.run(ExamPortalApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
        try {


            System.out.println("starting code");

			
			  User user = new User();
			  
			  user.setFirstName("Vishal"); user.setLastName("Singh");
			  user.setUsername("vishalsin888");
			  user.setPassword(this.bCryptPasswordEncoder.encode("123456"));
			  user.setEmail("vishalsin@gmail.com"); user.setProfile("admin.png");
			  
			  Role role1 = new Role(); role1.setRoleId(1L); role1.setRoleName("ADMIN");
			  
			  Set<UserRole> userRoleSet = new HashSet<>(); UserRole userRole = new
			  UserRole();
			  
			  userRole.setRole(role1);
			  
			  userRole.setUser(user);
			  
			  userRoleSet.add(userRole);
			  
			  User user1 = this.userService.createUser(user, userRoleSet);
			  System.out.println(user1.getUsername());
			  
			  
			  
			  } catch(Exception e) { System.out.println("user found execption");
			  e.printStackTrace();
			 
			}
			finally {
					System.out.println("finally");
				}

    }


}
