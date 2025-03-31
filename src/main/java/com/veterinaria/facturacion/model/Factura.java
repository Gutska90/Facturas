package com.veterinaria.facturacion.model;

import lombok.Data;

import java.util.List;

@Data
public class Factura {
    private Long id;
    private String cliente;
    private String rut;
    private List<Servicio> servicios;
    private double total;
    private boolean pagado;

    public Factura(Long id, String cliente, String rut, List<Servicio> servicios) {
        this.id = id;
        this.cliente = cliente;
        this.rut = rut;
        this.servicios = servicios;
        this.total = calcularTotal();
        this.pagado = false;
    }

    private double calcularTotal() {
        double subtotal = servicios.stream().mapToDouble(Servicio::getPrecio).sum();
        return subtotal * 1.19; // Aplicando IVA del 19%
    }
}
