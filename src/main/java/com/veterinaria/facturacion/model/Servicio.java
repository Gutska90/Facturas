package com.veterinaria.facturacion.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Servicio {
    private String nombre;
    private double precio;
}