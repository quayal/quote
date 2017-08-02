package pl.loysys.app.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    public ClientController() {
    }

    @Autowired
    private ClientService clientService;

    @Autowired
    private QuotationService quotationService;

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
    public Client addClient(@RequestBody Client client) {
        return clientService.addNewClient(client);
    }



}
