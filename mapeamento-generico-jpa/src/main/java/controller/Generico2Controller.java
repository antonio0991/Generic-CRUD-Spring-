package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Generico2;
import repository.Generico2Repository;

@RestController @RequestMapping("/api/v1")
public class Generico2Controller {

	@Autowired
	private Generico2Repository repository;
	
	@PostMapping("/generico2")
	public ResponseEntity<Generico2> novoGenerico2(@RequestBody Generico2 novaGenerico2) {
		if(repository.existsById(novaGenerico2.getId())) {
			Generico2 Generico2Criada = repository.save(novaGenerico2);
			return new ResponseEntity<Generico2>(Generico2Criada, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<Generico2>(novaGenerico2, HttpStatus.UNAUTHORIZED);
		}
	}
	
	@GetMapping("/generico2")
	public ResponseEntity<Generico2> consultarGenerico2(@RequestBody int id){
		
		Generico2 Generico2Obtida = repository.findById(id).orElse(null);
		
		if(Generico2Obtida != null) {
			return new ResponseEntity<Generico2>(Generico2Obtida, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Generico2>(Generico2Obtida, HttpStatus.NOT_FOUND); 
		}
	}
	
	@GetMapping("/generico2")
	public ResponseEntity<List<Generico2>> listarGenerico2s(){
	
		List<Generico2> entities = (List<Generico2>) repository.findAll();
		
		return new ResponseEntity<List<Generico2>>(entities, HttpStatus.OK);
	}
	
	@DeleteMapping("/generico2")
	public ResponseEntity<Generico2> deletarGenerico2PorId(int id){
		
		Generico2 Generico2Obtida = repository.findById(id).orElse(null);
		if(Generico2Obtida != null) {
			repository.deleteById(id);
			return new ResponseEntity<Generico2>(Generico2Obtida, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Generico2>(Generico2Obtida, HttpStatus.NO_CONTENT); 
		}	
	}
	
	@PutMapping("/generico2")
	public ResponseEntity<Generico2> atualizarGenerico2(Generico2 Generico2){
		if(repository.save(Generico2) != null) {
			return new ResponseEntity<Generico2>(Generico2, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Generico2>(Generico2, HttpStatus.NOT_FOUND);
		}
	}
}
