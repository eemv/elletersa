package com.eemv.elletersa.servicios;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.eemv.elletersa.modelo.Producto;
import com.eemv.elletersa.modelo.TIPO_PRODUCTO;
import com.eemv.elletersa.modelo.Usuario;
import com.eemv.elletersa.repositorios.ProductoRepository;

@Service
public class ProductoServicio {
	
	@Autowired
	ProductoRepository repositorio;
	
//	@Autowired
//	StorageService storageService;
//	
	
	public Producto insertar(Producto p) {
		return repositorio.save(p);
	}
	
	public void borrar(long id) {
		repositorio.deleteById(id);
	}
	
	public void borrar(Producto p) {
		repositorio.delete(p);
	}
	
	public Producto editar(Producto p) {
		return repositorio.save(p);
	}
	
	public Producto findById(long id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public List<Producto> findAll() {
		return repositorio.findAll();
	}
	
//	public List<Producto> productosDeUnPropietario(Usuario u) {
//		return repositorio.findByPropietario(u);
//	}
	
//	public List<Producto> productosDeUnaCompra(Compra c) {
//		return repositorio.findByCompra(c);
//	}
//	
	public List<Producto> productosSinVender() {
		return repositorio.findAll();
	}
	
	public List<Producto> buscar(String query, Pageable pageable) {
		return repositorio.findAllByNombreContainsIgnoreCase(pageable, query);
	}
	
//	public List<Producto> buscarMisProductos(String query, Usuario u) {
//		return repositorio.findByNombreContainsIgnoreCaseAndPropietario(query,u);
//	}
	
	public List<Producto> variosPorId(List<Long> ids) {
		return repositorio.findAllById(ids);
	}
	
	public List<Producto> findAllByPage(Pageable pageable) {
		return repositorio.findAllByOrderByPrecio(pageable);
	}

	public List<Producto> findAllByTipo(TIPO_PRODUCTO tipo) {
		return repositorio.findAllByTipo(tipo);
	}

	public List<Producto> findAllByTipo(TIPO_PRODUCTO tipo, Pageable pageable) {
		return repositorio.findAllByTipo(pageable,tipo);
	}
}
