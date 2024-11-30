package com.example.mhsolutions.service;

import com.example.mhsolutions.entity.Messages;
import com.example.mhsolutions.repository.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessagesService {

    @Autowired
    private MessagesRepository messagesRepository;

    // Obtener todos los mensajes
    public List<Messages> getAllMessages() {
        return messagesRepository.findAll();
    }

    // Obtener un mensaje por ID
    public Optional<Messages> getMessage(Long id) {
        return messagesRepository.findById(id);
    }

    // Guardar o actualizar un mensaje
    public Messages saveMessage(Messages message) {
        return messagesRepository.save(message);
    }

    // Eliminar mensaje por ID
    public void deleteMessage(Long id) {
        messagesRepository.deleteById(id);
    }

    // Verificar si el mensaje existe por ID
    public boolean existsById(Long id) {
        return messagesRepository.existsById(id);
    }
}