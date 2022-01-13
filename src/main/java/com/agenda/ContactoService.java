package com.agenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactoService {
	@Autowired
	ContactoRepository repo;
	
	public Iterable<Contacto> findAll() {
		return repo.findAll();
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
