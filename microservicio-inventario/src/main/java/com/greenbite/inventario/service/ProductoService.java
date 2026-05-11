package com.greenbite.inventario.service;

import com.greenbite.inventario.model.Producto;
import com.greenbite.inventario.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // ¡Esta anotación es clave para Spring!
public class ProductoService {

    private final ProductoRepository repository;

    // Inyección de dependencias
    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    // Lógica para buscar
    public List<Producto> buscarPorNombre(String nombre) {
        // Aquí podrías agregar validaciones extra en el futuro (ej. si el nombre está vacío)
        return repository.findByNombreContainingIgnoreCase(nombre);
    }

    // Lógica para guardar
    public Producto guardarProducto(Producto producto) {
        // Podrías validar que el precio no sea negativo antes de guardar
        return repository.save(producto);
    }
}