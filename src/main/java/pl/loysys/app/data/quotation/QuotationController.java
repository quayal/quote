package pl.loysys.app.data.quotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.loysys.app.data.functionality.FunctionalityService;
import pl.loysys.app.data.functionality.FunctionalityTO;

@RestController
@RequestMapping("/quotations")
public class QuotationController {

    private final FunctionalityService functionalityService;
    private final QuotationService quotationService;

    @Autowired
    public QuotationController(FunctionalityService functionalityService, QuotationService quotationService) {
        this.functionalityService = functionalityService;
        this.quotationService = quotationService;
    }

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