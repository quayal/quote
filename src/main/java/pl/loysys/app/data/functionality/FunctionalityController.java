package pl.loysys.app.data.functionality;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.loysys.app.data.item.Item;
import pl.loysys.app.data.item.ItemService;
import pl.loysys.app.data.item.ItemTO;

import java.util.List;

@RestController
@RequestMapping("/functionalities")
public class FunctionalityController {

    private final FunctionalityService functionalityService;
    private final ItemService itemService;

    @Autowired
    public FunctionalityController(FunctionalityService functionalityService, ItemService itemService) {
        this.functionalityService = functionalityService;
        this.itemService = itemService;
    }

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
