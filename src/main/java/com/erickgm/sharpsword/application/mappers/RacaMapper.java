package com.erickgm.sharpsword.application.mappers;

import java.util.ArrayList;
import java.util.List;

import com.erickgm.sharpsword.application.dto.response.RacaDtoResponse;
import com.erickgm.sharpsword.application.domain.entities.Raca;

public class RacaMapper {

	public static RacaDtoResponse mapToDtoResponse(Raca raca) {
		RacaDtoResponse response = new RacaDtoResponse();

		response.setId(raca.getId());
		response.setNome(raca.getNome());

		return response;
	}

	public static List<RacaDtoResponse> mapToListDtoResponse(List<Raca> racas) {

		List<RacaDtoResponse> listaResponse = new ArrayList<>();

		for (Raca raca : racas) {
			RacaDtoResponse response = mapToDtoResponse(raca);
			listaResponse.add(response);
		}

		return listaResponse;
	}

}
