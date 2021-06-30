package com.nexo.repositories;

import com.nexo.models.ControlMerchandise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControlMerchandiseRepository extends JpaRepository<ControlMerchandise, Integer> {
}
