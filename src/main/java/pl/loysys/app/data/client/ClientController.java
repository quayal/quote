package pl.loysys.app.data.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.loysys.app.data.quotation.QuotationService;
import pl.loysys.app.data.quotation.QuotationTO;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    public ClientController(ClientService clientService, QuotationService quotationService) {
        this.clientService = clientService;
        this.quotationService = quotationService;
    }

    private final ClientService clientService;

    private final QuotationService quotationService;

    @GetMapping
    public List<Client> getClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{clientId}")
    public Client getClientDetails(@PathVariable("clientId") Long id) {
        return clientService.getClientDetails(id);
    }

    @PostMapping("/{clientId}")
    public QuotationTO addQuotation(@PathVariable("clientId") Long clientId, @RequestBody QuotationTO quotationTO) {
        return quotationService.addQuotation(quotationTO);
    }
    @PostMapping
    public Client addClient(@RequestBody ClientTO clientTO) {
        return clientService.addNewClient(clientTO);
    }



}
