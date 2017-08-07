package pl.loysys.app.data.item;

import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

   public ItemTO map(Item item){
        ItemTO itemTO = new ItemTO();
        itemTO.setId(item.getId());
        itemTO.setName(item.getName());
        itemTO.setGuiWorkload(item.getGuiWorkload());
        itemTO.setSsWorkload(item.getSsWorkload());
        itemTO.setFunctionalityId(item.getFunctionality().getId());
        return itemTO;
    }
}
