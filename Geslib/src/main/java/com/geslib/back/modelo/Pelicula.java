package com.geslib.back.modelo;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@DiscriminatorValue("pelicula")
public class Pelicula extends Material
{
	
	@Column(name="duracion")
	private int duracion;
	
	@Enumerated
	@Column(name="formato")
	private Formato formato;
	
	private static final long serialVersionUID = 1L;
}
