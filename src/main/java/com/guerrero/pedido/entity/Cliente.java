package com.guerrero.pedido.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes") // Nombre de la tabla
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  // Usamos Integer para int autoincremental

    @Column(name = "razon_social", length = 100, nullable = false)
    private String razonSocial;

    @Column(length = 15, nullable = true)
    private String documento;

    @Column(length = 70, nullable = true)
    private String direccion;

    @Column(length = 15, nullable = true)
    private String telefono;
}
