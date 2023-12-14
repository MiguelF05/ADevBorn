package com.spring.mail.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration

public class MailConfiguration {

    @Value("${email.password}")
    private String emailPassword;
    @Value("${email.sender}")
    private String emailUser;

    @Bean
    public JavaMailSender getJavaMailSender(){

        JavaMailSenderImpl mailSender=new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername(emailUser);
        mailSender.setPassword(emailPassword);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");//Indica el protocolo de envio
        props.put("mail.smtp.auth", "true");//autentica con el protocolo smtp el Usuario y la Contraseña
        props.put("mail.smtp.starttls.enable", "true");//habilita el cifrado entre la comunicacion de la aplicacion y el correo
        props.put("mail.debug", "true");// nos muestra informacion en la consola es un seguimiento

        return mailSender;

    }

}
