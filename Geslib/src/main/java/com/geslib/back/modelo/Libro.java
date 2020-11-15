package com.geslib.back.modelo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@DiscriminatorValue("libro")
public class Libro extends Material 
{

	@NonNull
	@Column(name="isbn", length = 13)
	private String isbn;
	
	@NonNull
	@Column(name="editorial",length = 30)
	private String editorial;
	
	@Column(name="numero_paginas")
	private int numeroPaginas;
	
	private static final long serialVersionUID = 1L;
}
