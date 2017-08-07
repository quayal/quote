package pl.loysys.app.data.item;

import org.springframework.stereotype.Component;

@Component
public class ItemTO {

    private Long id;
    private String name;
    private Long functionalityId;
    private int guiWorkload;
    private int ssWorkload;

    public ItemTO(String name, Long functionalityId, int guiWorkload, int ssWorkload) {
        this.name = name;
        this.functionalityId = functionalityId;
        this.guiWorkload = guiWorkload;
        this.ssWorkload = ssWorkload;
    }

    public ItemTO() {
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

    public Long getFunctionalityId() {
        return functionalityId;
    }

    public void setFunctionalityId(Long functionalityId) {
        this.functionalityId = functionalityId;
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
}
