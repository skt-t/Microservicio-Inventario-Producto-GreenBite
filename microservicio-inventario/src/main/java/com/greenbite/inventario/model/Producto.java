package com.greenbite.inventario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    // BigDecimal es vital aquí, no usen Double para dinero
    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "imagen_url") 
    private String imagenUrl;

    @Column(name = "activo", nullable = false)
    @Builder.Default 
    private Boolean activo = true;
}