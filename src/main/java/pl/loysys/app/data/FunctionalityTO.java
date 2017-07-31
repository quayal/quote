package pl.loysys.app.data;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class FunctionalityTO {

    private Long id;
    private String name;
    private int time;
    private Set<Item> items;

    public FunctionalityTO() {
    }

    public FunctionalityTO(Long id, String name, int time, Set<Item> items) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.items = items;
    }

    public FunctionalityTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }


}
