package aplication.sprint.controlador;

import aplication.sprint.service.InscripcionServiceIm;
import aplication.sprint.web.dto.InscripcionResponse;
import aplication.sprint.web.dto.InscrpcionRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/inscripcion")
public class InscripcionControlador {
    
    private final InscripcionServiceIm service;

    public InscripcionControlador(InscripcionServiceIm service) {
        this.service = service;
    }
    
    
    @PostMapping
    public ResponseEntity<InscripcionResponse>crear(@Valid  @RequestBody  InscrpcionRequest  req){
        InscripcionResponse response =service.crear(req);
        
        return ResponseEntity.ok(response);
      
    
    
    }    

}
