package com.sicte.capacidades.usuarios.entity;

import jakarta.persistence.*;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tokens")
@NoArgsConstructor
@AllArgsConstructor
public class tokens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    private String email;
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiryDate;
}
