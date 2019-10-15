package com.Inventory.MWJ.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Inventory.MWJ.Model.ServiceResponse;
import com.Inventory.MWJ.Model.User;
import com.Inventory.MWJ.Repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/secure")
public class AdminController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@PostMapping("/register")
	public String addUserByAdmin(@RequestBody User user) {
		try {

			String pwd = user.getReg_new_user_password_input();

			String cpwd = user.getReg_new_user_confirm_password_input();
			
			String encryptPwd = passwordEncoder.encode(pwd);

			String encryptcPwd = passwordEncoder.encode(cpwd);

			user.setReg_new_user_password_input(encryptPwd);

			user.setReg_new_user_confirm_password_input(encryptcPwd);

			userRepository.save(user);
			return "user added successfully...";
		} catch (Exception e) {
			System.out.println(e);
		}
		return "Internal error";
	}

	@PostMapping("/updatepassword")
	public ServiceResponse updatepassword(@RequestBody User user) {
		ServiceResponse response = new ServiceResponse();
		if (user != null && user.getReg_new_user_name_input() != null && user.getReg_new_user_name_input().length() > 0
				&& user.getNewpassword() != null & user.getNewpassword().length() > 0
				&& user.getReg_new_user_password_input() != null
				&& user.getReg_new_user_password_input().length() > 0) {
			// GET DATA FROM DB
			User userfromdb = userRepository.find(user.getReg_new_user_name_input());

			if (userfromdb != null && userfromdb.getReg_new_user_password_input() != null) {
				if (passwordEncoder.matches(user.getReg_new_user_password_input(),
						userfromdb.getReg_new_user_password_input())) {
					userfromdb.setReg_new_user_password_input(passwordEncoder.encode(user.getNewpassword()));
					userRepository.save(userfromdb);
					response.setStatusMessage("password updated successfully");

				} else {
					response.setStatusMessage("Invalid Credentials");
				}
			} else {
				response.setStatusMessage("no data found in db");
			}

		} else {
			response.setStatusMessage("no such data found");
		}

		return response;
	}

	@PostMapping("/login")
	public ServiceResponse loginUser(@RequestBody User user) {
		ServiceResponse response = new ServiceResponse();
		/* response.setUser(null); */

		if (user != null && user.getReg_new_user_name_input() != null && user.getReg_new_user_name_input().length() > 0
				&& user.getReg_new_user_password_input() != null
				&& user.getReg_new_user_password_input().length() > 0) {
			// GET ACTUAL DATA FROM DB
			User userFromDb = userRepository.find(user.getReg_new_user_name_input());
			if (userFromDb != null && userFromDb.getReg_new_user_password_input() != null) {
				if (passwordEncoder.matches(user.getReg_new_user_password_input(),
						userFromDb.getReg_new_user_password_input())) {
					response.setStatusCode(1);
					response.setStatusMessage("Succesfully logged in");
					/*
					 * userFromDb.setReg_new_user_password_input("");
					 * userFromDb.setReg_new_user_confirm_password_input("");
					 */
					response.setUser(userFromDb);
					System.out.println("Succesfully logged in");
				} else {
					response.setStatusCode(0);
					response.setStatusMessage("Invalid Credentials");
					System.out.println("Invalid Credentials");
				}
			}

			else {
				response.setStatusCode(0);
				response.setStatusMessage("No User Found");
				System.out.println("No User Found");
			}

		} else {
			response.setStatusCode(0);
			response.setStatusMessage("User Data Requried");
			System.out.println("User Data Requried");

		}

		return response;
	}

}
