package pl.loysys.app.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuotationService {

    @Autowired
    private QuotationRepository quotationRepository;
    @Autowired
    private ClientRepository clientRepository;

    public QuotationService(){}

    public QuotationService(Client client, String name){
    }

    public QuotationTO addQuotation(QuotationTO quotationTO) {
        Quotation toSave = new Quotation(clientRepository.findById(quotationTO.getClientId()), quotationTO.getName());
        quotationRepository.save(toSave);
        return quotationTO;
    }

    public List<Quotation> getAllQuotations() {
        List<Quotation> quotationList = new ArrayList<>();
        quotationRepository.findAll().forEach(quotationList::add);
        return quotationList;
    }

    public List<Quotation> getClientQuotations(Long id){
        List<Quotation> clientsQuotations = new ArrayList<>();
        quotationRepository.findByClientId(id).forEach(clientsQuotations::add);
        return clientsQuotations;
    }

    public Quotation getQuotationDetails(Long id){
        return quotationRepository.findById(id);
    }

}
