package sharpsword.application.services;

import java.util.List;

import sharpsword.application.dto.request.FichaDtoRequest;
import sharpsword.application.dto.response.FichaDtoResponse;
import sharpsword.application.mappers.FichaMapper;
import sharpsword.domain.Ficha;
import sharpsword.domain.Tendencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sharpsword.domain.Classe;
import sharpsword.domain.Raca;
import sharpsword.repository.ClasseRepository;
import sharpsword.repository.FichaRepository;
import sharpsword.repository.RacaRepository;
import sharpsword.repository.TendenciaRepository;

@Service
public class FichaService {

	@Autowired
	private FichaRepository fichaRepository;

	@Autowired
	private RacaRepository racaRepository;
	
	@Autowired
	private ClasseRepository classeRepository;

	@Autowired
	private TendenciaRepository tendenciaRepository;

	public List<FichaDtoResponse> listarFichas() {
		List<Ficha> ficha = fichaRepository.findAll();
		return FichaMapper.mapToListDtoResponse(ficha);
	}

	public FichaDtoResponse obterFichaPeloId(long id) {
		Ficha ficha =  fichaRepository.findById(id);
		return FichaMapper.mapToDtoResponse(ficha);
	}

	public FichaDtoResponse incluirFicha(FichaDtoRequest dto) {
		if (dto == null || fichaRepository.findByNome(dto.getNome()) != null) {
			return null;
		}

		Ficha ficha = FichaMapper.mapToModel(dto);
		Raca raca = racaRepository.findByNome(dto.getRaca());
		Classe classe = classeRepository.findByNome(dto.getClasse());
		Tendencia tendencia = tendenciaRepository.findByNome(dto.getTendencia());

		ficha.setNome(dto.getNome());
		ficha.setClasse(classe);
		ficha.setNivel(dto.getNivel());
		ficha.setRaca(raca);
		ficha.setTendencia(tendencia);

		ficha = fichaRepository.save(ficha);
				
		return FichaMapper.mapToDtoResponse(ficha);
	}

	public FichaDtoResponse alterarFicha(long id, FichaDtoRequest dto) {
		Ficha ficha = fichaRepository.findById(id);
		Raca raca = racaRepository.findByNome(dto.getRaca());
		Classe classe = classeRepository.findByNome(dto.getClasse());
		Tendencia tendencia = tendenciaRepository.findByNome(dto.getTendencia());

		ficha.setNome(dto.getNome());
		ficha.setClasse(classe);
		ficha.setNivel(dto.getNivel());
		ficha.setRaca(raca);
		ficha.setTendencia(tendencia);

		ficha =  fichaRepository.save(ficha);
		
		return FichaMapper.mapToDtoResponse(ficha);
	}

	public boolean excluirFicha(long id) {
		Ficha ficha = fichaRepository.findById(id);
		if (ficha == null) {
			return false;
		}
		fichaRepository.delete(ficha);
		return true;
	}

}