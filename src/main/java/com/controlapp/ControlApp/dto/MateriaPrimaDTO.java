package com.controlapp.ControlApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MateriaPrimaDTO {
    private String proveedor;
    private LocalDateTime fechaRecepcion;
    private String lote;
    private Integer litros;

    private Double grasa;
    private Double solidosNoGrasos;
    private Double densidad;
    private Double proteina;
    private Double lactosa;
    private Double temperatura;
    private Double puntoCongelacion;
    private Double ph;
    private Double conductividad;

    private String observaciones;
    private Boolean decisionManual;
}
