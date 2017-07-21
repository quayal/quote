package pl.loysys.app.data;

import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long>{
    Item findByName(String name);
}
