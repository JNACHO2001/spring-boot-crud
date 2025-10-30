package aplication.sprint.service;

import aplication.sprint.web.dto.UsuarioRequest;
import aplication.sprint.web.dto.UsuarioResponse;
import java.util.List;

public interface UsuarioService {

    UsuarioResponse crear(UsuarioRequest req);

    UsuarioResponse obtenerPorId(Integer id);

    UsuarioResponse editar(Integer id, UsuarioRequest req);

    List<UsuarioResponse> listar();

    public void eliminar(Integer id);

}
