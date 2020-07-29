package sharpsword.repository;

import sharpsword.domain.Ficha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FichaRepository extends JpaRepository<Ficha, Long> {

	Ficha findById(long id);

	Ficha findByNome(String nome);
	
}