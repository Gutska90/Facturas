package com.veterinaria.facturacion.controller;

import com.veterinaria.facturacion.model.Factura;
import com.veterinaria.facturacion.service.FacturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturas")
public class FacturaController {
    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping
    public ResponseEntity<List<Factura>> obtenerFacturas() {
        return ResponseEntity.ok(facturaService.obtenerFacturas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> obtenerFactura(@PathVariable Long id) {
        Factura factura = facturaService.obtenerFactura(id);
        return factura != null ? ResponseEntity.ok(factura) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Factura> crearFactura(@RequestBody Factura factura) {
        return ResponseEntity.ok(facturaService.crearFactura(factura));
    }

    @PostMapping("/{id}/pagar")
    public ResponseEntity<String> pagarFactura(@PathVariable Long id) {
        return facturaService.pagarFactura(id)
                ? ResponseEntity.ok("Factura pagada exitosamente")
                : ResponseEntity.badRequest().body("No se pudo pagar la factura");
    }
}
