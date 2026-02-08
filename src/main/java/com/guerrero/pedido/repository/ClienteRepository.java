package com.guerrero.pedido.repository;

import com.guerrero.pedido.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    // Si luego quieres búsquedas, aquí van
}
