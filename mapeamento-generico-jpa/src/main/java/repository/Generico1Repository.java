package repository;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import model.Generico1;

@RepositoryRestResource(collectionResourceRel = "Generico1", path = "Generico1")
public interface Generico1Repository extends PagingAndSortingRepository<Generico1, Integer>{
	
	//QUERIES PERSONALIZADAS//
	List<Generico1>findByString3(String string3);
	
	List<Generico1>findByString3AndString2(String string3, String string2);
	
}
