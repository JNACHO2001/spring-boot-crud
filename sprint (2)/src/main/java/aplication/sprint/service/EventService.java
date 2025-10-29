package aplication.sprint.service;

import aplication.sprint.web.dto.EventRequest;
import aplication.sprint.web.dto.EventResponse;
import java.util.List;

public interface EventService {
    EventResponse crear(EventRequest req );
    EventResponse obtenerPorId(Integer id);
    List<EventResponse>listar();
    public void Eliminar(Integer id );
    
    

}
