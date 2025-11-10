package aplication.sprint.service;

import aplication.sprint.domain.User;
import aplication.sprint.repository.UsuarioRepository;


import aplication.sprint.web.dto.UsuarioRequest;
import aplication.sprint.web.dto.UsuarioResponse;
import java.util.ArrayList;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceIm implements UsuarioService {

    private final UsuarioRepository repo;

    public UsuarioServiceIm(UsuarioRepository repo) {
        this.repo = repo;
    }

    @Override
    public UsuarioResponse crear(UsuarioRequest req) {

        if (repo.existsByNombreIgnoreCase(req.getNombre())) {
            throw new IllegalArgumentException("nombre duplicado");

        }
        if (repo.existsByEmailIgnoreCase(req.getEmail())) {
               throw new IllegalArgumentException("correo duplicadp");
            
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
        var user = repo.findById(id).orElseThrow(() -> new NoSuchElementException("usuario no encontradoi"));
        return new UsuarioResponse(user.getEdad(),user.getNombre(), user.getEdad(), user.getEmail(), user.getTelefono());

    }

    @Override
    public List<UsuarioResponse> listar() {
        List<User> usuarios = repo.findAll();
        List<UsuarioResponse> respuestas = new ArrayList<>();

        usuarios.forEach(u -> {
            UsuarioResponse response = new UsuarioResponse(
                    u.getId(),
                    u.getNombre(),
                    u.getEdad(),
                    u.getEmail(),
                    u.getTelefono()
            );
            respuestas.add(response);

        });
        return respuestas;

    }

    @Override
    public void eliminar(Integer id) {
        // Busca el usuario por ID (devuelve un Optional)
        var user = repo.findById(id);

        // Si no se encuentra, lanza una excepción
        if (user.isEmpty()) {
            throw new NoSuchElementException("Usuario no encontrado");
        }

        // Si se encuentra, lo elimina
        repo.deleteById(id);
    }

    @Override
    public UsuarioResponse editar(Integer id, UsuarioRequest req) {
        var user = repo.findById(id).orElseThrow(() -> new NoSuchElementException(" no encontrado"));

        if (repo.existsByNombreIgnoreCase(req.getNombre())) {
            throw new IllegalArgumentException("nombre duplicado");

        }

        user.setNombre(req.getNombre());
        user.setEdad(req.getEdad());
        user.setEmail(req.getEmail());
        user.setTelefono(req.getTelefono());

        var newUser = repo.save(user);
        return new UsuarioResponse(newUser.getId(),newUser.getNombre(), newUser.getEdad(), newUser.getEmail(), newUser.getTelefono());

    }

}
