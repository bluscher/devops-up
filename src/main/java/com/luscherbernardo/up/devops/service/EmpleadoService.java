package com.luscherbernardo.up.devops.service;

import com.luscherbernardo.up.devops.empleado.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {
    List<Empleado> findAll();

    Optional<Empleado> findById(Long id);

    Empleado save(Empleado emp);

    void deleteById(Long id);
}
