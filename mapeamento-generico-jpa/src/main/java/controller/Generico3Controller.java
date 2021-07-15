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

import model.Generico3;
import repository.Generico3Repository;

@RestController @RequestMapping("/api/v1")
public class Generico3Controller {

	@Autowired
	private Generico3Repository repository;
	
	@PostMapping("/generico3")
	public ResponseEntity<Generico3> novoGenerico3(@RequestBody Generico3 novaGenerico3) {
		if(repository.existsById(novaGenerico3.getId())) {
			Generico3 Generico3Criada = repository.save(novaGenerico3);
			return new ResponseEntity<Generico3>(Generico3Criada, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<Generico3>(novaGenerico3, HttpStatus.UNAUTHORIZED);
		}
	}
	
	@GetMapping("/generico3")
	public ResponseEntity<Generico3> consultarGenerico3(@RequestBody int id){
		
		Generico3 Generico3Obtida = repository.findById(id).orElse(null);
		
		if(Generico3Obtida != null) {
			return new ResponseEntity<Generico3>(Generico3Obtida, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Generico3>(Generico3Obtida, HttpStatus.NOT_FOUND); 
		}
	}
	
	@GetMapping("/generico3")
	public ResponseEntity<List<Generico3>> listarGenerico3s(){
	
		List<Generico3> entities = (List<Generico3>) repository.findAll();
		
		return new ResponseEntity<List<Generico3>>(entities, HttpStatus.OK);
	}
	
	@DeleteMapping("/generico3")
	public ResponseEntity<Generico3> deletarGenerico3PorId(int id){
		
		Generico3 Generico3Obtida = repository.findById(id).orElse(null);
		if(Generico3Obtida != null) {
			repository.deleteById(id);
			return new ResponseEntity<Generico3>(Generico3Obtida, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Generico3>(Generico3Obtida, HttpStatus.NO_CONTENT); 
		}	
	}
	
	@PutMapping("/generico3")
	public ResponseEntity<Generico3> atualizarGenerico3(Generico3 Generico3){
		if(repository.save(Generico3) != null) {
			return new ResponseEntity<Generico3>(Generico3, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Generico3>(Generico3, HttpStatus.NOT_FOUND);
		}
	}
}
