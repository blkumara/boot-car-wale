package com.ty.bootcarwaleapp;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;

	@PostMapping("/saveuser")
	public User saveUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	@PostMapping("/alluser")
	public List<User> allUser() {
		return userRepository.findAll();
	}

	@PostMapping("/getUserbyid/{id}")
	public User getUserById(@PathVariable int id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return optional.get();
		}
	}

	@PostMapping("/deleteuser")
	public User deleteUser(@RequestParam int id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			User user = userRepository.getById(id);
			userRepository.delete(user);
			return user;
		}

	}

	@PostMapping("/updateuser/{id}")
	public User updateUser(@RequestBody User user, @PathVariable int id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return userRepository.save(user);

		}
	}

	@PostMapping("/findbyemail/{email}")
	public List<User> findUserByEmail(@PathVariable String email) {
		return userRepository.findByEmail(email);
	}

	@PostMapping("/findbyphone/{phone}")
	public List<User> findByPhone(@PathVariable long phone) {
		return userRepository.findByPhone(phone);
	}

	@PostMapping("/getdata/{gender},{role}")
	public List<User> getData(@PathVariable String gender, @PathVariable String role) {
		return userRepository.getData(gender, role);
	}

	@PostMapping("/validateuser/{email},{password}")
	public List<User> validateUser(@PathVariable String email, @PathVariable String password) {
		return userRepository.validateUser(email, password);
	}

}
