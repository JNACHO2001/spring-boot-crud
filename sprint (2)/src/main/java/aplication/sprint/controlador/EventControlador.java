package aplication.sprint.controlador;

import aplication.sprint.service.EventServiceIm;
import aplication.sprint.web.dto.EventRequest;
import aplication.sprint.web.dto.EventResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/event")
public class EventControlador {
    
    
    private final EventServiceIm service;

    public EventControlador(EventServiceIm service) {
        this.service = service;
    }
    
    
    
    @PostMapping
    public ResponseEntity<EventResponse>  crear(@Valid  @RequestBody EventRequest req ){
    var res = service.crear(req);
     return  ResponseEntity.status(HttpStatus.CREATED).body(res);
    
    }
    
    

}
