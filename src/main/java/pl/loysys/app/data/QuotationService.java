package pl.loysys.app.data;

import com.sun.org.apache.xpath.internal.operations.Quo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuotationService {

    @Autowired
    private QuotationRepository quotationRepository;

    public QuotationService(){}

    public QuotationService(String client, String name){
    }

    public Quotation addNewQuotation(String client, String name) {
        return new Quotation(client, name);
    }

    public List<Quotation> getAllQuotations() {
        List<Quotation> quotationList = new ArrayList<>();
        quotationRepository.findAll().forEach(quotationList::add);
        return quotationList;
    }
}
