package com.ms.practica2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.nio.ByteBuffer;
import java.sql.Blob;

import javax.persistence.Lob;

@AllArgsConstructor
@Getter
@Setter
@Table("Persona")
public class Persona {

	@PrimaryKey
	private @NonNull String dni;
	private @NonNull String nombres;
	private @NonNull String apellidos;
	private @NonNull Integer estado;

	private ByteBuffer fotobase64;
}
