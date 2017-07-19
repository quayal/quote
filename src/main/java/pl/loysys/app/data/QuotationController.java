package pl.loysys.app.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quotations")
public class QuotationController {

    @Autowired
    FunctionalityService functionalityService;
    @Autowired
    ItemService itemService;
    @Autowired
    QuotationService quotationService;

    @RequestMapping("/addNew")
    public void newQuotation(String client, String name) {
        quotationService.addNewQuotation(client, name);
    }

    @GetMapping
    public List<Quotation> getQuotations(){
        return quotationService.getAllQuotations();
    }
}
