package pl.loysys.app.data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "items")
class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int time;

    public Item(){}

    @ManyToMany(mappedBy = "items")
    List<Functionality> functionalites = new ArrayList<>();

    public Item(String name, int time) {
        this.name = name;
        this.time = time;
    }

    String getName() {
        return name;
    }

    int getTime() {
        return time;
    }

    void setName(String name) {
        this.name = name;
    }

    void setTime(int time) {
        this.time = time;
    }

}
