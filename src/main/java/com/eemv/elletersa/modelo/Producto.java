package com.eemv.elletersa.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.beans.factory.annotation.Required;

@Entity
public class Producto {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@NotBlank
	private String nombre; 
	
	@PositiveOrZero
	private float precio;
	
	private String imagen; 
	
	private TIPO_PRODUCTO tipo;
	
	public Producto() { }

	public Producto(String nombre, float precio, String imagen, TIPO_PRODUCTO tipo) {
		this.nombre = nombre;
		this.precio = precio;
		this.imagen = imagen;
		this.tipo = tipo;
	}

	public TIPO_PRODUCTO getTipo() {
		return tipo;
	}

	public void setTipo(TIPO_PRODUCTO tipo) {
		this.tipo = tipo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((imagen == null) ? 0 : imagen.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + Float.floatToIntBits(precio);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (id != other.id)
			return false;
		if (imagen == null) {
			if (other.imagen != null)
				return false;
		} else if (!imagen.equals(other.imagen))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (Float.floatToIntBits(precio) != Float.floatToIntBits(other.precio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", imagen=" + imagen
				+ ", propietario=" + "]";
	}

	
	

}