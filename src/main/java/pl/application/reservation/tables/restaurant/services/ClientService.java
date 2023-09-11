package pl.application.reservation.tables.restaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.application.reservation.tables.restaurant.model.Client;
import pl.application.reservation.tables.restaurant.repository.ClientRepository;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client registerClient(Client client) {
        // Dodaj logikę rejestracji klienta, jeśli jest potrzebna
        // Następnie zapisz klienta w bazie danych
        return clientRepository.save(client);
    }

    // Dodaj inne metody serwisowe związane z klientami, jeśli są potrzebne
}
