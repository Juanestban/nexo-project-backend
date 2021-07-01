package com.nexo.services;

import com.nexo.models.Merchandise;
import com.nexo.repositories.MerchandiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MerchandiseService {
    @Autowired
    private MerchandiseRepository merchandiseRepository;

    public List<Merchandise> getAllMerchandise() {
        return this.merchandiseRepository.findAll();
    }

    public Optional<Merchandise> getByIdMerchandise(int id) {
        return this.merchandiseRepository.findById(id);
    }

    public Merchandise createMerchandise(Merchandise merchandise) {
        return this.merchandiseRepository.save(merchandise);
    }

    public Merchandise updateMerchandise(Merchandise merchandise) {
        return this.merchandiseRepository.save(merchandise);
    }

    public void deleteMerchandise(int id) {
        this.merchandiseRepository.deleteById(id);
    }
}
