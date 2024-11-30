package com.example.mhsolutions.controller;

import com.example.mhsolutions.entity.Users;
import com.example.mhsolutions.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
@CrossOrigin(origins = "http://localhost:4200") // Nota: Usa "http" en minúsculas
public class UsersController {

    @Autowired
    private UsersService usersService;

    // Obtener todos los usuarios
    @GetMapping
    public List<Users> getAll() {
        return usersService.getUsers();
    }

    // Obtener usuario por ID
    @GetMapping("/{userId}")
    public Optional<Users> getById(@PathVariable("userId") Long userId) {
        return usersService.getUsers(userId);
    }

    // Crear o actualizar usuario
    @PostMapping
    public Users createOrUpdateUser(@RequestBody Users user) {
        return usersService.saveOrUpdate(user);  // Si el ID es nulo, se crea uno nuevo, si tiene ID se actualiza
    }

    // Actualizar usuario por ID
    @PutMapping("/{userId}")
    public Users updateUser(
            @PathVariable("userId") Long userId,
            @RequestBody Users user) {
        // Validar que el ID en el cuerpo del objeto coincida con el de la URL
        if (!userId.equals(user.getId())) {
            throw new IllegalArgumentException("El ID del usuario no coincide con el ID de la URL");
        }
        return usersService.saveOrUpdate(user);  // Actualiza el usuario
    }

    // Eliminar usuario por ID
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        usersService.delete(userId);
    }
}