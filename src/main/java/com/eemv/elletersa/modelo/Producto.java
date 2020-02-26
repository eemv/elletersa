package com.eemv.elletersa.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.beans.factory.annotation.Required;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Producto {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@NotBlank
	private String nombre; 
	
	@PositiveOrZero
	private float precio;
	
	private String imagen; 
	
	@NotNull
	@NotBlank
	private String descripcion; 
	
	@NotNull
	@NotBlank
	private String componentes; 
	
	private TIPO_PIEL tipoPiel;
	
	private TIPO_PRODUCTO tipo;
	


}