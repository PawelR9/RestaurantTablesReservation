package pl.application.reservation.tables.restaurant.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    @Autowired
    private final JavaMailSender mailSender;

    public void sendEmail(String address, String title, String mailMessage) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(address);
        message.setSubject(title);
        message.setText(mailMessage);
        message.setFrom("emailforappuse2@gmail.com");

        mailSender.send(message);
    }
}
