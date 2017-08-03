package pl.loysys.app.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Payload;
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
    @Autowired
    ClientService clientService;

    @GetMapping("/{quotationId}")
    public Quotation getQuotationDetails(@PathVariable("quotationId") Long quotationId) {
        return quotationService.getQuotationDetails(quotationId);
    }

    @PostMapping("/{quotationId}")
    public FunctionalityTO addFunctionality(@PathVariable("quotationId") Long quotationId, @RequestBody FunctionalityTO functionalityTO) {
        functionalityTO.setQuotationId(quotationId);
        return functionalityService.addFunctionality(functionalityTO);
    }
}