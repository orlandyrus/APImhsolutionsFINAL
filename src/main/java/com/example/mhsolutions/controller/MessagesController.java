package com.example.mhsolutions.controller;

import com.example.mhsolutions.entity.Messages;
import com.example.mhsolutions.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/messages")
@CrossOrigin(origins = "http://localhost:4200") // Permite solicitudes desde el cliente Angular
public class MessagesController {

    @Autowired
    private MessagesService messagesService;

    // Crear un nuevo mensaje
    @PostMapping
    public ResponseEntity<Messages> createMessage(@RequestBody Messages message) {
        Messages savedMessage = messagesService.saveMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMessage);
    }

    // Obtener todos los mensajes (para el administrador)
    @GetMapping
    public ResponseEntity<List<Messages>> getAllMessages() {
        List<Messages> messages = messagesService.getAllMessages();
        return ResponseEntity.ok(messages);
    }

    // Obtener un mensaje por ID
    @GetMapping("/{messageId}")
    public ResponseEntity<Messages> getMessageById(@PathVariable("messageId") Long messageId) {
        Optional<Messages> message = messagesService.getMessage(messageId);
        return message.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Eliminar mensaje por ID (opcional, para administración)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable("id") Long id) {
        // Verificamos si el mensaje existe antes de intentar eliminarlo
        if (!messagesService.existsById(id)) {
            return ResponseEntity.notFound().build();  // Si no existe, devolvemos un 404
        }
        messagesService.deleteMessage(id);  // Si existe, lo eliminamos
        return ResponseEntity.noContent().build();  // Devolvemos un 204 No Content
    }
}