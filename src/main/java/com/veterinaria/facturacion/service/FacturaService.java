package com.veterinaria.facturacion.service;

import com.veterinaria.facturacion.model.Factura;
import com.veterinaria.facturacion.repository.FacturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaService {
    private final FacturaRepository facturaRepository;

    public FacturaService(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    public List<Factura> obtenerFacturas() {
        return facturaRepository.obtenerTodas();
    }

    public Factura obtenerFactura(Long id) {
        return facturaRepository.obtenerPorId(id);
    }

    public Factura crearFactura(Factura factura) {
        return facturaRepository.agregarFactura(factura);
    }

    public boolean pagarFactura(Long id) {
        return facturaRepository.pagarFactura(id);
    }
}
