package pl.loysys.app.data;

import javax.persistence.*;

@Entity
@Table(name = "item")
class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String itemName;
    private int itemTime;
//    private Functionality quotationFunctionality;
    public Item(){}

    public Item(String name, int time) {
        this.itemName = name;
        this.itemTime = time;
    }

    String getItemName() {
        return itemName;
    }

    int getItemTime() {
        return itemTime;
    }

    void setItemName(String itemName) {
        this.itemName = itemName;
    }

    void setItemTime(int itemTime) {
        this.itemTime = itemTime;
    }

}
