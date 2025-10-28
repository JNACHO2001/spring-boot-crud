package aplication.sprint.web.dto;

import jakarta.validation.constraints.NotBlank;

public class UsuarioRequest {
    
   
    @NotBlank(message = "nombre obligatorio")
     private String nombre;
    @NotBlank(message = "edad obligatorio")
    private int edad;
    @NotBlank(message = "email obligatorio")
    private String email;
    @NotBlank(message = "telefono obligatorio")
    private Long telefono;



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }
    
    


}
