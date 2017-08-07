package pl.loysys.app.data.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.loysys.app.data.functionality.Functionality;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int guiWorkload;
    private int ssWorkload;

    public Item() {}

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "functionality_id")
    private Functionality functionality;

    public Item(String name, int guiWorkload, int ssWorkload) {
        this.name = name;
        this.guiWorkload = guiWorkload;
        this.ssWorkload = ssWorkload;
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

    public int getGuiWorkload() {
        return guiWorkload;
    }

    public void setGuiWorkload(int guiWorkload) {
        this.guiWorkload = guiWorkload;
    }

    public int getSsWorkload() {
        return ssWorkload;
    }

    public void setSsWorkload(int ssWorkload) {
        this.ssWorkload = ssWorkload;
    }

    @JsonIgnore
    public Functionality getFunctionality() {
        return functionality;
    }

    public void setFunctionality(Functionality functionality) {
        this.functionality = functionality;
    }
}
