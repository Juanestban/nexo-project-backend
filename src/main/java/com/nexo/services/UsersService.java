package com.nexo.services;

import com.nexo.models.Charges;
import com.nexo.models.Users;
import com.nexo.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public Users createUser(Users users) {
        return this.usersRepository.save(users);
    }

    public List<Users> getAllUsers() {
        return this.usersRepository.findAll();
    }

    public Optional<Users> getById(int id) {
        return this.usersRepository.findById(id);
    }
}
