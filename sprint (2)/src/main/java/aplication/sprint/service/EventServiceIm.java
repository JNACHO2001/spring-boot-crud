package aplication.sprint.service;

import aplication.sprint.domain.Event;
import aplication.sprint.repository.EventRepository;
import aplication.sprint.web.dto.EventRequest;
import aplication.sprint.web.dto.EventResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

@Service
public class EventServiceIm implements EventService {

    private final EventRepository repo;

    public EventServiceIm(EventRepository repo) {
        this.repo = repo;
    }

    @Override
    public EventResponse crear(EventRequest req) {

        if (repo.existsByNombreIgnoreCase(req.getNombre())) {
            throw new IllegalArgumentException("nombre duplicado");

        }

        var event = new Event(req.getNombre(), req.getFechaEvento(), req.getUbicacion());
        var save = repo.save(event);

        return new EventResponse(
                save.getNombre(),
                save.getFechaEvento(),
                save.getUbicacion()
        );
    }

    @Override
    public EventResponse obtenerPorId(Integer id) {
        var event = repo.findById(id).orElseThrow(()->new NoSuchElementException("evento no encontrado"));
        
        return  new EventResponse(event.getNombre(),event.getFechaEvento(),event.getUbicacion());
        
    }

    @Override
    public List<EventResponse> listar() {
        return repo.findAll().stream()
                .map(event ->  new EventResponse(event.getNombre(), event.getFechaEvento(), event.getUbicacion())).toList();
    }

    @Override
    public void Eliminar(Integer id) {
        var event = repo.findById(id);
        if (event == null) {
            throw new NoSuchElementException("evento no encontrado");
            
        }
        
        repo.deleteById(id);
    }
    
}
