package pl.loysys.app.data.quotation;


public class QuotationTO {
    private Long clientId;
    private String name;

    public QuotationTO(Long clientId, String name) {
        this.clientId = clientId;
        this.name = name;
    }

    public QuotationTO() {
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
