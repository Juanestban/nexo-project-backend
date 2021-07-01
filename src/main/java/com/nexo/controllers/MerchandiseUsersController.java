package com.nexo.controllers;

import com.nexo.models.MerchandiseUsers;
import com.nexo.services.MerchandiseUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MerchandiseUsersController {
    @Autowired
    private MerchandiseUsersService merchandiseUsersService;

    @GetMapping("/merchandiseUserEdited/{id}")
    public ResponseEntity<MerchandiseUsers> getById(@PathVariable int id) {
        var isMerchandiseUser = this.merchandiseUsersService.getById(id);
        return isMerchandiseUser.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/merchandiseUser/{idUserEdited}")
    public ResponseEntity<List<MerchandiseUsers>> getByIdUser(@PathVariable int idUserEdited) {
        var isMerchandiseUser = this.merchandiseUsersService.getByIdUser(idUserEdited);
        return isMerchandiseUser.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/userMerchandise/{idMerchandise}")
    public ResponseEntity<List<MerchandiseUsers>> getByIdMerchandise(@PathVariable int idMerchandise) {
        var isExist = this.merchandiseUsersService.getByIdMerchandise(idMerchandise);
        return isExist.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/merchandiseUserEdited")
    public ResponseEntity<MerchandiseUsers> createMerchandiseUserEdited(
            @RequestBody MerchandiseUsers merchandiseUsers) {
        try {
            var newMerchandiseUserEdited = this.merchandiseUsersService
                    .createMerchandiseUser(merchandiseUsers);
            return ResponseEntity
                    .created(new URI("/api/merchandiseUserEdited" + newMerchandiseUserEdited.getId()))
                    .body(newMerchandiseUserEdited);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
