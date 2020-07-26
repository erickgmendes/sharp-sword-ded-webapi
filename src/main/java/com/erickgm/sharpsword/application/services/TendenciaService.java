package com.erickgm.sharpsword.application.services;

import com.erickgm.sharpsword.application.dto.request.TendenciaDtoRequest;
import com.erickgm.sharpsword.application.dto.response.TendenciaDtoResponse;
import com.erickgm.sharpsword.application.mappers.TendenciaMapper;
import com.erickgm.sharpsword.application.domain.entities.Tendencia;
import com.erickgm.sharpsword.application.repository.TendenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TendenciaService {

    @Autowired
    private TendenciaRepository tendenciaRepository;

    public List<Tendencia> listarTendencias() {
        return tendenciaRepository.findByOrderByNomeAsc();
    }

    public TendenciaDtoResponse obterTendenciaPeloId(long id) {
        Tendencia tendencia = tendenciaRepository.findById(id);
        return TendenciaMapper.mapToDtoResponse(tendencia);
    }

    public TendenciaDtoResponse incluirTendencia(TendenciaDtoRequest dto) {
        if (dto == null) {
            return null;
        }

        Tendencia tendencia = tendenciaRepository.findByNome(dto.getNome());
        if (tendencia != null)
            return TendenciaMapper.mapToDtoResponse(tendencia);

        tendencia = new Tendencia();
        tendencia.setNome(dto.getNome());
        tendencia = tendenciaRepository.save(tendencia);

        return TendenciaMapper.mapToDtoResponse(tendencia);
    }

    public TendenciaDtoResponse alterarTendencia(long id, TendenciaDtoRequest dto) {
        Tendencia tendencia = tendenciaRepository.findById(id);
        tendencia.setNome(dto.getNome());
        tendenciaRepository.save(tendencia);
        return TendenciaMapper.mapToDtoResponse(tendencia);
    }

    public boolean excluirTendencia(long id) {
        Tendencia tendencia = tendenciaRepository.findById(id);

        if (tendencia == null)
            return false;

        tendenciaRepository.delete(tendencia);

        return true;
    }

}
