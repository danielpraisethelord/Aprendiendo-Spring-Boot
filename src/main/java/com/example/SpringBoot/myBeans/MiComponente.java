package com.example.SpringBoot.myBeans;

import org.springframework.stereotype.Component;

/**
 * Clase que representa un componente personalizado.
 * Utiliza la anotación @Component para indicar que es un componente gestionado por Spring.
 */
@Component
public class MiComponente {
    /**
     * Método que imprime un saludo en la consola.
     */
    public void saludarDesdeComponente() {
        System.out.println("Saludando desde mi primer componente");
    }
}