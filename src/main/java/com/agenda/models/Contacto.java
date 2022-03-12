package com.agenda.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Contacto {
	@GeneratedValue
	@Id
	Long id;
	String nombre;
	String apellidos;
	String telefono;
	String categoria;
}
