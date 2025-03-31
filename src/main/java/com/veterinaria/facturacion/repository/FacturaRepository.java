package com.veterinaria.facturacion.repository;

import com.veterinaria.facturacion.model.Factura;
import com.veterinaria.facturacion.model.Servicio;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class FacturaRepository {
    private final List<Factura> facturas = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public FacturaRepository() {
        // Cargar datos iniciales
        facturas.add(new Factura(idGenerator.getAndIncrement(), "Tulio Triviño", "12345678-9",
                List.of(new Servicio("Consulta General", 15000), new Servicio("Vacunación", 12000))));

        facturas.add(new Factura(idGenerator.getAndIncrement(), "Juanin Juan Harry", "98765432-1",
                List.of(new Servicio("Cirugía menor", 45000))));

        facturas.add(new Factura(idGenerator.getAndIncrement(), "Mario Hugo", "934565432-1",
                List.of(new Servicio("Cirugía mayor", 90000))));        
    }

    public List<Factura> obtenerTodas() {
        return facturas;
    }

    public Factura obtenerPorId(Long id) {
        return facturas.stream().filter(f -> f.getId().equals(id)).findFirst().orElse(null);
    }

    public Factura agregarFactura(Factura factura) {
        factura.setId(idGenerator.getAndIncrement());
        factura.setTotal(factura.getTotal());
        factura.setPagado(false);
        facturas.add(factura);
        return factura;
    }

    public boolean pagarFactura(Long id) {
        Factura factura = obtenerPorId(id);
        if (factura != null && !factura.isPagado()) {
            factura.setPagado(true);
            return true;
        }
        return false;
    }
}
