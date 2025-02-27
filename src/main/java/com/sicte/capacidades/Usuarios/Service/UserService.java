package com.sicte.capacidades.usuarios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sicte.capacidades.usuarios.entity.pagesUser;
import com.sicte.capacidades.usuarios.entity.tokens;
import com.sicte.capacidades.usuarios.entity.user;
import com.sicte.capacidades.usuarios.repository.pagesUserRepository;
import com.sicte.capacidades.usuarios.repository.tokensRepository;
import com.sicte.capacidades.usuarios.repository.userRepository;

@Service
public class userService{

    @Autowired
    userRepository userRepository;

    @Autowired 
    pagesUserRepository pagesUserRepository; 

    @Autowired
    tokensRepository tokensRepository;

    @Autowired
    private JavaMailSender mailSender;

    public user save(user user) {
        return userRepository.save(user);
    }

    public List<user> findAll() {
        return (List<user>) userRepository.findAll();
    }

    public user findByNombre(String valor) {
        return userRepository.findByNombre(valor);
    }

    public user findByCorreo(String valor) {
        return userRepository.findByCorreo(valor);
    }

    public user getUserById(String id) {
        return userRepository.findById(id).get();
    }

    public user getUserByCorreo(String correo) {
        return userRepository.findByCorreo(correo);
    }

    public Boolean deleteById(String id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {

            return false;
        }
    }

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }

    public Optional<tokens> findByToken(String token) {
        return tokensRepository.findByToken(token);
    }

    public List<tokens> findAllTokens() {
        return (List<tokens>) tokensRepository.findAll();
    }

    public void actualizarContrasena(String email, String contrasena) {
        userRepository.actualizarContrasena(email, contrasena);
    }

    public List<pagesUser> findAllPagesUser() {
        return (List<pagesUser>) pagesUserRepository.findAll();
    }

    public pagesUser savePagesUser(pagesUser pagesUser) {
        return pagesUserRepository.save(pagesUser);
    }
}
