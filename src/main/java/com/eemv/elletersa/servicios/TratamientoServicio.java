package com.eemv.elletersa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.eemv.elletersa.modelo.TIPO_TRATAMIENTO;
import com.eemv.elletersa.modelo.Tratamiento;
import com.eemv.elletersa.repositorios.TratamientoRepository;

@Service
public class TratamientoServicio{
	
	@Autowired
	TratamientoRepository repositorio;
	
	
	public Tratamiento insertar(Tratamiento p) {
		return repositorio.save(p);
	}
	
	public void borrar(long id) {
		repositorio.deleteById(id);
	}
	
	public void borrar(Tratamiento p) {
		repositorio.delete(p);
	}
	
	public Tratamiento editar(Tratamiento p) {
		return repositorio.save(p);
	}
	
	public Tratamiento findById(long id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public List<Tratamiento> findAll() {
		return repositorio.findAll();
	}
	
//	public List<Producto> productosDeUnPropietario(Usuario u) {
//		return repositorio.findByPropietario(u);
//	}
	
//	public List<Producto> productosDeUnaCompra(Compra c) {
//		return repositorio.findByCompra(c);
//	}
//	
	public List<Tratamiento> productosSinVender() {
		return repositorio.findAll();
	}
	
	public List<Tratamiento> buscar(String query, Pageable pageable) {
		return repositorio.findAllByNombreContainsIgnoreCase(pageable, query);
	}
	
//	public List<Producto> buscarMisProductos(String query, Usuario u) {
//		return repositorio.findByNombreContainsIgnoreCaseAndPropietario(query,u);
//	}
	
	public List<Tratamiento> variosPorId(List<Long> ids) {
		return repositorio.findAllById(ids);
	}
	
	public List<Tratamiento> findAllByPage(Pageable pageable) {
		return repositorio.findAllByOrderByPrecioSesion(pageable);
	}

	public List<Tratamiento> findAllByTipo(TIPO_TRATAMIENTO tipo) {
		return repositorio.findAllByTipo(tipo);
	}

	public List<Tratamiento> findAllByTipo(TIPO_TRATAMIENTO tipo, Pageable pageable) {
		return repositorio.findAllByTipo(pageable,tipo);
	}
	
}

