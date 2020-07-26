package com.erickgm.sharpsword.application.resources;

import com.erickgm.sharpsword.application.dto.request.TendenciaDtoRequest;
import com.erickgm.sharpsword.application.dto.response.TendenciaDtoResponse;
import com.erickgm.sharpsword.application.services.TendenciaService;
import com.erickgm.sharpsword.application.domain.entities.Tendencia;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Tendencia")
@CrossOrigin(origins = "*")
public class TendenciaResource {
    @Autowired
    private TendenciaService tendenciaService;

    @GetMapping("/tendencias")
    @ApiOperation(value = "Este método retorna uma lista de tendencias")
    public ResponseEntity<List<Tendencia>> listarTendencia() {
        List<Tendencia> response = tendenciaService.listarTendencias();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/tendencias/{id}")
    @ApiOperation(value = "Este método retorna uma tendencia pelo seu identificador")
    public ResponseEntity<TendenciaDtoResponse> obterTendenciaPeloId(@PathVariable(value = "id") long id) {
        TendenciaDtoResponse response = tendenciaService.obterTendenciaPeloId(id);

        if (response == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/tendencias")
    @ApiOperation(value = "Este método adiciona um tendencia")
    public ResponseEntity<TendenciaDtoResponse> incluirTendencia(@RequestBody TendenciaDtoRequest dto) {
        TendenciaDtoResponse response = tendenciaService.incluirTendencia(dto);

        if (response == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/tendencias/{id}")
    @ApiOperation(value = "Este método atualiza uma tendencia")
    public ResponseEntity<TendenciaDtoResponse> alterarTendencia(@PathVariable(value = "id") long id, @RequestBody TendenciaDtoRequest dto) {
        TendenciaDtoResponse response = tendenciaService.alterarTendencia(id, dto);

        if (response == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/tendencias/{id}")
    @ApiOperation(value = "Este método exclui uma tendencia")
    public ResponseEntity<Boolean> excluirTendencia(@PathVariable(value = "id") long id) {
        if(!tendenciaService.excluirTendencia(id))
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}