package pl.loysys.app.data;

import javax.persistence.*;

@Entity
@Table(name = "item")
class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;
    private int itemTime;
    public Item(){}

    public Item(String name, int time) {
        this.name = name;
        this.itemTime = time;
    }

    String getName() {
        return name;
    }

    int getItemTime() {
        return itemTime;
    }

    void setName(String name) {
        this.name = name;
    }

    void setItemTime(int itemTime) {
        this.itemTime = itemTime;
    }

}
