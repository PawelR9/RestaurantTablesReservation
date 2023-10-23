package pl.application.reservation.tables.restaurant.controllers;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.application.reservation.tables.restaurant.model.User;
import pl.application.reservation.tables.restaurant.model.dto.UpdateClientDTO;
import pl.application.reservation.tables.restaurant.repository.IUserRepository;
import pl.application.reservation.tables.restaurant.services.ClientService;
import pl.application.reservation.tables.restaurant.session.SessionData;

@Controller
@RequestMapping("/konto")
public class ClientAccountController {

    @Autowired
    private IUserRepository userRepository;

    @Resource
    SessionData sessionData;

    private final ClientService clientService;

    @Autowired
    public ClientAccountController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String showMyAccount(Model model) {
        User user = sessionData.getUser();

        if (user != null) {
            UpdateClientDTO updateClientDTO = new UpdateClientDTO();
            updateClientDTO.setFirstName(user.getFirst_name());
            updateClientDTO.setLastName(user.getLast_name());
            updateClientDTO.setPhone(user.getPhone_number());
            model.addAttribute("updateClientDTO", updateClientDTO);
            return "myAccount";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping
    public String updateMyAccount(@ModelAttribute UpdateClientDTO updateClientDTO,
                                  RedirectAttributes redirectAttributes) {
        User user = sessionData.getUser();
        if (user != null) {
            clientService.updateClient(updateClientDTO, user);

            redirectAttributes.addAttribute("correctSave", "Dane zostały poprawnie zmienione");
            return "redirect:/konto";
        } else
            return "redirect:/login";
    }
}
