package com.eemv.elletersa.repositorios;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eemv.elletersa.modelo.Producto;
import com.eemv.elletersa.modelo.TIPO_PRODUCTO;


public interface ProductoRepository extends JpaRepository<Producto, Long>{

//	List<Producto> findByPropietario(Usuario propietario);
	
//	List<Producto> findByCompraIsNull();
	
//	List<Producto> findByNombreContainsIgnoreCaseAndCompraIsNull(String nombre);
	
//	List<Producto> findByNombreContainsIgnoreCaseAndPropietario(String nombre, Usuario propietario);

	
	
	List<Producto> findAllByNombreContainsIgnoreCase(Pageable pageable,String query);
	
	List<Producto> findAllByTipo(Pageable pageable, TIPO_PRODUCTO tipo);
	
	List<Producto> findAllByTipo(TIPO_PRODUCTO tipo);
	
	@Query("select count(e) from Producto e ")
	Integer countProduct();

	List<Producto> findAllByOrderByPrecio(Pageable pageable);
}
