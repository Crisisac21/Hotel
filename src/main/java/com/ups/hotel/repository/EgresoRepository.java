package com.ups.hotel.repository;

import com.ups.hotel.entity.Egreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EgresoRepository extends JpaRepository<Egreso, Long> {
}
