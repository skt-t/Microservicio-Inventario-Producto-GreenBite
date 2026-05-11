package com.greenbite.inventario.service;

import com.greenbite.inventario.model.Producto;
import com.greenbite.inventario.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service 
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> buscarPorNombre(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }

    public Producto guardarProducto(Producto producto) {
        return repository.save(producto);
    }

    // AGREGA ESTO: Lógica para devolver todo el catálogo
    public List<Producto> listarTodos() {
        return repository.findAll(); // findAll() ya viene regalado por JpaRepository
    }
}