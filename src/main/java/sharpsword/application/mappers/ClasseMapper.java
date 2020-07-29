package sharpsword.application.mappers;

import java.util.ArrayList;
import java.util.List;

import sharpsword.application.dto.response.ClasseDtoResponse;
import sharpsword.domain.Classe;

public class ClasseMapper {

	public static ClasseDtoResponse mapToDtoResponse(Classe classe) {
		ClasseDtoResponse response = new ClasseDtoResponse();

		response.setId(classe.getId());
		response.setNome(classe.getNome());

		return response;
	}

	public static List<ClasseDtoResponse> mapToListDtoResponse(List<Classe> classes) {

		List<ClasseDtoResponse> listaResponse = new ArrayList<>();

		for (Classe classe : classes) {
			ClasseDtoResponse response = mapToDtoResponse(classe);
			listaResponse.add(response);
		}

		return listaResponse;
	}

}
