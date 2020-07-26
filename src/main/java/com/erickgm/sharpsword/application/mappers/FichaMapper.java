package com.erickgm.sharpsword.application.mappers;

import java.util.ArrayList;
import java.util.List;

import com.erickgm.sharpsword.application.dto.request.FichaDtoRequest;
import com.erickgm.sharpsword.application.dto.response.FichaDtoResponse;
import com.erickgm.sharpsword.application.domain.entities.Ficha;

public class FichaMapper {

	public static FichaDtoResponse mapToDtoResponse(Ficha ficha) {
		if (ficha == null) {
			return null;
		}

		FichaDtoResponse response = new FichaDtoResponse();
		response.setNome(ficha.getNome());
		response.setClasse(ficha.getClasse().getNome());
		response.setNivel(ficha.getNivel());
		response.setRaca(ficha.getRaca().getNome());
		response.setForca(ficha.getForca());
		response.setDestreza(ficha.getDestreza());
		response.setConstituicao(ficha.getConstituicao());
		response.setInteligencia(ficha.getInteligencia());
		response.setSabedoria(ficha.getSabedoria());
		response.setCarisma(ficha.getCarisma());

		return response;
	}

	public static List<FichaDtoResponse> mapToListDtoResponse(List<Ficha> fichas) {

		List<FichaDtoResponse> listaResponse = new ArrayList<>();

		for (Ficha ficha : fichas) {
			FichaDtoResponse response = mapToDtoResponse(ficha);
			listaResponse.add(response);
		}

		return listaResponse;
	}

	public static Ficha mapToModel(FichaDtoRequest dto) {
		if (dto == null) {
			return null;
		}

		Ficha ficha = new Ficha();
		ficha.setNome(dto.getNome());
		ficha.setNivel(dto.getNivel());
		ficha.setForca(dto.getForca());
		ficha.setDestreza(dto.getDestreza());
		ficha.setConstituicao(dto.getConstituicao());
		ficha.setInteligencia(dto.getInteligencia());
		ficha.setSabedoria(dto.getSabedoria());
		ficha.setCarisma(dto.getCarisma());

		//ficha.setClasse(dto.getClasse());
		//ficha.setRaca(dto.getRaca());

		return ficha;
	}

}