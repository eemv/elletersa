package com.eemv.elletersa.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.ManyToAny;

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
//@Check(constraints = "tratamiento IS NOT NULL AND producto IS NULL OR" + "tratamiento IS NULL AND producto IS NOT NULL")
public class Oferta {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Valid
	@ManyToOne(cascade = CascadeType.ALL) 
	private Producto producto;

	@Valid
	@ManyToOne(cascade = CascadeType.ALL) 
	private Tratamiento tratamiento;
	
	@NonNull
	@NotBlank
	private String descripcion;
	
	@NonNull
	@PositiveOrZero
	private Double nuevoPrecio;
}
