package aplication.sprint.service;

import aplication.sprint.web.dto.EventRequest;
import aplication.sprint.web.dto.EventResponse;

public interface EventService {
    EventResponse crear(EventRequest req );
    
    

}
