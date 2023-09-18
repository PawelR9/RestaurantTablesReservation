package pl.application.reservation.tables.restaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.application.reservation.tables.restaurant.model.Client;
import pl.application.reservation.tables.restaurant.model.User;
import pl.application.reservation.tables.restaurant.model.dto.ClientRegistrationDTO;
import pl.application.reservation.tables.restaurant.repository.IClientRepository;
import pl.application.reservation.tables.restaurant.repository.IUserRepository;

import java.time.LocalDateTime;

@Service
public class ClientService {
    private final IClientRepository clientRepository;
    private final IUserRepository userRepository;

    @Autowired
    public ClientService(IClientRepository clientRepository, IUserRepository userRepository) {
        this.clientRepository = clientRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void registerClient(ClientRegistrationDTO clientRegistrationDTO) {

        User user = new User();

        user.setFirst_name(clientRegistrationDTO.getFirstName());
        user.setLast_name(clientRegistrationDTO.getLastName());
        user.setEmail(clientRegistrationDTO.getEmail());
        user.setPhone_number(clientRegistrationDTO.getPhone());
        user.setRole(clientRegistrationDTO.getRole());
        user.setCreated_at(LocalDateTime.now());

        user = userRepository.save(user);

        Client client = new Client();
        client.setUser(user);
        client.setFirst_name(clientRegistrationDTO.getFirstName());
        client.setLast_name(clientRegistrationDTO.getLastName());
        client.setEmail(clientRegistrationDTO.getEmail());
        client.setPhone_number(clientRegistrationDTO.getPhone());

        clientRepository.save(client);
    }
}
