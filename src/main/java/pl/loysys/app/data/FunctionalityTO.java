package pl.loysys.app.data;

public class FunctionalityTO {

    private String name;
    private Long quotationId;

    public FunctionalityTO(String name, Long quotationId) {
        this.name = name;
        this.quotationId = quotationId;
    }

    public FunctionalityTO() {
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
}
