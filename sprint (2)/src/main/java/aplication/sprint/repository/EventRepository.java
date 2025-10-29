package aplication.sprint.repository;

import aplication.sprint.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventRepository  extends JpaRepository<Event, Integer>{
    
    boolean existsByNombreIgnoreCase(String nombre);

}
