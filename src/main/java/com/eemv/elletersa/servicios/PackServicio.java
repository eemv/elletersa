package com.eemv.elletersa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.eemv.elletersa.modelo.Pack;
import com.eemv.elletersa.modelo.Producto;
import com.eemv.elletersa.modelo.Tratamiento;
import com.eemv.elletersa.repositorios.PackRepository;

@Service
public class PackServicio {

	@Autowired
	PackRepository repositorio;
	
	public Pack insertar(Pack p) {
//		int res = 0;
//		for(Producto pr : p.getProductos()){
//			res += pr.getPrecio();
//		}
//		for(Tratamiento t : p.getTratamientos()){
//			res += t.;
//		}
//		p.setPrecioOriginal();
		return repositorio.save(p);
	}
	
	
	public void insertarVarios(List<Pack> p) {
		for(Pack pa:p){
			insertar(pa);
		}
	}
	
	public void borrar(long id) {
		repositorio.deleteById(id);
	}
	
	public void borrar(Pack p) {
		repositorio.delete(p);
	}
	
	public Pack editar(Pack p) {
		return repositorio.save(p);
	}
	
	public Pack findById(long id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public List<Pack> findAll() {
		return repositorio.findAll();
	}
	
//	public List<Pack> PacksDeUnPropietario(Usuario u) {
//		return repositorio.findByPropietario(u);
//	}
	
//	public List<Pack> PacksDeUnaCompra(Compra c) {
//		return repositorio.findByCompra(c);
//	}
//	
	public List<Pack> PacksSinVender() {
		return repositorio.findAll();
	}
	
	public List<Pack> buscar(String query, Pageable pageable) {
		return repositorio.findAllByNombreContainsIgnoreCase(pageable, query);
	}
	
//	public List<Pack> buscarMisPacks(String query, Usuario u) {
//		return repositorio.findByNombreContainsIgnoreCaseAndPropietario(query,u);
//	}
	
	public List<Pack> variosPorId(List<Long> ids) {
		return repositorio.findAllById(ids);
	}
	
	public List<Pack> findAllByPage(Pageable pageable) {
		return repositorio.findAllByOrderByPrecio(pageable);
	}

}

