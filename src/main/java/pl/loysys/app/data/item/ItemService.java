package pl.loysys.app.data.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.loysys.app.data.functionality.FunctionalityRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Service
public class ItemService {

    @Autowired
    public ItemService(ItemRepository itemRepository, FunctionalityRepository functionalityRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.functionalityRepository = functionalityRepository;
        this.itemMapper = itemMapper;
    }

    private final ItemRepository itemRepository;
    private final FunctionalityRepository functionalityRepository;
    private final ItemMapper itemMapper;

    public ItemTO addItem(ItemTO itemTO) {
        Item toSave = itemRepository.findById(itemTO.getId());
        toSave.setFunctionality(functionalityRepository.findById(itemTO.getFunctionalityId()));
        itemRepository.save(toSave);
        return itemTO;
    }

    public ItemTO readItem(Item item) {
        return itemMapper.map(item);
    }

    public List<ItemTO> readAllItems() {
        return StreamSupport.stream(itemRepository.findAll().spliterator(), true)
                .map(itemMapper::map)
                .collect(toList());
    }

    public List<ItemTO> readFunctionalityItems(Long functionalityId) {
        return StreamSupport.stream(itemRepository.findByFunctionalityId(functionalityId).spliterator(), true)
                .map(itemMapper::map)
                .collect(toList());
    }

    public List<Item> getAllItems() {
        List<Item> itemList = new ArrayList<>();
        itemRepository.findAll().forEach(itemList::add);
        return itemList;
    }


}
