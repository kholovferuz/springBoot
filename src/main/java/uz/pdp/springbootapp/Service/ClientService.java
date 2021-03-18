package uz.pdp.springbootapp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.springbootapp.DTO.Result;
import uz.pdp.springbootapp.Entity.Client;
import uz.pdp.springbootapp.Entity.Supplier;
import uz.pdp.springbootapp.Repository.ClientRepository;
import uz.pdp.springbootapp.Repository.SupplierRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    // ADD client
    public Result addClient(Client client) {
        boolean existsByName = clientRepository.existsByName(client.getName());
        if (existsByName) {
            return new Result("This client already exists", false);
        }
        clientRepository.save(client);
        return new Result("Client added", true);
    }

    // READ all clients
    public List<Client> readALlClients() {
        List<Client> clients = clientRepository.findAll();
        return clients;
    }

    // READ clients by id
    public Client readClientById(Integer id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            return  client;
        }
        return new Client();
    }

    // UPDATE client by id
    public Result updateClient(Client client, Integer id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            boolean existsByName = clientRepository.existsByName(client.getName());
            if (existsByName) {
                return new Result("This client already exists", false);
            }

            Client editedClient = optionalClient.get();
            editedClient.setName(client.getName());
            editedClient.setPhoneNumber(client.getPhoneNumber());

            clientRepository.save(editedClient);
            return new Result("Client updated", true);
        }
        return new Result("Client with this id is not found", false);
    }

    // DELETE client by id
    public Result deleteClient(Integer id){
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()){
            clientRepository.deleteById(id);
            return new Result("Client deleted",true);
        }
        return new Result("Client with this id is not found",false);

    }
}
