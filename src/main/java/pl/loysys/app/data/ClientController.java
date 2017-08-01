package pl.loysys.app.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.POST, value = "/new")
    public Client addClient(@RequestBody Client client) {
        return clientService.addNewClient(client);
    }
}
