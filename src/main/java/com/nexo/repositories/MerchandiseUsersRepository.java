package com.nexo.repositories;

import com.nexo.models.MerchandiseUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MerchandiseUsersRepository extends JpaRepository<MerchandiseUsers, Integer> {
    public Optional<List<MerchandiseUsers>> findByIdMerchandise(int idMerchandise);

    public Optional<List<MerchandiseUsers>> findByIdUserEdited(int idUserEdited);

    public void deleteByIdMerchandise(int idMerchandise);
}
