package com.nexo.controllers;


import com.nexo.models.Charges;
import com.nexo.services.ChargesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/charges")
public class ChargesController {
    @Autowired
    private ChargesService chargesService;

    @GetMapping
    public ResponseEntity<List<Charges>> listAllCharges() {
        try {
            var chargesList = this.chargesService.getAllCharges();
            return ResponseEntity.ok(chargesList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping
    public ResponseEntity<Charges> saveCharge(@RequestBody Charges charges) {
        try {
            Charges newCharge = this.chargesService.createCharge(charges);
            return ResponseEntity.created(new URI("/api/charges" + newCharge.getId())).body(newCharge);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
