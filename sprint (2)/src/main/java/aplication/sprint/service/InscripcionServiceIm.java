package aplication.sprint.service;

import aplication.sprint.domain.Event;
import aplication.sprint.domain.Inscripcion;

import aplication.sprint.domain.User;
import aplication.sprint.repository.EventRepository;
import aplication.sprint.repository.IncripcionRepository;
import aplication.sprint.repository.UsuarioRepository;
import aplication.sprint.web.dto.InscripcionResponse;
import aplication.sprint.web.dto.InscrpcionRequest;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class InscripcionServiceIm implements InscripcionService {

    private final IncripcionRepository repoIns;
    private final EventRepository repoEvent;
    private final UsuarioRepository repoUse;

    public InscripcionServiceIm(IncripcionRepository repoIns, EventRepository repoEvent, UsuarioRepository repoUse) {
        this.repoIns = repoIns;
        this.repoEvent = repoEvent;
        this.repoUse = repoUse;
    }

    @Override
    public InscripcionResponse crear(InscrpcionRequest req) {
        Event event = repoEvent.findById(req.getEvent()).orElseThrow(() -> new IllegalArgumentException("no se encontro el evento"));
        User user = repoUse.findById(req.getUser()).orElseThrow(() -> new IllegalArgumentException("no se encontro el usuario"));

        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setFechaInscripcion(req.getFechaIncripcion());
        inscripcion.setEvent(event);
        inscripcion.setUser(user);

        var save = repoIns.save(inscripcion);
        return new InscripcionResponse(save.getFechaInscripcion(), save.getUser().getNombre(), save.getEvent().getNombre());

    }

    @Override
    public List<InscripcionResponse> listar() {
        return repoIns.findAll().stream()
                .map(i -> new InscripcionResponse(i.getFechaInscripcion(),i.getUser().getNombre(),i.getEvent().getNombre())
                .
    }

}
    


