package pl.loysys.app.data;

import org.springframework.stereotype.Service;

@Service
public class FunctionalityService {

    public FunctionalityService(){}

    public FunctionalityService(Functionality functionality){

    }
    public Functionality addNew(String name){
        return new Functionality(name);
    }

    public void addItem(Functionality functionality, Item item){
        functionality.addQuotationItem(item);
    }
}
