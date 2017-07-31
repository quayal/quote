package pl.loysys.app.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/functionalities")
public class FunctionalityController {

    @Autowired
    FunctionalityService functionalityService;
    @Autowired
    ItemService itemService;

    @RequestMapping("/addNew")
    public void newFunctionality(String name) {
        functionalityService.addNew(name);
    }

    @RequestMapping("/newItem")
    public void newItem(String name, int time) {
        itemService.createNew(name, time);
    }

    @RequestMapping("/addItem")
    public void addItem(Functionality functionality, Item item) {
        functionality.addItem(item);
    }

    @GetMapping("/{functionalityId}")
    public Functionality getFunctionalityDetails(@PathVariable("functionalityId") Long functionalityId){
        return functionalityService.getFunctionalityDetails(functionalityId);
    }
}
