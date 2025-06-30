package com.controlapp.ControlApp.service;

import com.controlapp.ControlApp.dto.MateriaPrimaDTO;
import com.controlapp.ControlApp.model.MateriaPrima;
import com.controlapp.ControlApp.repository.MateriaPrimaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

@Service
public class MateriaPrimaService {

    private final MateriaPrimaRepository repository;

    @Autowired
    public MateriaPrimaService(MateriaPrimaRepository repository) {
        this.repository = repository;
    }

    public MateriaPrima registrarMateriaPrima(MateriaPrimaDTO dto) {
        MateriaPrima materiaPrima = new MateriaPrima();


        materiaPrima.setProveedor(dto.getProveedor());
        materiaPrima.setLitros(dto.getLitros());
        materiaPrima.setFechaRecepcion(dto.getFechaRecepcion() != null ? dto.getFechaRecepcion() : LocalDateTime.now());
        materiaPrima.setLote(dto.getLote());

        
        materiaPrima.setGrasa(dto.getGrasa());
        materiaPrima.setSolidosNoGrasos(dto.getSolidosNoGrasos());
        materiaPrima.setDensidad(dto.getDensidad());
        materiaPrima.setProteina(dto.getProteina());
        materiaPrima.setLactosa(dto.getLactosa());
        materiaPrima.setTemperatura(dto.getTemperatura());
        materiaPrima.setPuntoCongelacion(dto.getPuntoCongelacion());
        materiaPrima.setPh(dto.getPh());
        materiaPrima.setConductividad(dto.getConductividad());

        boolean aceptado = evaluarCalidad(dto);
        materiaPrima.setAceptado(aceptado);

        materiaPrima.setObservaciones(dto.getObservaciones());
        materiaPrima.setDecisionManual(dto.getDecisionManual() != null && dto.getDecisionManual());

        return repository.save(materiaPrima);
    }

    private boolean evaluarCalidad(MateriaPrimaDTO dto) {

        return dto.getGrasa() >= 3.0 && dto.getGrasa() <= 5.0 &&  // Este valor se da en % de grasa
                dto.getSolidosNoGrasos() >= 8.0 && dto.getSolidosNoGrasos() <= 9.0 &&
                dto.getDensidad() >= 1.028 && dto.getDensidad() <= 1.034 &&
                dto.getProteina() >= 2.8 && dto.getProteina() <= 3.5 &&
                dto.getLactosa() >= 4.4 && dto.getLactosa() <= 4.9 &&
                dto.getTemperatura() <= 6.0 &&
                dto.getPuntoCongelacion() <= -0.512 &&
                dto.getPh() >= 6.6 && dto.getPh() <= 6.8 &&
                dto.getConductividad() >= 4.0 && dto.getConductividad() <= 5.5;
    }

    public List<MateriaPrima> obtenerTodas() {
        return repository.findAll();
    }

    public MateriaPrima obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Materia prima no encontrada con id: " + id));
    }


    public MateriaPrima actualizarMateriaPrima(Long id, MateriaPrimaDTO dto) {
        MateriaPrima existente = obtenerPorId(id);


        existente.setProveedor(dto.getProveedor());
        existente.setLote(dto.getLote());
        existente.setGrasa(dto.getGrasa());
        existente.setSolidosNoGrasos(dto.getSolidosNoGrasos());
        existente.setDensidad(dto.getDensidad());
        existente.setProteina(dto.getProteina());
        existente.setLactosa(dto.getLactosa());
        existente.setTemperatura(dto.getTemperatura());
        existente.setPuntoCongelacion(dto.getPuntoCongelacion());
        existente.setPh(dto.getPh());
        existente.setConductividad(dto.getConductividad());



        if (!Boolean.TRUE.equals(existente.getDecisionManual())) {
            existente.setAceptado(evaluarCalidad(dto));
        }

        return repository.save(existente);
    }

    public void eliminarMateriaPrima(Long id) {
        repository.deleteById(id);
    }
}
