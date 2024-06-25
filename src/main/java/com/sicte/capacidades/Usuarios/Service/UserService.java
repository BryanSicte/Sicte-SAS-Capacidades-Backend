package com.sicte.capacidades.Usuarios.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sicte.capacidades.Usuarios.Entity.User;
import com.sicte.capacidades.Usuarios.Repository.UserRepository;

@Service
public class UserService{
    @Autowired
    UserRepository userRepository;

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
}
