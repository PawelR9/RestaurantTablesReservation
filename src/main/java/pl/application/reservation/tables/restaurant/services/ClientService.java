package pl.application.reservation.tables.restaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.application.reservation.tables.restaurant.model.Client;
import pl.application.reservation.tables.restaurant.model.User;
import pl.application.reservation.tables.restaurant.model.dto.ClientRegistrationDTO;
import pl.application.reservation.tables.restaurant.repository.IClientRepository;
import pl.application.reservation.tables.restaurant.repository.IUserRepository;

@Service
public class ClientService {
    private final IClientRepository clientRepository;
    private final IUserRepository userRepository;

    @Autowired
    public ClientService(IClientRepository clientRepository, IUserRepository userRepository) {
        this.clientRepository = clientRepository;
        this.userRepository = userRepository;
    }


    public Client registerClient(ClientRegistrationDTO clientRegistrationDTO) {
        User user = new User();

        user.setFirst_name(clientRegistrationDTO.getFirstName());
        user.setLast_name(clientRegistrationDTO.getLastName());
        user.setEmail(clientRegistrationDTO.getEmail());
        user.setPhone_number(clientRegistrationDTO.getPhone());

        User savedUser = userRepository.save(user);
        Client client = new Client();
        return clientRepository.save(client);
    }
}
