package com.agenda.services;

import com.agenda.models.Contacto;
import com.agenda.repositories.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactoService {
	@Autowired
	ContactoRepository repo;
	
	public Iterable<Contacto> findAll() {
		return repo.findAll();
	}
	public List<Contacto> findAllFamilia(){
		return repo.findAll().stream()
				.filter(c -> c.getCategoria().contentEquals("Familia"))
				.collect(Collectors.toCollection(ArrayList<Contacto>::new));
	}
	public List<Contacto> findAllTrabajo(){
		return repo.findAll().stream()
				.filter(c -> c.getCategoria().contentEquals("Trabajo"))
				.collect(Collectors.toCollection(ArrayList<Contacto>::new));
	}
	public List<Contacto> findAllAmigos(){
		return repo.findAll().stream()
				.filter(c -> c.getCategoria().contentEquals("Amigos"))
				.collect(Collectors.toCollection(ArrayList<Contacto>::new));
	}
	public void save(Contacto entidad) {
		repo.save(entidad);
	}

	public void delete(Contacto c) {
		repo.delete(c);	
	}
	
	public Contacto findById(Long id) {
		return repo.findById(id)
				.orElse(null);
	}
	
}
