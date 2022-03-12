package com.agenda.repositories;

import com.agenda.models.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Long> {
	
	void deleteByTelefono(String telefono);
}
