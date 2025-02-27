package com.sicte.capacidades.usuarios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sicte.capacidades.usuarios.entity.PagesUser;
import com.sicte.capacidades.usuarios.entity.Tokens;
import com.sicte.capacidades.usuarios.entity.User;
import com.sicte.capacidades.usuarios.repository.PagesUserRepository;
import com.sicte.capacidades.usuarios.repository.TokensRepository;
import com.sicte.capacidades.usuarios.repository.UserRepository;

@Service
public class UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired 
    PagesUserRepository pagesUserRepository; 

    @Autowired
    TokensRepository tokensRepository;

    @Autowired
    private JavaMailSender mailSender;

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    public User findByNombre(String valor) {
        return userRepository.findByNombre(valor);
    }

    public User findByCorreo(String valor) {
        return userRepository.findByCorreo(valor);
    }

    public User getUserById(String id) {
        return userRepository.findById(id).get();
    }

    public User getUserByCorreo(String correo) {
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

    public Optional<Tokens> findByToken(String token) {
        return tokensRepository.findByToken(token);
    }

    public List<Tokens> findAllTokens() {
        return (List<Tokens>) tokensRepository.findAll();
    }

    public void actualizarContrasena(String email, String contrasena) {
        userRepository.actualizarContrasena(email, contrasena);
    }

    public List<PagesUser> findAllPagesUser() {
        return (List<PagesUser>) pagesUserRepository.findAll();
    }

    public PagesUser savePagesUser(PagesUser pagesUser) {
        return pagesUserRepository.save(pagesUser);
    }
    
}
