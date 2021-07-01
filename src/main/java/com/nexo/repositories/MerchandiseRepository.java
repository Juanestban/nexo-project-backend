package com.nexo.repositories;

import com.nexo.models.Merchandise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchandiseRepository extends JpaRepository<Merchandise, Integer> {
}
