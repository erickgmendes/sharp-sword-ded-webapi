package sharpsword.repository;

import sharpsword.domain.Tendencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TendenciaRepository extends JpaRepository<Tendencia, Long>, PagingAndSortingRepository<Tendencia, Long> {

    Tendencia findById(long id);

    Tendencia findByNome(String nome);

    List<Tendencia> findByOrderByNomeAsc();

}
