package com.example.SpringBoot.myBeans;

import com.example.SpringBoot.models.Producto;
import com.example.SpringBoot.servicios.IOrderService;
import com.example.SpringBoot.servicios.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Clase de configuración que define beans personalizados.
 */
@Configuration
public class MisPrimerosBeans {

    /**
     * Define un bean de tipo MiBean.
     *
     * @return Una instancia de MiBean.
     */
    @Bean
    public MiBean crearMiBean() {
        return new MiBean();
    }

    /**
     * Define un bean de tipo IOrderService.
     *
     * @return Una instancia de IOrderService.
     */
    @Bean
    public IOrderService instanciarOrderService() {
        boolean esProduccion = true;
        if (esProduccion) {
            return new OrderService();
        } else {
            return new IOrderService() {
                @Override
                public void saveOrder(List<Producto> productos) {
                    System.out.println("Guardando en BDD dummy (local)");
                }
            };
        }
    }
}
