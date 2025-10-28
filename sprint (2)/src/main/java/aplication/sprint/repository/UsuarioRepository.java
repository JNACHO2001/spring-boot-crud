package aplication.sprint.repository;

import aplication.sprint.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<User, Integer> {
    
boolean existsByNombreIgnoreCase(String nombre);

    
}
