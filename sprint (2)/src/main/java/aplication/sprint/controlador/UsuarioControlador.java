package aplication.sprint.controlador;

import aplication.sprint.service.UsuarioServiceIm;
import aplication.sprint.web.dto.ApiResponse;
import aplication.sprint.web.dto.UsuarioRequest;
import aplication.sprint.web.dto.UsuarioResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity<ApiResponse<UsuarioResponse>> obtener(@PathVariable Integer id) {

        var user = service.obtenerPorId(id);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Usuario obtenido", user)
        );

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
