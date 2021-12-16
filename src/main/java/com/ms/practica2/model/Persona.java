package com.ms.practica2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.persistence.Lob;
import java.sql.Blob;

@AllArgsConstructor
@Getter
@Setter
@Table("Persona")
public class Persona {

	@PrimaryKey
	private @NonNull String dni;
	private @NonNull String nombres;
	private @NonNull Integer apellidos;
	private @NonNull Integer estado;
	@Lob()
	private Blob fotobase64;
}
