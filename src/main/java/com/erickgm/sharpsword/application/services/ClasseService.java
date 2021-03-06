package com.erickgm.sharpsword.application.services;

import java.util.List;

import com.erickgm.sharpsword.application.dto.request.ClasseDtoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erickgm.sharpsword.application.dto.response.ClasseDtoResponse;
import com.erickgm.sharpsword.application.mappers.ClasseMapper;
import com.erickgm.sharpsword.application.domain.entities.Classe;
import com.erickgm.sharpsword.application.repository.ClasseRepository;

@Service
public class ClasseService {

	@Autowired
	private ClasseRepository classeRepository;

	public List<ClasseDtoResponse> listarClasses() {
		List<Classe> classes = classeRepository.findByOrderByNomeAsc();
		return ClasseMapper.mapToListDtoResponse(classes);
	}

	public ClasseDtoResponse obterClassePeloId(long id) {
		Classe classe = classeRepository.findById(id);
		return  ClasseMapper.mapToDtoResponse(classe);
	}

	public ClasseDtoResponse incluirClasse(ClasseDtoRequest dto) {
		if (dto == null)
			return null;

		Classe classe = classeRepository.findByNome(dto.getNome());
		if (classe != null)
			return ClasseMapper.mapToDtoResponse(classe);

		classe = new Classe();
		classe.setNome(dto.getNome());
		classe = classeRepository.save(classe);

		return ClasseMapper.mapToDtoResponse(classe);
	}

	public ClasseDtoResponse alterarClasse(long id, ClasseDtoRequest dto) {
		Classe classe = classeRepository.findById(id);
		classe.setNome(dto.getNome());
		classeRepository.save(classe);
		return ClasseMapper.mapToDtoResponse(classe);
	}

	public boolean excluirClasse(long id) {
		Classe classe = classeRepository.findById(id);

		if (classe == null)
			return false;

		classeRepository.delete(classe);

		return true;
	}

}