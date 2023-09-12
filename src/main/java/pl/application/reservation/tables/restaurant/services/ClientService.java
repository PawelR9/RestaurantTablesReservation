package pl.application.reservation.tables.restaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import pl.application.reservation.tables.restaurant.model.Client;
import pl.application.reservation.tables.restaurant.repository.IClientRepository;

@Service
public class ClientService {
    private final IClientRepository IClientRepository;

    @Autowired
    public ClientService(IClientRepository IClientRepository) {
        this.IClientRepository = IClientRepository;
    }


    public Client registerClient(Client client) {
        // Dodaj logikę rejestracji klienta, jeśli jest potrzebna
        // Następnie zapisz klienta w bazie danych
        return IClientRepository.save(client);
    }


    // Dodaj inne metody serwisowe związane z klientami, jeśli są potrzebne
}
