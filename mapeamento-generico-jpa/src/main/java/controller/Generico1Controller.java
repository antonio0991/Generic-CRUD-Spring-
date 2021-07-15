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

import model.Generico1;
import repository.Generico1Repository;

@RestController @RequestMapping("/api/v1")
public class Generico1Controller {

	@Autowired
	private Generico1Repository repository;
	
	@PostMapping("/generico1")
	public ResponseEntity<Generico1> novoGenerico1(@RequestBody Generico1 novaGenerico1) {
		if(repository.existsById(novaGenerico1.getId())) {
			Generico1 Generico1Criada = repository.save(novaGenerico1);
			return new ResponseEntity<Generico1>(Generico1Criada, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<Generico1>(novaGenerico1, HttpStatus.UNAUTHORIZED);
		}
	}
	
	@GetMapping("/generico1")
	public ResponseEntity<Generico1> consultarGenerico1(@RequestBody int id){
		
		Generico1 Generico1Obtida = repository.findById(id).orElse(null);
		
		if(Generico1Obtida != null) {
			return new ResponseEntity<Generico1>(Generico1Obtida, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Generico1>(Generico1Obtida, HttpStatus.NOT_FOUND); 
		}
	}
	
	@GetMapping("/generico1")
	public ResponseEntity<List<Generico1>> listarGenerico1s(){
	
		List<Generico1> entities = (List<Generico1>) repository.findAll();
		
		return new ResponseEntity<List<Generico1>>(entities, HttpStatus.OK);
	}
	
	@DeleteMapping("/generico1")
	public ResponseEntity<Generico1> deletarGenerico1PorId(int id){
		
		Generico1 Generico1Obtida = repository.findById(id).orElse(null);
		if(Generico1Obtida != null) {
			repository.deleteById(id);
			return new ResponseEntity<Generico1>(Generico1Obtida, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Generico1>(Generico1Obtida, HttpStatus.NO_CONTENT); 
		}	
	}
	
	@PutMapping("/generico1")
	public ResponseEntity<Generico1> atualizarGenerico1(Generico1 Generico1){
		if(repository.save(Generico1) != null) {
			return new ResponseEntity<Generico1>(Generico1, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Generico1>(Generico1, HttpStatus.NOT_FOUND);
		}
	}
}
