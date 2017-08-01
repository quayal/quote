package pl.loysys.app.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    public ClientService() {}

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    QuotationRepository quotationRepository;

    public Client addNewClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        List<Client> clientList = new ArrayList<>();
        clientRepository.findAll().forEach(clientList::add);
        return clientList;
    }
    public Client getClientDetails(Long id){
        return clientRepository.findById(id);
    }
}
