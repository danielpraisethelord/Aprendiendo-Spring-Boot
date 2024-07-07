package com.example.SpringBoot.models;

import com.example.SpringBoot.myBeans.MiBean;
import com.example.SpringBoot.myBeans.MiComponente;
import com.example.SpringBoot.servicios.IOrderService;
import com.example.SpringBoot.servicios.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Clase que define las rutas (endpoints) de la aplicación.
 * Utiliza la anotación @RestController para indicar que esta clase es un controlador REST.
 */
@RestController
public class Rutas {

    //private OrderService orderService2 = new OrderService();
    private final IOrderService orderService;
    private final MiBean miBean;
    private final MiComponente miComponente;

    /**
     * Constructor de la clase Rutas, utiliza la anotación @Autowired para inyectar dependencias.
     *
     * @param orderService Servicio para gestionar órdenes.
     * @param miBean Bean personalizado.
     * @param miComponente Componente personalizado.
     */
    @Autowired
    public Rutas(IOrderService orderService, MiBean miBean, MiComponente miComponente) {
        this.orderService = orderService;
        this.miBean = miBean;
        this.miComponente = miComponente;
    }

    private final Logger logger = LoggerFactory.getLogger(Rutas.class);

    /**
     * Ruta para saludar al mundo.
     *
     * @return Un mensaje de saludo.
     */
    @GetMapping("/hola")
    String miPrimeraRuta() {
        return "Hola mundo desde Spring Controller :)";
    }

    /**
     * Ruta para leer información de un libro según su ID y editorial.
     *
     * @param id ID del libro.
     * @param editorial Editorial del libro.
     * @return Un mensaje con los detalles del libro.
     */
    @GetMapping("/libro/{id}/editorial/{editorial}")
    String leerLibro(@PathVariable int id, @PathVariable String editorial) {
        return "Leyendo el libro id: " + id + ", editorial: " + editorial;
    }

    /**
     * Ruta para leer información de un libro según su ID y parámetros adicionales.
     *
     * @param id ID del libro.
     * @param params Parámetros adicionales.
     * @return Un mensaje con los detalles del libro.
     */
    @GetMapping("/libro2/{id}")
    String leerLibro2(@PathVariable int id, @RequestParam String params) {
        return "Leyendo el libro id: " + ", params: " + params;
    }

    /**
     * Ruta para guardar un libro.
     *
     * @param libro Información del libro en formato JSON.
     * @return Un mensaje de confirmación.
     */
    @PostMapping("/libro")
    String guardarLibro(@RequestBody Map<String, Object> libro) {
        libro.keySet().forEach(llave -> {
            logger.debug("llave {} valor {}", llave, libro.get(llave));
        });

        return "Libro guardado";
    }

    /**
     * Ruta para guardar un libro utilizando un objeto Libro.
     *
     * @param libro Objeto Libro.
     * @return Un mensaje de confirmación.
     */
    @PostMapping("/librotres")
    String guardarLibro2(@RequestBody Libro libro) {
        logger.debug("libro {} editorial {}", libro.nombre, libro.editorial);

        return "Libro guardado";
    }

    /**
     * Ruta para saludar con un estado HTTP aceptado.
     *
     * @return Un mensaje de saludo.
     */
    @GetMapping("/saludar")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    String miSegundaRutaConStatus() {
        return "Apreniendo status http en Spring Boot";
    }

    /**
     * Ruta para saludar con un estado HTTP movido permanentemente.
     *
     * @return Un mensaje de saludo.
     */
    @GetMapping("/saludar2")
    @ResponseStatus(value = HttpStatus.MOVED_PERMANENTLY, reason = "Fue movida a la version 2.0.0 de la API")
    String miTercerRutaConStatus() {
        return "Aprendiendo status http en Spring boot";
    }

    /**
     * Ruta para obtener animales según el lugar.
     *
     * @param lugar Lugar de los animales.
     * @return Una lista de animales o un mensaje de error.
     */
    @GetMapping("/animales/{lugar}")
    public ResponseEntity<String> getAnimales(@PathVariable String lugar) {
        if (lugar.equals("granja")) {
            return ResponseEntity.status(HttpStatus.OK).body("Caballo, vaca, oveja, gallina");
        } else if (lugar.equals("selva")) {
            return ResponseEntity.status(HttpStatus.OK).body("Mono, gorila, puma, tigre");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Lugar no valido");
        }
    }

    /**
     * Ruta para realizar un cálculo que lanza una excepción.
     *
     * @param numero Número para el cálculo.
     * @return Siempre lanza una excepción.
     */
    @GetMapping("/calcular/{numero}")
    public int getCalculo(@PathVariable int numero) {
        throw new NullPointerException("la clave del usuario es password123 y no debería leerse en postman");
    }

    /**
     * Ruta para obtener datos de usuario en formato JSON.
     *
     * @return Datos del usuario.
     */
    @GetMapping("/userData")
    public ResponseEntity<String> getUserData() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body("{\"name\": \"mary\"}");
    }

    /**
     * Ruta para obtener datos de usuario en un mapa.
     *
     * @return Datos del usuario.
     */
    @GetMapping("/userData/v2")
    public Map<String, Map<String, Object>> getUserDataV2() {
        return Map.of("user", Map.of("name", "mary", "age", 25));
    }

    /**
     * Ruta para obtener datos de usuario en un objeto UserData.
     *
     * @return Objeto UserData con los datos del usuario.
     */
    @GetMapping("userData/v3")
    public UserData getUserDatav3() {
        return new UserData("mary", 25, "México");
    }

    /**
     * Ruta para crear una orden.
     *
     * @param products Lista de productos.
     * @return Un mensaje de confirmación.
     */
    @PostMapping("/order")
    public String crearOrden(@RequestBody List<Producto> products) {
        orderService.saveOrder(products);
        return "Productos guardados";
    }

    /**
     * Ruta para saludar desde un bean.
     *
     * @return Un mensaje de confirmación.
     */
    @GetMapping("/mibean")
    public String saludarDesdeBean() {
        miBean.saludar();
        return "Completado";
    }

    /**
     * Ruta para saludar desde un componente.
     *
     * @return Un mensaje de confirmación.
     */
    @GetMapping("/micomponente")
    public String saludarDesdeComponente() {
        miComponente.saludarDesdeComponente();
        return "Completado";
    }
}