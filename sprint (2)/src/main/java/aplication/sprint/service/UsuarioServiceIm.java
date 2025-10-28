package aplication.sprint.service;

import aplication.sprint.domain.User;
import aplication.sprint.repository.UsuarioRepository;
import aplication.sprint.web.dto.UsuarioRequest;
import aplication.sprint.web.dto.UsuarioResponse;
import java.util.List;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServiceIm implements UsuarioService{
    
    private final UsuarioRepository repo;

    public UsuarioServiceIm(UsuarioRepository repo) {
        this.repo = repo;
    }
    
    

    @Override
    public UsuarioResponse crear(UsuarioRequest req) {
        
        if (repo.existsByNombreIgnoreCase(req.getNombre())) {
            throw new IllegalArgumentException("nombre duplicado");
            
        }
        
        var user = new User(req.getNombre(), req.getEdad(), req.getEmail(), req.getTelefono());
       var saved = repo.save(user);
        
       
              return new UsuarioResponse(
        saved.getId(),
        saved.getNombre(),
        saved.getEdad(),
        saved.getEmail(),
        saved.getTelefono()
    );
        
    }

    @Override
    public UsuarioResponse obtenerPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<UsuarioResponse> listar() {
        return  repo.findAll().stream()
                .map(e -> new UsuarioResponse(e.getId(),e.getNombre(),e.getEdad(), e.getEmail(),e.getTelefono()))
                .toList();
    }

}
