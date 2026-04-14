package userapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import userapi.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
