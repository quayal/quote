package pl.loysys.app.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    public ItemService(){
    }

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private FunctionalityRepository functionalityRepository;

    public ItemTO addItem(ItemTO itemTO) {
        Item toSave = itemRepository.findById(itemTO.getId());
        toSave.addFunctionalityToList(functionalityRepository.findById(itemTO.getFunctionalityId()));
        itemRepository.save(toSave);
        return itemTO;
    }

    public List<Item> getAllItems() {
        List<Item> itemList = new ArrayList<>();
        itemRepository.findAll().forEach(itemList::add);
        return itemList;
    }



}
