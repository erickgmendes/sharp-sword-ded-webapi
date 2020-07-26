package com.erickgm.sharpsword.application.resources;

import java.util.List;

import com.erickgm.sharpsword.application.domain.entities.Raca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erickgm.sharpsword.application.dto.request.RacaDtoRequest;
import com.erickgm.sharpsword.application.dto.response.RacaDtoResponse;
import com.erickgm.sharpsword.application.services.RacaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Raça")
@CrossOrigin(origins = "*")
public class RacaResource {

	@Autowired
	private RacaService racaService;

	@GetMapping("/racas")
	@ApiOperation(value = "Este método retorna uma lista de raças")
	public ResponseEntity<List<Raca>> listarRaca() {
		List<Raca> response = racaService.listarRacas();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/racas/{id}")
	@ApiOperation(value = "Este método retorna uma raça pelo seu identificador")
	public ResponseEntity<RacaDtoResponse> obterRacaPeloId(@PathVariable(value = "id") long id) {
		RacaDtoResponse response = racaService.obterRacaPeloId(id);

		if (response == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/racas")
	@ApiOperation(value = "Este método adiciona um raça")
	public ResponseEntity<RacaDtoResponse> incluirRaca(@RequestBody RacaDtoRequest dto) {
		RacaDtoResponse response = racaService.incluirRaca(dto);

		if (response == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PutMapping("/racas/{id}")
	@ApiOperation(value = "Este método atualiza uma raça")
	public ResponseEntity<RacaDtoResponse> alterarRaca(@PathVariable(value = "id") long id, @RequestBody RacaDtoRequest dto) {
		RacaDtoResponse response = racaService.alterarRaca(id, dto);

		if (response == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(response, HttpStatus.OK);
	}	

	@DeleteMapping("/racas/{id}")
	@ApiOperation(value = "Este método exclui uma raça")
	public ResponseEntity<Boolean> excluirRaca(@PathVariable(value = "id") long id) {
		if(!racaService.excluirRaca(id)) {
			return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
}