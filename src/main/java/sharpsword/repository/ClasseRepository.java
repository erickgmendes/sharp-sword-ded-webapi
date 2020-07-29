package sharpsword.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sharpsword.domain.Classe;

public interface ClasseRepository extends JpaRepository<Classe, Long> {

	Classe findByNome(String nome);

	Classe findById(long id);
	
	//List<Classe> findAllOrderByNomeAsc();
	
	List<Classe> findByOrderByNomeAsc();

}
