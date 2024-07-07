package com.example.SpringBoot.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Clase que representa los datos de un usuario.
 */
public class UserData {
    public String name;
    @JsonIgnore
    public int age;

    @JsonProperty("real_address")
    public String address;

    /**
     * Constructor de la clase UserData.
     *
     * @param name Nombre del usuario.
     * @param age Edad del usuario.
     * @param address Dirección del usuario.
     */
    public UserData(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    /*
    @JsonValue
    public String info() {
        return "Username is " + name + " and age is " + age + " and address is " + address;
    }
    */

    /**
     * Método que retorna información del usuario en formato personalizado.
     *
     * @return Información del usuario.
     */
    @JsonGetter("information")
    public String info2() {
        return "Username is " + name + " and age is " + age + " and address is " + address;
    }
}