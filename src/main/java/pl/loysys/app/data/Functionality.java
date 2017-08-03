package pl.loysys.app.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.*;

@Entity
@Table(name = "functionalities")
public class Functionality {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "functionality_name")
    private String name;

    @Column(name = "functionality_time")
    private int workload;

    @ManyToMany(mappedBy = "functionalities")
    private List<Quotation> quotations = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "functionalities_items", joinColumns = @JoinColumn(name = "functionality_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Set<Item> items;

    protected Functionality() {
    }

    public Functionality(String functionalityName) {
        this.name = functionalityName;
    }

    public Functionality(String functionalityName, Set<Item> items) {
        this.name = functionalityName;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public int getWorkload() {
        return workload;
    }

    public void setName(String functionalityName) {
        this.name = functionalityName;
    }

    public void setWorkload(int functionalityTime) {
        this.workload = functionalityTime;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    private int calculateQuotationTime() {
        int totalQuotationTime;
        totalQuotationTime = items.stream().mapToInt(o -> o.getWorkload()).sum();
        return totalQuotationTime;
    }

    public Set<Item> getItems() {
        return items;
    }

    public List<String> listQuotationItemsNames() {
        List<String> quotationItemsNames = items.stream().map(o -> o.getName()).collect(Collectors.toList());
        return quotationItemsNames;
    }

    public void addQuotationToList(Quotation quotation) {
        quotations.add(quotation);
    }

    public String toString() {
        return String.format("Nazwa funkcjonalności: %s, czas wykonania: %d", getName(), getWorkload());
    }
}
