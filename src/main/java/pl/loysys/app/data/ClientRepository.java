package pl.loysys.app.data;

import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long>{
    Client findByName(String name);
}
