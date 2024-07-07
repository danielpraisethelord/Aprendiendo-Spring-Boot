package com.example.SpringBoot.servicios;

import com.example.SpringBoot.models.Producto;
import com.example.SpringBoot.models.Rutas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * Clase que implementa la interfaz IOrderService.
 */
public class OrderService implements IOrderService {
    @Value("${misurls.database.test}")
    private String dataBaseURL;
    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    /**
     * Método para guardar una orden en la base de datos.
     *
     * @param producto Lista de productos a guardar.
     */
    public void saveOrder(List<Producto> producto) {
        System.out.println("Guardando en la BDD, la url de la BDD es: " + dataBaseURL);
        producto.forEach(producto1 -> logger.debug("el nombre del producto: {}", producto1.nombre));
    }
}
