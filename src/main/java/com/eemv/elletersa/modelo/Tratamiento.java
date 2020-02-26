package com.eemv.elletersa.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Tratamiento {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NonNull
	@NotBlank
	private String nombre; 
	
	@NonNull
	private String imagen; 
	
	@NonNull
	@NotBlank
	private String descripcion; 
	
	@Positive
	@NonNull
	private Integer numSesiones;
	
	@PositiveOrZero
	@NonNull
	private Double precioSesion;
	
	@NonNull
	private Integer minutosSesion;
	
	@NonNull
	private TIPO_TRATAMIENTO tipo;
	
	private List<Producto> productosRecomendados;
}
