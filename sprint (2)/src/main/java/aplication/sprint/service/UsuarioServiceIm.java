package aplication.sprint.service;

import aplication.sprint.domain.User;
import aplication.sprint.repository.UsuarioRepository;
import aplication.sprint.web.dto.UsuarioRequest;
import aplication.sprint.web.dto.UsuarioResponse;
import java.util.List;

public class UsuarioServiceIm implements UsuarioService{
    
    private final UsuarioRepository repo;

    public UsuarioServiceIm(UsuarioRepository repo) {
        this.repo = repo;
    }
    
    

    @Override
    public UsuarioResponse crear(UsuarioRequest req) {
        
        if (repo.existeNombre(req.getNombre())) {
            throw new IllegalArgumentException("nombre duplicado");
            
        }
        
        var e = new User();
        e.setNombre(req.getNombre());
        e.setEdad(req.getEdad());
        e.setEmail(req.getEmail());
        e.setTelefono(req.getTelefono());
        
        var save =repo.save(e);
        return  new UsuarioResponse(save.getNombre(),save.getEdad(),save.getEmail(),save.getTelefono());
                
        
    }

    @Override
    public UsuarioResponse obtenerPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<UsuarioResponse> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
