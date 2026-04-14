package userapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import userapi.entity.User;

@RestController
public class UserController {

	@GetMapping("/users")
	public List<User> listarUsuarios() {
		return List.of(
			new User(1L, "Arthur", "arthur@email.com", 20), 
			new User(2L, "Maria", "maria@email.com", 22)
		);
	}
}
