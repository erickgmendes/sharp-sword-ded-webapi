package sharpsword.application.mappers;

import sharpsword.application.dto.response.TendenciaDtoResponse;
import sharpsword.domain.Tendencia;

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