package sharpsword.resources;

import java.util.List;

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

import sharpsword.application.dto.request.FichaDtoRequest;
import sharpsword.application.dto.response.FichaDtoResponse;
import sharpsword.application.services.FichaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Ficha")
@CrossOrigin(origins = "*")
public class FichaResource {

	@Autowired
	private FichaService fichaService;

	@GetMapping("/fichas")
	@ApiOperation(value = "Este método retorna uma lista de fichas")
	public ResponseEntity<List<FichaDtoResponse>> listarFichas() {
		List<FichaDtoResponse> response = fichaService.listarFichas();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/fichas/{id}")
	@ApiOperation(value = "Este método retorna uma ficha pelo seu identificador")
	public ResponseEntity<FichaDtoResponse> obterFichaPeloId(@PathVariable(value = "id") long id) {
		FichaDtoResponse response = fichaService.obterFichaPeloId(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}	
	
	@PostMapping("/fichas")
	@ApiOperation(value = "Este método adiciona uma ficha")
	public ResponseEntity<FichaDtoResponse> incluirFicha(@RequestBody FichaDtoRequest dto) {
		FichaDtoResponse response = fichaService.incluirFicha(dto);

		if (response == null)
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping("/fichas/{id}")
	@ApiOperation(value = "Este método atualiza uma ficha")
	public ResponseEntity<FichaDtoResponse> alterarFicha(@PathVariable(value = "id") long id, @RequestBody FichaDtoRequest dto) {
		FichaDtoResponse response = fichaService.alterarFicha(id, dto);

		if (response == null)
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}	

	@DeleteMapping("/fichas/{id}")
	@ApiOperation(value = "Este método exclui uma ficha")
	public ResponseEntity<Boolean> excluirFicha(@PathVariable(value = "id") long id) {
		if(!fichaService.excluirFicha(id))
			return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);

		return new ResponseEntity<>(true, HttpStatus.OK);
	}

}