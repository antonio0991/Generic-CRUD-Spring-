package repository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import model.Generico4;

@RepositoryRestResource(collectionResourceRel = "Generico4", path = "Generico4")
public interface Generico4Repository extends PagingAndSortingRepository<Generico4, Integer>{
	
}
