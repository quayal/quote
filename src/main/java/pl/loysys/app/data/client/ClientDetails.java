package pl.loysys.app.data.client;

import pl.loysys.app.data.quotation.Quotation;

import java.util.List;

public class ClientDetails {
    private List<Quotation> clientQuotations;

    private String clientName;

    public ClientDetails(List<Quotation> clientQuotations, String clientName){
        this.clientQuotations = clientQuotations;
        this.clientName = clientName;
    }

    public ClientDetails() {
    }

    public List<Quotation> getClientQuotations() {
        return clientQuotations;
    }

    public void setClientQuotations(List<Quotation> clientQuotations) {
        this.clientQuotations = clientQuotations;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }



}
