package pl.loysys.app.data;

import javax.persistence.Column;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "quotation")
public class Quotation {

    public Quotation() {
    }

    public Quotation(String client, String name) {
        this.client = client;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;


    @Column(name = "client")
    private String client;


    @Column
    private String name;

    @ManyToMany
    private List<Functionality> functionalities;

    @ManyToMany
    private List<Item> standaloneItems;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public List<Functionality> getFunctionalities() {
        return functionalities;
    }

    public void setFunctionalities(List<Functionality> functionalities) {
        this.functionalities = functionalities;
    }

    public List<Item> getStandaloneItems() {
        return standaloneItems;
    }

    public void setStandaloneItems(List<Item> standaloneItems) {
        this.standaloneItems = standaloneItems;
    }


    public String getClient() {
        return client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
