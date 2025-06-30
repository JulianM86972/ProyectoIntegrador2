package com.controlapp.ControlApp.repository;

import com.controlapp.ControlApp.model.MateriaPrima;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.time.LocalDateTime;

public interface MateriaPrimaRepository extends JpaRepository<MateriaPrima, Long> {

}
