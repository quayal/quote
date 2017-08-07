package pl.loysys.app.data.item;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long>{
    Item findByName(String name);
    Item findById(Long id);
    List<Item> findByFunctionalityId(Long id);
}
