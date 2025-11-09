package aplication.sprint.controlador;

import aplication.sprint.service.UsuarioServiceIm;
import aplication.sprint.web.dto.ApiResponse;
import aplication.sprint.web.dto.UsuarioRequest;
import aplication.sprint.web.dto.UsuarioResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/usuario")
public class UsuarioControlador {

    private final UsuarioServiceIm service;

    public UsuarioControlador(UsuarioServiceIm service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<UsuarioResponse>> crear(@Valid @RequestBody UsuarioRequest req) {
        var res = service.crear(req);
        return ResponseEntity.ok(
                new ApiResponse<>(true,"Usuario  creado",res)
        
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UsuarioResponse>>> listar() {
        List<UsuarioResponse> usuarios = service.listar();
        return ResponseEntity.ok(
                new ApiResponse<>(true, "Usuarios obtenidos exitosamente", usuarios)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> obtener(@PathVariable Integer id) {

        return ResponseEntity.ok(service.obtenerPorId(id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.ok("Eliminado");

    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> editar(@PathVariable Integer id, @RequestBody UsuarioRequest req) {

        var res = service.editar(id, req);

        return ResponseEntity.ok().body(res);

    }

}
