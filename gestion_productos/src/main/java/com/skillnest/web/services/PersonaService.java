package com.skillnest.web.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skillnest.web.models.Persona;
import com.skillnest.web.repositories.PersonaRepository;

@Service
public class PersonaService {

   /* @Autowired
    private PersonaDao personaDao;

    public List<Persona> listarPersonas() {
        return personaDao.obtenerTodas();
    }

    public void registrarPersona(Persona persona) {
      int retorno =  personaDao.insertar(persona);
    }

    public void eliminarPersona(Long id) {
        personaDao.eliminar(id);
    }
    */
	//@Autowired
	//PersonaRepository pR;
    
	//agregar el repository como dependencia
	private final PersonaRepository personaRepository;
	
	//constructor
	public PersonaService(PersonaRepository personaRepository) {
		this.personaRepository = personaRepository;
	}
	
	//metodos
    public Persona registrarPersona(Persona persona) {
    	//Persona persona_retorno = personaRepository.save(persona);
    	//return persona_retorno;
    	return personaRepository.save(persona);
      }
	
	
    //findByEmail
    
    public List<Persona> listarTodas() {
        return personaRepository.findAll();
    }

    public Persona buscarPorId(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    public void eliminarPersona(Long id) {
        personaRepository.deleteById(id);
    }
}
