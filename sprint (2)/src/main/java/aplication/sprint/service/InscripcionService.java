package aplication.sprint.service;

import aplication.sprint.web.dto.InscripcionResponse;
import aplication.sprint.web.dto.InscrpcionRequest;
import java.util.List;

public interface InscripcionService {
    
    InscripcionResponse crear(InscrpcionRequest req);
    List<InscripcionResponse>listar();
    
    

}
