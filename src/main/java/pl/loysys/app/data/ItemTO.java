package pl.loysys.app.data;

public class ItemTO {

    private Long id;
    private String name;
    private Long functionalityId;
    private int workload;

    public ItemTO(String name, Long functionalityId, int workload) {
        this.name = name;
        this.functionalityId = functionalityId;
        this.workload = workload;
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

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }
}
