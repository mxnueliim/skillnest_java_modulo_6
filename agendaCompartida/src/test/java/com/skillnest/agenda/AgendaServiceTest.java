package com.skillnest.agenda;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import com.skillnest.agenda.model.Evento;
import com.skillnest.agenda.service.AgendaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
// Se reinicia el contexto tras cada test para no “arrastrar” la lista en memoria
class AgendaServiceTest {

    @Autowired
    private AgendaService agendaService;

    @Test
    void agregarEvento_debeIncrementarListado() {
        Evento e = new Evento();
        e.setTitulo("Cumpleaños equipo");
        e.setFecha(LocalDate.now().plusDays(1));
        e.setDescripcion("Torta y café");
        e.setResponsable("Manuel");

        agendaService.agregar(e);

        List<Evento> todos = agendaService.listar();
        assertEquals(1, todos.size());
        assertEquals("Cumpleaños equipo", todos.get(0).getTitulo());
    }

    @Test
    void buscarPorFecha_debeRetornarSoloEventosDeEseDia() {
        LocalDate hoy = LocalDate.now();
        LocalDate mañana = hoy.plusDays(1);

        Evento a = new Evento();
        a.setTitulo("Daily");
        a.setFecha(hoy);
        a.setResponsable("Equipo A");
        agendaService.agregar(a);

        Evento b = new Evento();
        b.setTitulo("Plan sprint");
        b.setFecha(hoy);
        b.setResponsable("Equipo B");
        agendaService.agregar(b);

        Evento c = new Evento();
        c.setTitulo("Revisión UX");
        c.setFecha(mañana);
        c.setResponsable("Equipo C");
        agendaService.agregar(c);

        List<Evento> soloHoy = agendaService.buscarPorFecha(hoy);
        assertEquals(2, soloHoy.size());
        assertTrue(soloHoy.stream().anyMatch(ev -> "Daily".equals(ev.getTitulo())));
        assertTrue(soloHoy.stream().anyMatch(ev -> "Plan sprint".equals(ev.getTitulo())));
    }
}
