package com.nexo.controllers;

import com.nexo.models.ControlMerchandise;
import com.nexo.services.ControlMerchandiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/controlMerchandise")
public class ControlMerchandiseController {
    @Autowired
    private ControlMerchandiseService controlMerchandiseService;

    @GetMapping
    public ResponseEntity<List<ControlMerchandise>> getAll() {
        var contronMerchandiseList = this.controlMerchandiseService.getAllMerchandiseControl();
        return ResponseEntity.ok(contronMerchandiseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ControlMerchandise> getById(@PathVariable int id) {
        var controlMercandise = this.controlMerchandiseService.getControlMerchandiseById(id);
        return controlMercandise.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
