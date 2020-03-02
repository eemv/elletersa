package com.eemv.elletersa.repositorios;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eemv.elletersa.modelo.TIPO_TRATAMIENTO;
import com.eemv.elletersa.modelo.Tratamiento;

public interface TratamientoRepository  extends JpaRepository<Tratamiento, Long> {
	
	List<Tratamiento> findAllByNombreContainsIgnoreCase(Pageable pageable,String query);
	
	List<Tratamiento> findAllByTipo(Pageable pageable, TIPO_TRATAMIENTO tipo);
	
	List<Tratamiento> findAllByTipo(TIPO_TRATAMIENTO tipo);
	
	@Query("select count(e) from Tratamiento e ")
	Integer countTratamiento();

	List<Tratamiento> findAllByOrderByPrecioSesion(Pageable pageable);
}
