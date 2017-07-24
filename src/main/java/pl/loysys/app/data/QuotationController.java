package pl.loysys.app.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public void newQuotation(Client client, String name) {
        quotationService.addNewQuotation(client, name);
    }


}
