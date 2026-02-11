package com.guerrero.pedido.repository;

import com.guerrero.pedido.entity.Talla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TallaRepository extends JpaRepository<Talla, Integer> {
    // aquí puedes agregar consultas si luego las necesitas
}
