package com.erickgm.sharpsword.application.services;

import java.util.List;

import com.erickgm.sharpsword.application.dto.request.FichaDtoRequest;
import com.erickgm.sharpsword.application.dto.response.FichaDtoResponse;
import com.erickgm.sharpsword.application.mappers.FichaMapper;
import com.erickgm.sharpsword.application.domain.entities.Ficha;
import com.erickgm.sharpsword.application.domain.entities.Tendencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erickgm.sharpsword.application.domain.entities.Classe;
import com.erickgm.sharpsword.application.domain.entities.Raca;
import com.erickgm.sharpsword.application.repository.ClasseRepository;
import com.erickgm.sharpsword.application.repository.FichaRepository;
import com.erickgm.sharpsword.application.repository.RacaRepository;
import com.erickgm.sharpsword.application.repository.TendenciaRepository;

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