package com.nexo.services;

import com.nexo.models.Charges;
import com.nexo.repositories.ChargesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChargesService {
    @Autowired
    private ChargesRepository chargesRepository;

    public Charges createCharge(Charges charge) {
        return this.chargesRepository.save(charge);
    }

    public List<Charges> getAllCharges() {
        return this.chargesRepository.findAll();
    }

    public Optional<Charges> getById(int id) {
        return this.chargesRepository.findById(id);
    }

}
