package com.example.SpringBoot.servicios;

import com.example.SpringBoot.models.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Interfaz que define el contrato para los servicios de órdenes.
 * Utiliza la anotación @Service para indicar que es un servicio gestionado por Spring.
 */
@Service
public interface IOrderService {
    /**
     * Método para guardar una orden.
     *
     * @param productos Lista de productos a guardar.
     */
    public void saveOrder(List<Producto> productos);
}
