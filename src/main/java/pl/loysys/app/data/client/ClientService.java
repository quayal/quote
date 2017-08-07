package pl.loysys.app.data.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.loysys.app.data.quotation.QuotationRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    public ClientService(ClientRepository clientRepository, QuotationRepository quotationRepository) {
        this.clientRepository = clientRepository;
        this.quotationRepository = quotationRepository;
    }

    private final ClientRepository clientRepository;
    private final QuotationRepository quotationRepository;

    public Client addNewClient(ClientTO clientTO) {
        Client clientToSave = new Client();
        clientToSave.setName(clientTO.getName());
        return clientRepository.save(clientToSave);
    }

    public List<Client> getAllClients() {
        List<Client> clientList = new ArrayList<>();
        clientRepository.findAll().forEach(clientList::add);
        return clientList;
    }
    public Client getClientDetails(Long id){
        return clientRepository.findById(id);
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id);
    }
}
