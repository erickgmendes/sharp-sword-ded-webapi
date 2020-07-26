package com.erickgm.sharpsword.application.repository;

import com.erickgm.sharpsword.application.domain.entities.Ficha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FichaRepository extends JpaRepository<Ficha, Long> {

	Ficha findById(long id);

	Ficha findByNome(String nome);
	
}