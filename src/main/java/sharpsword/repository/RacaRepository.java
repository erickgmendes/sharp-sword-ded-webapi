package sharpsword.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import sharpsword.domain.Raca;

public interface RacaRepository extends JpaRepository<Raca, Long>, PagingAndSortingRepository<Raca, Long> {
	
	Raca findById(long id);
	
	Raca findByNome(String nome);
	
	List<Raca> findByOrderByNomeAsc();

}
