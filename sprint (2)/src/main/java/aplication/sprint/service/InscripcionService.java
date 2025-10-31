package aplication.sprint.service;

import aplication.sprint.web.dto.InscripcionResponse;
import aplication.sprint.web.dto.InscrpcionRequest;

public interface InscripcionService {
    
    InscripcionResponse crear(InscrpcionRequest req);
    

}
