package com.guerrero.pedido.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tallas") // nombre de la tabla en la BD
public class Talla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String nombre; // Ej: Maria Torres

    @Column(length = 50, nullable = false)
    private String relacion; // Hermana, amigo, papá

    @Column(length = 50, nullable = false)
    private String prenda; // Zapatos, pantalón, polo

    @Column(length = 10, nullable = false)
    private String talla; // 30, 32, M, L

    @Column(length = 255)
    private String notas; // opcional

    @Column(nullable = false)
    private Boolean activo; // true o false
}
