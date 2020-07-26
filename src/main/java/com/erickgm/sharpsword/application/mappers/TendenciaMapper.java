package com.erickgm.sharpsword.application.mappers;

import com.erickgm.sharpsword.application.dto.response.TendenciaDtoResponse;
import com.erickgm.sharpsword.application.domain.entities.Tendencia;

import java.util.ArrayList;
import java.util.List;

public class TendenciaMapper {
    public static TendenciaDtoResponse mapToDtoResponse(Tendencia tendencia) {
        TendenciaDtoResponse response = new TendenciaDtoResponse();

        response.setId(tendencia.getId());
        response.setNome(tendencia.getNome());

        return response;
    }

    public static List<TendenciaDtoResponse> mapToListDtoResponse(List<Tendencia> tendencias) {

        List<TendenciaDtoResponse> listaResponse = new ArrayList<>();

        for (Tendencia tendencia : tendencias) {
            TendenciaDtoResponse response = mapToDtoResponse(tendencia);
            listaResponse.add(response);
        }

        return listaResponse;
    }
}