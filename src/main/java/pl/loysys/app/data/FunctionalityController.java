package pl.loysys.app.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/functionalities")
public class FunctionalityController {

    @Autowired
    FunctionalityService functionalityService;
    @Autowired
    ItemService itemService;

    @GetMapping
    public List<Functionality> getAllFunctionalities() {
        return functionalityService.getAllFunctionalities();
    }

    @RequestMapping("/addItem")
    public void addItem(Functionality functionality, Item item) {
        functionality.addItem(item);
    }

    @GetMapping("/{functionalityId}")
    public Functionality getFunctionalityDetails(@PathVariable("functionalityId") Long functionalityId){
        return functionalityService.getFunctionalityDetails(functionalityId);
    }
    @PostMapping("/{functionalityId}")
    public ItemTO addItem(@PathVariable("functionalityId") @RequestBody ItemTO itemTO) {
        return itemService.addItem(itemTO);
    }
}
