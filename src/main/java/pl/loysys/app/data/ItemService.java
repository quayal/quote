package pl.loysys.app.data;

import org.springframework.stereotype.Service;

@Service
public class ItemService {

    public ItemService(){
    }

    public ItemService(String name, int time) {
    }

    public Item addNew(String name, int time) {
        return new Item(name, time);
    }



}
