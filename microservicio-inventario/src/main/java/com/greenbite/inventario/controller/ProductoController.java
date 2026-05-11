package com.greenbite.inventario.controller;

import com.greenbite.inventario.model.Producto;
import com.greenbite.inventario.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    // Ahora nos comunicamos con el Servicio, NO con el Repositorio
    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping("/buscar")
    public List<Producto> buscarProducto(@RequestParam String nombre) {
        return service.buscarPorNombre(nombre);
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return service.guardarProducto(producto);
    }
}