package pl.loysys.app.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FunctionalityService {

    public FunctionalityService() {
    }

    public FunctionalityService(Functionality functionality) {
    }

    @Autowired
    private FunctionalityRepository functionalityRepository;


    public Functionality addNew(String name) {
        return new Functionality(name);
    }

    public void addItem(Functionality functionality, Item item) {
        functionality.addItem(item);
    }

    public Functionality getFunctionalityDetails(Long id) {
        return functionalityRepository.findById(id);
    }

}

