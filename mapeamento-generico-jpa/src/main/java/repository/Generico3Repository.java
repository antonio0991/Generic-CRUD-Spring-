package repository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import model.Generico3;

@RepositoryRestResource(collectionResourceRel = "Generico3", path = "Generico3")
public interface Generico3Repository extends PagingAndSortingRepository<Generico3, Integer>{
	
}
