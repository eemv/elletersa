package com.eemv.elletersa.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.lang.Nullable;

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
//	@NotBlank
	private String nombre; 
	
	@NonNull
	private String imagen; 
	
	@NonNull
//	@NotBlank
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
	
	@NonNull
	@ElementCollection
	private List<Producto> productosRecomendados;
	
	@Nullable
	@OneToOne(optional = true,cascade = CascadeType.ALL)
	private Oferta oferta;
}