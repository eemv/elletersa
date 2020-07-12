package com.eemv.elletersa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.eemv.elletersa.modelo.Oferta;
import com.eemv.elletersa.repositorios.OfertaRepository;

@Service
public class OfertaServicio {
	
	@Autowired
	OfertaRepository repositorio;
	
	public Oferta insertar(Oferta p) {
		return repositorio.save(p);
	}
	
	
	public void insertarVarios(List<Oferta> p) {
		for(Oferta pa:p){
			insertar(pa);
		}
	}
	
	public void borrar(long id) {
		repositorio.deleteById(id);
	}
	
	public void borrar(Oferta p) {
		repositorio.delete(p);
	}
	
	public Oferta editar(Oferta p) {
		return repositorio.save(p);
	}
	
	public Oferta findById(long id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public List<Oferta> findAll() {
		return repositorio.findAll();
	}
	
	public List<Oferta> OfertasSinVender() {
		return repositorio.findAll();
	}
	
	public List<Oferta> buscar(String query, Pageable pageable) {
		return repositorio.findAllByNombreContainsIgnoreCase(pageable, query);
	}
	
	public List<Oferta> variosPorId(List<Long> ids) {
		return repositorio.findAllById(ids);
	}
	
	public List<Oferta> findAllByPage(Pageable pageable) {
		return repositorio.findAllByOrderByNuevoPrecio(pageable);
	}
}
