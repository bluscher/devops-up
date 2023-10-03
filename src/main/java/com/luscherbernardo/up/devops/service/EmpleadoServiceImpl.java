package com.luscherbernardo.up.devops.service;

import com.luscherbernardo.up.devops.empleado.Empleado;
import com.luscherbernardo.up.devops.empleado.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{
    private final EmpleadoRepository empleadoRepository;
    EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public List<Empleado> findAll() {
        return this.empleadoRepository.findAll();
    }

    @Override
    public Optional<Empleado> findById(Long id) {
        return this.empleadoRepository.findById(id);
    }
    @Override
    public Empleado save(Empleado emp) {
        return this.empleadoRepository.save(emp);
    }

    @Override
    public void deleteById(Long id) {
        this.empleadoRepository.deleteById(id);
    }
}
