package com.eemv.elletersa.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eemv.elletersa.modelo.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findFirstByEmail(String email);

}
