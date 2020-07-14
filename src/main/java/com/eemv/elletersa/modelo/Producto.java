package com.eemv.elletersa.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
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
public class Producto {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@NonNull
	private String nombre; 
	
	@PositiveOrZero
	@NonNull
	private Double precio;
	
	@NonNull
	private String imagen; 
	
	@NotBlank
	@NonNull
	private String descripcion; 
	
	@NotBlank
	@NonNull
	private String componentes; 
	
	@NonNull
	private TIPO_PIEL tipoPiel;
	
	@NonNull
	private TIPO_PRODUCTO tipo;
	
	@Nullable
	@OneToOne(optional = true,cascade = CascadeType.ALL)
	private Oferta oferta;
	
//	@ManyToMany
//	private List<Pack> packs;


}