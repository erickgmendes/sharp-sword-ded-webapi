package sharpsword.application.services;

import java.util.List;

import sharpsword.application.dto.request.RacaDtoRequest;
import sharpsword.application.mappers.RacaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sharpsword.application.dto.response.RacaDtoResponse;
import sharpsword.domain.Raca;
import sharpsword.repository.RacaRepository;

@Service
public class RacaService {

    @Autowired
    private RacaRepository racaRepository;

    public List<Raca> listarRacas() {
        return racaRepository.findByOrderByNomeAsc();
    }

    public RacaDtoResponse obterRacaPeloId(long id) {
        Raca raca = racaRepository.findById(id);
        return RacaMapper.mapToDtoResponse(raca);
    }

    public RacaDtoResponse incluirRaca(RacaDtoRequest dto) {
        if (dto == null)
            return null;

        Raca raca = racaRepository.findByNome(dto.getNome());
        if (raca != null)
            return RacaMapper.mapToDtoResponse(raca);

        raca = new Raca();
        raca.setNome(dto.getNome());
        raca = racaRepository.save(raca);

        return RacaMapper.mapToDtoResponse(raca);
    }

    public RacaDtoResponse alterarRaca(long id, RacaDtoRequest dto) {
        Raca raca = racaRepository.findById(id);
        raca.setNome(dto.getNome());
        racaRepository.save(raca);
        return RacaMapper.mapToDtoResponse(raca);
    }

    public boolean excluirRaca(long id) {
        Raca raca = racaRepository.findById(id);

        if (raca == null)
            return false;

        racaRepository.delete(raca);

        return true;
    }

}