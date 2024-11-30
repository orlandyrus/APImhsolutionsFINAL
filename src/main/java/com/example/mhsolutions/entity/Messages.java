package com.example.mhsolutions.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Messages")
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private String empresa;
    private String mensaje;

    // Si lo prefieres, puedes agregar un constructor, getters y setters manualmente,
    // pero el uso de Lombok (@Data) ya lo proporciona automáticamente.
}