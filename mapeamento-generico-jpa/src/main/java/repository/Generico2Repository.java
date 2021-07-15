package repository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import model.Generico2;

@RepositoryRestResource(collectionResourceRel = "Generico2", path = "Generico2")
public interface Generico2Repository extends PagingAndSortingRepository<Generico2, Integer>{
	
}
