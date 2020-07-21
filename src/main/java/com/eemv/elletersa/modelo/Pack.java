package com.eemv.elletersa.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.annotations.Formula;

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
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Pack {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NonNull
	@NotBlank
	private String nombre;
	
	@Valid
	@NonNull
	@OneToMany (cascade = CascadeType.REMOVE)
	private List<Producto> productos;

	@Valid
	@NonNull
	@OneToMany(cascade = CascadeType.REMOVE)
	private List<Tratamiento> tratamientos;
	
	@NonNull
	@NotBlank
	private String descripcion;
	
	@NonNull
	@PositiveOrZero
	private Double precio;
	
	@NonNull
	private String imagen; 
	
//	@NonNull
//	@PositiveOrZero 
//	private Double precioOriginal;
}
