package userapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import userapi.entity.User;
import userapi.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> listarUsuarios() {
		return userRepository.findAll();
	}

	public User criarUsuario(User user) {
		if (userRepository.existsByEmail(user.getEmail())) {
			throw new IllegalArgumentException("Este E-mail já está sendo utilizado por outro usuário.");
		}

		return userRepository.save(user);
	}

	public ResponseEntity<User> buscarPorId(Long id) {
		return userRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<?> atualizarUsuario(Long id, User userAtualizado) {
		return userRepository.findById(id)
                .map(user -> {
                    Optional<User> usuarioComMesmoEmail = userRepository.findByEmail(userAtualizado.getEmail());

                    if (usuarioComMesmoEmail.isPresent() && usuarioComMesmoEmail.get().getId() != id) {
                        return ResponseEntity.badRequest().body("Já existe um usuário com esse email.");
                    }

                    user.setNome(userAtualizado.getNome());
                    user.setEmail(userAtualizado.getEmail());
                    user.setIdade(userAtualizado.getIdade());

                    return ResponseEntity.ok(userRepository.save(user));
                })
				.orElse(ResponseEntity.notFound().build());
	}
	
	public ResponseEntity<String> deletarUsuario(Long id) {
		if (!userRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		userRepository.deleteById(id);
		return ResponseEntity.ok("Usuario deletado com sucesso.");
	}
}
