package aplication.sprint.web.dto;

import java.time.LocalDate;


public class InscripcionResponse {
    
    private LocalDate fechaInscripcion;
    private Integer user;
    private Integer event;

    public InscripcionResponse(LocalDate fechaInscripcion, Integer user, Integer event) {
        this.fechaInscripcion = fechaInscripcion;
        this.user = user;
        this.event = event;
    }

    public InscripcionResponse() {
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getEvent() {
        return event;
    }

    public void setEvent(Integer event) {
        this.event = event;
    }

   
    
    
  
    
    
    

}
