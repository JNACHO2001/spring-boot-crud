package aplication.sprint.web.dto;

public class UsuarioResponse {
     private String nombre;
    private int edad;
    private String email;
    private Long telefono;

    public UsuarioResponse(String nombre, int edad, String email, Long telefono) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getEmail() {
        return email;
    }

    public Long getTelefono() {
        return telefono;
    }
    

}
