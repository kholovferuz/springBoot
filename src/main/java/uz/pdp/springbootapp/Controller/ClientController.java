package uz.pdp.springbootapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootapp.DTO.Result;
import uz.pdp.springbootapp.Entity.Client;
import uz.pdp.springbootapp.Entity.Supplier;
import uz.pdp.springbootapp.Repository.ClientRepository;
import uz.pdp.springbootapp.Service.ClientService;
import uz.pdp.springbootapp.Service.SupplierService;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    // CREATE new client
    @PostMapping
    public Result addClients(@RequestBody Client client) {
        Result result = clientService.addClient(client);
        return result;
    }

    // READ all clients
    @GetMapping
    public List<Client> readAllClient() {
        List<Client> clients = clientService.readALlClients();
        return clients;
    }

    // READ Client by id
    @GetMapping("/{id}")
    public Client readClientsById(@PathVariable Integer id) {
        Client clientById = clientService.readClientById(id);
        return clientById;
    }

    // UPDATE Client by id
    @PutMapping("/{id}")
    public Result updateClientById(@PathVariable Integer id, @RequestBody Client client) {
        Result updateClient = clientService.updateClient(client, id);
        return updateClient;
    }

    // DELETE Client by id
    @DeleteMapping("/{id}")
    public Result deleteClientById(@PathVariable Integer id) {
        Result deleteClient = clientService.deleteClient(id);
        return deleteClient;

    }
}
