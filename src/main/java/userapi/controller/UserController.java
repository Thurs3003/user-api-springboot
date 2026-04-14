package userapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import userapi.entity.User;
import userapi.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public List<User> listarUsuarios() {
		return userRepository.findAll();
	}

	@PostMapping
	public User criarUsuario(@RequestBody User user) {
		return userRepository.save(user);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> buscarPorId(@PathVariable Long id){
		return userRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> atualizarUsuario(@PathVariable Long id, @RequestBody User userAtualizado) {
		return userRepository.findById(id)
				.map(user -> {
					user.setNome(userAtualizado.getNome());
					user.setEmail(userAtualizado.getEmail());
					user.setIdade(userAtualizado.getIdade());
					return ResponseEntity.ok(userRepository.save(user));
					})
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletarUsuario(@PathVariable Long id) {
		if (!userRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		userRepository.deleteById(id);
		return ResponseEntity.ok("Usuário deletado com sucesso!");
	}
}
