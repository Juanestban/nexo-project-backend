package com.nexo.services;

import com.nexo.models.MerchandiseUsers;
import com.nexo.repositories.MerchandiseUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MerchandiseUsersService {
    @Autowired
    private MerchandiseUsersRepository merchandiseUsersRepository;

    public Optional<MerchandiseUsers> getById(int id) {
        return this.merchandiseUsersRepository.findById(id);
    }

    public Optional<List<MerchandiseUsers>> getByIdUser(int idUserEdited) {
        return this.merchandiseUsersRepository.findByIdUserEdited(idUserEdited);
    }

    public Optional<List<MerchandiseUsers>> getByIdMerchandise(int idMerchandise) {
        return this.merchandiseUsersRepository.findByIdMerchandise(idMerchandise);
    }

    public MerchandiseUsers createMerchandiseUser(MerchandiseUsers merchandiseUsers) {
        return this.merchandiseUsersRepository.save(merchandiseUsers);
    }

    public MerchandiseUsers updateMerchandiseUser(MerchandiseUsers merchandiseUsers) {
        return this.merchandiseUsersRepository.save(merchandiseUsers);
    }

    public void deleteByIdMerchandise(int id) {
        this.merchandiseUsersRepository.deleteByIdMerchandise(id);
    }

    public void deleteById(int id) {
        this.merchandiseUsersRepository.deleteById(id);
    }
}
