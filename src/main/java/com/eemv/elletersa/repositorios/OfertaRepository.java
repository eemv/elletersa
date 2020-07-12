package com.eemv.elletersa.repositorios;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eemv.elletersa.modelo.Oferta;

public interface OfertaRepository extends JpaRepository<Oferta, Long>{

	List<Oferta> findAllByNombreContainsIgnoreCase(Pageable pageable,String query);
	
	@Query("select count(o) from Oferta o ")
	Integer countOferta();

	List<Oferta> findAllByOrderByNuevoPrecio(Pageable pageable);
}
