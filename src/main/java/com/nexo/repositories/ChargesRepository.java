package com.nexo.repositories;

import com.nexo.models.Charges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargesRepository extends JpaRepository<Charges, Integer> {
}
