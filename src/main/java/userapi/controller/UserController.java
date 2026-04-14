package userapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import userapi.entity.User;
import userapi.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> listarUsuarios() {
		return userService.listarUsuarios();
	}

	@PostMapping
	public User criarUsuario(@Valid @RequestBody User user) {
		return userService.criarUsuario(user);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> buscarPorId(@PathVariable Long id){
		return userService.buscarPorId(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarUsuario(@PathVariable Long id, @Valid @RequestBody User userAtualizado) {
		return userService.atualizarUsuario(id, userAtualizado);			
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletarUsuario(@PathVariable Long id) {
		return userService.deletarUsuario(id);
	}
}
