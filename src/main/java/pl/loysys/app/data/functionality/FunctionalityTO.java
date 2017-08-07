package pl.loysys.app.data.functionality;

import pl.loysys.app.data.item.ItemTO;

import java.util.List;

public class FunctionalityTO {

    private Long id;
    private String name;
    private Long quotationId;
    private int guiWorkload;
    private int ssWorkload;
    private List<ItemTO> items;

    public FunctionalityTO(String name, Long quotationId) {
        this.name = name;
        this.quotationId = quotationId;
    }

    public FunctionalityTO() {
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

    public Long getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(Long quotationId) {
        this.quotationId = quotationId;
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

    public List<ItemTO> getItems() {
        return items;
    }

    public void setItems(List<ItemTO> items) {
        this.items = items;
    }
}
