package pl.loysys.app.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuotationController {

    @Autowired
    FunctionalityService functionalityService;
    @Autowired
    ItemService itemService;

    @RequestMapping("/newFunctionality")
    public void newFunctionality(String name) {
        functionalityService.addNew(name);
    }

    @RequestMapping("/newItem")
    public void newItem(String name, int time) {
        itemService.addNew(name, time);
    }

    @RequestMapping("/addItem")
    public void addItem(Functionality functionality, Item item) {
        functionality.addQuotationItem(item);
    }





}
