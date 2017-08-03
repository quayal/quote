package pl.loysys.app.data;

public class FunctionalityTO {

    private Long id;
    private String name;
    private Long quotationId;
    private int workload;

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

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }
}
