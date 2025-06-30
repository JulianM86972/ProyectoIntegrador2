package com.controlapp.ControlApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MateriaPrima {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String proveedor;
    private LocalDateTime fechaRecepcion;
    private String lote;
    private Integer litros;

    // Parámetros físico-químicos
    private Double grasa;
    private Double solidosNoGrasos;
    private Double densidad;
    private Double proteina;
    private Double lactosa;
    private Double temperatura;
    private Double puntoCongelacion;
    private Double ph;
    private Double conductividad;

    private Boolean aceptado;
    private String observaciones;
    private Boolean decisionManual;
}
