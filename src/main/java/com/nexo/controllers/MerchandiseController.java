package com.nexo.controllers;

import com.nexo.models.Merchandise;
import com.nexo.models.MerchandiseUsers;
import com.nexo.services.MerchandiseService;
import com.nexo.services.MerchandiseUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/merchandises")
public class MerchandiseController {
    @Autowired
    private MerchandiseService merchandiseService;

    @Autowired
    private MerchandiseUsersService merchandiseUsersService;

    @GetMapping
    public ResponseEntity<List<Merchandise>> getAll() {
        try {
            var merchandises = this.merchandiseService.getAllMerchandise();
            return ResponseEntity.ok(merchandises);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Merchandise> getById(@PathVariable int id) {
        try {
            var optional = this.merchandiseService.getByIdMerchandise(id);

            return optional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Merchandise> postMerchandise(@RequestBody Merchandise merchandise) {
        try {
            var newMerchandise = this.merchandiseService.createMerchandise(merchandise);
            var result = ResponseEntity
                    .created(new URI("/api/merchandises" + newMerchandise.getId()))
                    .body(newMerchandise);
            MerchandiseUsers relationShip = new MerchandiseUsers();
            relationShip.setIdUserEdited(newMerchandise.getUserRegister());
            relationShip.setIdMerchandise(newMerchandise.getId());
            this.merchandiseUsersService.createMerchandiseUser(relationShip);
            return result;
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{id}/{idUser}")
    public ResponseEntity<Merchandise>
    updateMerchandise(@PathVariable int id, @PathVariable int idUser, @RequestBody Merchandise merchandise) {
        try {
           var isExistMerchandise = this.merchandiseService.getByIdMerchandise(id);
            if (isExistMerchandise.isPresent()) {
                merchandise.setId(id);
                var updated = this.merchandiseService.updateMerchandise(merchandise);
                var existMerchandiseUser =
                        this.merchandiseUsersService.getByIdMerchandise(id);
                if (existMerchandiseUser.isPresent()) {
                    MerchandiseUsers relationSip = existMerchandiseUser.get().get(0);
                    relationSip.setIdUserEdited(idUser);
                    this.merchandiseUsersService.updateMerchandiseUser(relationSip);
                }
                return ResponseEntity.ok(updated);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Merchandise> deleteMerchandise(@PathVariable int id) {
        try {
            var isExistMerchandise = this.merchandiseService.getByIdMerchandise(id);
            if (isExistMerchandise.isPresent()) {
                var merchandiseUser = this.merchandiseUsersService
                        .getByIdMerchandise(id);
                merchandiseUser.ifPresent(merchandiseUsers -> this.merchandiseUsersService
                        .deleteById(merchandiseUsers.get(0).getId()));
                this.merchandiseService.deleteMerchandise(id);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
