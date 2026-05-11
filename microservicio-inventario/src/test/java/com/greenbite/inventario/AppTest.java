package com.greenbite.inventario;

import com.greenbite.inventario.model.Producto;
import com.greenbite.inventario.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class InventarioApplicationTests {

    @Autowired
    private ProductoRepository repository;

    @Test
    void buscarProductoPorNombreTest() {
        // 1. Guardar un producto de prueba usando el Builder de Lombok
        Producto tomate = Producto.builder()
                .nombre("Tomate Orgánico")
                .descripcion("Tomate de temporada cultivado sin pesticidas")
                .precio(new BigDecimal("1500.00"))
                .stock(50)
                .categoria("Verduras")
                .imagenUrl("https://ejemplo.com/tomate.jpg")
                .activo(true)
                .build();

        repository.save(tomate);

        // 2. Buscar por "tomate" (ignora mayúsculas/minúsculas)
        List<Producto> resultados = repository.findByNombreContainingIgnoreCase("tomate");

        // 3. Verificar que lo encontró
        assertTrue(resultados.size() > 0, "Debería encontrar al menos un producto");
        assertEquals("Tomate Orgánico", resultados.get(0).getNombre(), "El nombre debe coincidir");
    }
}