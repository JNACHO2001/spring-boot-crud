package aplication.sprint.service;

import aplication.sprint.web.dto.UsuarioRequest;
import aplication.sprint.web.dto.UsuarioResponse;
import java.util.List;

public interface UsuarioService {
    UsuarioResponse crear(UsuarioRequest req);
    UsuarioResponse obtenerPorId(Integer id);
    List<UsuarioResponse> listar();

}
