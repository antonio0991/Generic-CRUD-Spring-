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

import model.Generico4;
import repository.Generico4Repository;

@RestController @RequestMapping("/api/v1")
public class Generico4Controller {

	@Autowired
	private Generico4Repository repository;
	
	@PostMapping("/generico4")
	public ResponseEntity<Generico4> novoGenerico4(@RequestBody Generico4 novaGenerico4) {
		if(repository.existsById(novaGenerico4.getId())) {
			Generico4 Generico4Criada = repository.save(novaGenerico4);
			return new ResponseEntity<Generico4>(Generico4Criada, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<Generico4>(novaGenerico4, HttpStatus.UNAUTHORIZED);
		}
	}
	
	@GetMapping("/generico4")
	public ResponseEntity<Generico4> consultarGenerico4(@RequestBody int id){
		
		Generico4 Generico4Obtida = repository.findById(id).orElse(null);
		
		if(Generico4Obtida != null) {
			return new ResponseEntity<Generico4>(Generico4Obtida, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Generico4>(Generico4Obtida, HttpStatus.NOT_FOUND); 
		}
	}
	
	@GetMapping("/generico4")
	public ResponseEntity<List<Generico4>> listarGenerico4s(){
	
		List<Generico4> entities = (List<Generico4>) repository.findAll();
		
		return new ResponseEntity<List<Generico4>>(entities, HttpStatus.OK);
	}
	
	@DeleteMapping("/generico4")
	public ResponseEntity<Generico4> deletarGenerico4PorId(int id){
		
		Generico4 Generico4Obtida = repository.findById(id).orElse(null);
		if(Generico4Obtida != null) {
			repository.deleteById(id);
			return new ResponseEntity<Generico4>(Generico4Obtida, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Generico4>(Generico4Obtida, HttpStatus.NO_CONTENT); 
		}	
	}
	
	@PutMapping("/generico4")
	public ResponseEntity<Generico4> atualizarGenerico4(Generico4 Generico4){
		if(repository.save(Generico4) != null) {
			return new ResponseEntity<Generico4>(Generico4, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Generico4>(Generico4, HttpStatus.NOT_FOUND);
		}
	}
}
