package pl.loysys.app.data;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.*;

@Entity
@Table(name = "functionalities")
public class Functionality {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "functionality_name")
    private String functionalityName;

    @Column(name = "functionality_time")
    private int functionalityTime;

    @ManyToMany
    private List<Item> items;

    protected Functionality() {
    }

    public Functionality(String functionalityName) {
        this.functionalityName = functionalityName;
    }

    public Functionality(String functionalityName, List<Item> items) {
        this.functionalityName = functionalityName;
        this.items = items;
    }

    public String getFunctionalityName() {
        return functionalityName;
    }

    public Long getId() {
        return id;
    }

    public int getFunctionalityTime() {
        return functionalityTime;
    }

    public void setFunctionalityName(String functionalityName) {
        this.functionalityName = functionalityName;
    }

    public void setFunctionalityTime(int functionalityTime) {
        this.functionalityTime = functionalityTime;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    private int calculateQuotationTime() {
        int totalQuotationTime;
        totalQuotationTime = items.stream().mapToInt(o -> o.getItemTime()).sum();
        return totalQuotationTime;
    }

    public List<Item> getItems() {
        return items;
    }

    public List<String> listQuotationItemsNames() {
        List<String> quotationItemsNames = items.stream().map(o -> o.getItemName()).collect(Collectors.toList());
        return quotationItemsNames;
    }

    public String toString() {
        return String.format("Nazwa funkcjonalności: %s, czas wykonania: %d", getFunctionalityName(), getFunctionalityTime());
    }
}
