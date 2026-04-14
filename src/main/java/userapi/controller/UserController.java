package userapi.controller;

import java.util.List;

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
	public User buscarPorId(@PathVariable Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	@PutMapping("/{id}")
	public User atualizarUsuario(@PathVariable Long id, @RequestBody User userAtualizado) {
		User user = userRepository.findById(id).orElse(null);
		
		if (user == null) {
			return null;
		}
		
		user.setNome(userAtualizado.getNome());
		user.setEmail(userAtualizado.getEmail());
		user.setIdade(userAtualizado.getIdade());
		
		return userRepository.save(user);
		
	}
	
	@DeleteMapping("/{id}")
	public String deletarUsuario(@PathVariable Long id) {
		if (!userRepository.existsById(id)) {
			return "Usuário não encontado.";
		}
		
		userRepository.deleteById(id);
		return "Usuário deletado com sucesso.";
	}
}
