package com.controlapp.ControlApp.controller;

import com.controlapp.ControlApp.dto.MateriaPrimaDTO;
import com.controlapp.ControlApp.model.MateriaPrima;
import com.controlapp.ControlApp.service.MateriaPrimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/materia-prima")
public class MateriaPrimaController {

    private final MateriaPrimaService service;

    @Autowired
    public MateriaPrimaController(MateriaPrimaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MateriaPrima> registrarMateriaPrima(@RequestBody MateriaPrimaDTO dto) {
        MateriaPrima nuevaMateriaPrima = service.registrarMateriaPrima(dto);
        return ResponseEntity.ok(nuevaMateriaPrima);
    }

    @GetMapping
    public ResponseEntity<List<MateriaPrima>> obtenerTodasLasMateriasPrimas() {
        List<MateriaPrima> materiasPrimas = service.obtenerTodas();
        return ResponseEntity.ok(materiasPrimas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MateriaPrima> obtenerMateriaPrimaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<MateriaPrima> actualizarMateriaPrima(
            @PathVariable Long id,
            @RequestBody MateriaPrimaDTO dto) {

        return ResponseEntity.ok(service.actualizarMateriaPrima(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMateriaPrima(@PathVariable Long id) {
        service.eliminarMateriaPrima(id);
        return ResponseEntity.noContent().build();
    }
}
