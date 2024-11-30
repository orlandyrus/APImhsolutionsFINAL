package com.example.mhsolutions.service;

import com.example.mhsolutions.entity.Users;
import com.example.mhsolutions.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    // Obtener todos los usuarios
    public List<Users> getUsers() {
        return usersRepository.findAll();
    }

    // Obtener un usuario por ID
    public Optional<Users> getUsers(Long id) {
        return usersRepository.findById(id);
    }

    // Crear o actualizar un usuario
    public Users saveOrUpdate(Users user) {
        // Si el ID está presente, actualiza el usuario; si no, crea uno nuevo
        return usersRepository.save(user);  // Si el ID es nulo, se crea uno nuevo, si tiene ID se actualiza
    }

    // Eliminar un usuario por ID
    public void delete(Long id) {
        if (usersRepository.existsById(id)) {
            usersRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("El usuario con el ID proporcionado no existe");
        }
    }

    // Crear un nuevo usuario (Método separado para claridad)
    public Users createUser(Users user) {
        return usersRepository.save(user);  // Guarda un nuevo usuario
    }
}