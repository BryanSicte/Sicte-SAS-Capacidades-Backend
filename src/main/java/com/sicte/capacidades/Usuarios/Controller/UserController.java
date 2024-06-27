package com.sicte.capacidades.Usuarios.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sicte.capacidades.Usuarios.Entity.User;
import com.sicte.capacidades.Usuarios.Service.UserService;

import jakarta.validation.Valid;

import java.util.List;


@CrossOrigin(origins = "https://BryanSicte.github.io")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User createdUser = userService.save(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("/login/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        
        String correo = user.getCorreo();
        String contrasena = user.getContrasena();

        User usuarioEncontrado = userService.findByCorreo(correo);
        if (usuarioEncontrado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (!usuarioEncontrado.getContrasena().equals(contrasena)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        // Aquí puedes agregar cualquier otra lógica que necesites, por ejemplo, generar un token de autenticación
        
        return ResponseEntity.ok(usuarioEncontrado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {
        user.setId(id);
        User updatedUser = userService.save(user);
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        boolean deleted = userService.deleteById(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/nombre/{valor}")
    public ResponseEntity<Object> findByName(@PathVariable("valor") String valor) {
        if (userService.findByNombre(valor) == null) {
            return new ResponseEntity<>("{\"status\":404,\"message\":\"Usuario no encontrado\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userService.findByNombre(valor), HttpStatus.OK);
    }

    @GetMapping("/correo/{valor}")
    public ResponseEntity<Object> findByCorreo(@PathVariable("valor") String valor) {
        if (userService.findByCorreo(valor) == null) {
            return new ResponseEntity<>("{\"status\":404,\"message\":\"Usuario no encontrado\"}", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userService.findByCorreo(valor), HttpStatus.OK);
    }
}
