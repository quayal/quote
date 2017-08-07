package pl.loysys.app.data.client;

import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long>{
    Client findById(Long id);
}
