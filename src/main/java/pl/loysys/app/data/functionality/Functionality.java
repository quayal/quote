package pl.loysys.app.data.functionality;

import pl.loysys.app.data.item.Item;
import pl.loysys.app.data.quotation.Quotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.*;

@Entity
@Table(name = "func_dict")
public class Functionality {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "functionality_name")
    private String name;

    @Column(name = "functionality_gui_workload")
    private int guiWorkload;

    @Column(name = "functionality_ss_workload")
    private int ssWorkload;

    @ManyToMany(mappedBy = "functionalities")
    private List<Quotation> quotations = new ArrayList<>();

    @OneToMany(mappedBy = "functionality", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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

    public int getGuiWorkload() {
        return guiWorkload;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setName(String functionalityName) {
        this.name = functionalityName;
    }

    public void setGuiWorkload(int functionalityTime) {
        this.guiWorkload = functionalityTime;
    }

    public int getSsWorkload() {
        return ssWorkload;
    }

    public void setSsWorkload(int ssWorkload) {
        this.ssWorkload = ssWorkload;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public int calculateGuiWorkloadTime() {
        return items.stream().mapToInt(o -> o.getGuiWorkload()).sum();
    }

    public int calculateSsWorkloadTime() {
        return items.stream().mapToInt(o -> o.getSsWorkload()).sum();
    }

    public List<String> listQuotationItemsNames(){
      return items.stream().map(o -> o.getName()).collect(Collectors.toList());
    }

    public void addQuotationToList(Quotation quotation) {
        quotations.add(quotation);
    }

    public String toString() {
        return String.format("Nazwa funkcjonalności: %s, czas GUI: %d, czas SS: %d", getName(), getGuiWorkload(), getSsWorkload());
    }
}
