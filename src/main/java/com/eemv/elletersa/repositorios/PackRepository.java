package com.eemv.elletersa.repositorios;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eemv.elletersa.modelo.Pack;

public interface PackRepository extends JpaRepository<Pack, Long>{


	List<Pack> findAllByNombreContainsIgnoreCase(Pageable pageable,String query);
	
	@Query("select count(p) from Pack p ")
	Integer countPack();

	List<Pack> findAllByOrderByPrecio(Pageable pageable);
}
