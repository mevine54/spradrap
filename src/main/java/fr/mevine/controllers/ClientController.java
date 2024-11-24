package fr.mevine.controllers;

import fr.mevine.dao.ClientDao;
import fr.mevine.models.Client;

import java.util.List;

public class ClientController {
    private final ClientDao clientDao = new ClientDao();

    public List<Client> getAllClients() {
        return clientDao.findAll();
    }

    public Client getClientById(int id) {
        return clientDao.findById(id);
    }

    public void createClient(Client client) {
        clientDao.create(client);
    }

    public void updateClient(Client client) {
        clientDao.update(client);
    }

    public void deleteClient(int id) {
        clientDao.delete(id);
    }
}

