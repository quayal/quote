package pl.loysys.app.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    public ClientController(){}

    @Autowired
    ClientService clientService;

    @Autowired
    QuotationService quotationService;

    @GetMapping
    public List<Client> getClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{clientId}")
    public Client getClientDetails(@PathVariable("clientId") Long id){
        return clientService.getClientDetails(id);

        }

    /* @GetMapping("/{clientId}")
    public List<Quotation> getQuotations(@PathVariable("clientId") Long id){
        return quotationService.getClientQuotations(id);
    }*/



}
