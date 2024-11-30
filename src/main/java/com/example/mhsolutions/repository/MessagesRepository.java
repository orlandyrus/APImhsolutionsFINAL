package com.example.mhsolutions.repository;

import com.example.mhsolutions.entity.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagesRepository extends JpaRepository<Messages, Long> {
    // Aquí puedes agregar consultas personalizadas si es necesario.
}