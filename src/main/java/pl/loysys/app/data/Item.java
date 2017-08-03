package pl.loysys.app.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int workload;

    public Item() {
    }

    @ManyToMany(mappedBy = "items")
    List<Functionality> functionalites = new ArrayList<>();

    public Item(String name, int time) {
        this.name = name;
        this.workload = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }

    public void addFunctionalityToList(Functionality functionality){
        functionalites.add(functionality);
    }

    @JsonIgnore
    public List<Functionality> getFunctionalites() {
        return functionalites;
    }

    public void setFunctionalites(List<Functionality> functionalities) {
        this.functionalites = functionalities;
    }
}
