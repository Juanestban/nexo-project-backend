package com.nexo.services;

import com.nexo.models.ControlMerchandise;
import com.nexo.repositories.ControlMerchandiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ControlMerchandiseService {
    @Autowired
    private ControlMerchandiseRepository controlMerchandiseRepository;

    public List<ControlMerchandise> getAllMerchandiseControl() {
        return this.controlMerchandiseRepository.findAll();
    }

    public Optional<ControlMerchandise> getControlMerchandiseById(int id) {
        return this.controlMerchandiseRepository.findById(id);
    }
}
