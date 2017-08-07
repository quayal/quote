package pl.loysys.app.data.functionality;

import org.springframework.data.repository.CrudRepository;

public interface FunctionalityRepository extends CrudRepository<Functionality, Long>{

    Functionality findByName(String functionalityName);
    Functionality findById(Long id);
}
