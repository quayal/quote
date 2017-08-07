package pl.loysys.app.data.functionality;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.loysys.app.data.item.ItemMapper;
import pl.loysys.app.data.item.ItemService;

import java.util.stream.Collectors;

@Component
public class FunctionalityMapper {
    private final ItemMapper itemMapper;

    @Autowired
    public FunctionalityMapper(ItemMapper itemMapper){
        this.itemMapper = itemMapper;
    }

    public FunctionalityTO map(Functionality functionality){
        FunctionalityTO functionalityTO = new FunctionalityTO();
        functionalityTO.setId(functionality.getId());
        functionalityTO.setName(functionality.getName());
        functionalityTO.setGuiWorkload(functionality.getGuiWorkload());
        functionalityTO.setSsWorkload(functionality.getSsWorkload());
        functionalityTO.setItems(functionality.getItems().stream()
                .map(itemMapper::map).collect(Collectors.toList()));
        return functionalityTO;
    }
}
