package com.sicte.capacidades.usuarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sicte.capacidades.usuarios.dto.actualizarContrasena;
import com.sicte.capacidades.usuarios.dto.tokenUtils;
import com.sicte.capacidades.usuarios.entity.pagesUser;
import com.sicte.capacidades.usuarios.entity.tokens;
import com.sicte.capacidades.usuarios.entity.user;
import com.sicte.capacidades.usuarios.repository.tokensRepository;
import com.sicte.capacidades.usuarios.service.userService;

import jakarta.validation.Valid;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = { "https://sictepowergmail.github.io/", "https://BryanSicte.github.io", "https://bryanutria.github.io/",
        "http://localhost:3000" })
@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    private userService userService;

    @Autowired
    private tokensRepository tokensRepository;

    @GetMapping
    public ResponseEntity<List<user>> getAllUsers() {
        List<user> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<user> getUserById(@PathVariable String id) {
        user user = userService.getUserById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<user> createUser(@Valid @RequestBody user user) {
        user createdUser = userService.save(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("/login/login")
    public ResponseEntity<user> login(@RequestBody user user) {

        String correo = user.getCorreo();
        String contrasena = user.getContrasena();

        user usuarioEncontrado = userService.findByCorreo(correo);
        if (usuarioEncontrado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (!usuarioEncontrado.getContrasena().equals(contrasena)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        // Aquí puedes agregar cualquier otra lógica que necesites, por ejemplo, generar
        // un token de autenticación

        return ResponseEntity.ok(usuarioEncontrado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<user> updateUser(@PathVariable String id, @RequestBody user user) {
        user.setId(id);
        user updatedUser = userService.save(user);
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

    @PostMapping("/enviarToken")
    public String sendResetToken(@RequestBody Map<String, String> payload) {
        // Generar token y fecha de expiración
        String token = tokenUtils.generateToken();
        Date expiryDate = tokenUtils.calculateExpiryDate(30); // Token válido por 30 minutos
        String email = payload.get("email");

        // Guardar token en la base de datos
        tokens resetToken = new tokens();
        resetToken.setToken(token);
        resetToken.setEmail(email);
        resetToken.setExpiryDate(expiryDate);
        tokensRepository.save(resetToken);

        // Enviar correo con el token
        String resetLink = "https://sictepowergmail.github.io/ReportingCenter/#/RecuperarContrasena?token=" + token;
        userService.sendEmail(email, "Restablecer Contraseña",
                "Haz clic en el siguiente enlace para restablecer tu contraseña:\n" + resetLink);

        return "Correo enviado exitosamente.";
    }

    @GetMapping("/validarToken")
    public String validateToken(@RequestParam String token) {
        Optional<tokens> optionalToken = userService.findByToken(token); // Cambiar tokenUtils a tokens

        if (optionalToken.isEmpty()) {
            return "Token inválido.";
        }

        tokens resetToken = optionalToken.get(); // Cambiar tokenUtils a tokens

        if (resetToken.getExpiryDate().before(new Date())) { // Esto debería funcionar si getExpiryDate está en la clase
                                                             // tokens
            return "Token expirado";
        }

        return "Token valido";
    }

    @GetMapping("/tokens")
    public ResponseEntity<List<tokens>> getAllTokens() {
        List<tokens> tokens = userService.findAllTokens();
        return new ResponseEntity<>(tokens, HttpStatus.OK);
    }

    @PostMapping("/actualizarContrasena")
    public ResponseEntity<String> actualizarContrasena(
            @RequestBody actualizarContrasena request) {
        try {
            String email = request.getEmail();
            String contrasena = request.getContrasena();

            userService.actualizarContrasena(email, contrasena);

            return ResponseEntity.ok("Contrasena actualizada correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el estado");
        }
    }

    @GetMapping("/pagesUser")
    public ResponseEntity<List<pagesUser>> getAllPagesUser() {
        List<pagesUser> pagesUsers = userService.findAllPagesUser();
        return new ResponseEntity<>(pagesUsers, HttpStatus.OK);
    }

    @PutMapping("/pagesUser/{id}")
    public ResponseEntity<pagesUser> updatePagesUser(@PathVariable Long id, @RequestBody pagesUser pagesUser) {
        pagesUser.setId(id);
        pagesUser updatedPagesUser = userService.savePagesUser(pagesUser);
        if (updatedPagesUser != null) {
            return new ResponseEntity<>(updatedPagesUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
