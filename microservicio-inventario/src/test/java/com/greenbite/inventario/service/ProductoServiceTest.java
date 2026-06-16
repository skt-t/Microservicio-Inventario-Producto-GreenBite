package com.greenbite.inventario.service;

import com.greenbite.inventario.model.Producto;
import com.greenbite.inventario.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductoServiceTest {

    @Mock
    private ProductoRepository repository;

    @InjectMocks
    private ProductoService service;

    @Test
    void buscarPorNombre_DebeRetornarListaDeProductos() {
        Producto p1 = Producto.builder().id(1L).nombre("Tomate perita").precio(new BigDecimal("1200.00")).stock(100).activo(true).build();
        when(repository.findByNombreContainingIgnoreCase("Tomate")).thenReturn(Arrays.asList(p1));
        
        List<Producto> resultado = service.buscarPorNombre("Tomate");
        
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("Tomate perita", resultado.get(0).getNombre());
        verify(repository, times(1)).findByNombreContainingIgnoreCase("Tomate");
    }

    @Test
    void guardarProducto_DebeRetornarProductoConId() {
        Producto nuevoProducto = Producto.builder().nombre("Palta").precio(new BigDecimal("2000.00")).stock(50).build();
        Producto productoGuardado = Producto.builder().id(2L).nombre("Palta").precio(new BigDecimal("2000.00")).stock(50).build();
        when(repository.save(any(Producto.class))).thenReturn(productoGuardado);
        
        Producto resultado = service.guardarProducto(nuevoProducto);
        
        assertNotNull(resultado);
        assertEquals(2L, resultado.getId());
        assertEquals("Palta", resultado.getNombre());
        verify(repository, times(1)).save(nuevoProducto);
    }

    @Test
    void listarTodos_DebeRetornarTodosLosProductos() {
        Producto p1 = Producto.builder().id(1L).nombre("Tomate").build();
        Producto p2 = Producto.builder().id(2L).nombre("Palta").build();
        when(repository.findAll()).thenReturn(Arrays.asList(p1, p2));
        
        List<Producto> resultado = service.listarTodos();
        
        assertEquals(2, resultado.size());
        verify(repository, times(1)).findAll();
    }
}
