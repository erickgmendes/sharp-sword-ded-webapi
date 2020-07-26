package com.erickgm.sharpsword.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erickgm.sharpsword.application.domain.entities.Classe;

public interface ClasseRepository extends JpaRepository<Classe, Long> {

	Classe findByNome(String nome);

	Classe findById(long id);
	
	//List<Classe> findAllOrderByNomeAsc();
	
	List<Classe> findByOrderByNomeAsc();

}
