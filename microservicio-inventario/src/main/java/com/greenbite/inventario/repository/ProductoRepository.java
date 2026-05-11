package com.greenbite.inventario.repository;

import com.greenbite.inventario.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // ¡Esta es la consulta clave para tu requerimiento!
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
}