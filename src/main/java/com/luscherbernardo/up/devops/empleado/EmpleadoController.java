package com.luscherbernardo.up.devops.empleado;

import com.luscherbernardo.up.devops.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private final EmpleadoService empleadoService;


    public EmpleadoController( EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public List<Empleado> getAllEmpleados() {
        return empleadoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Empleado> getEmpleado(@PathVariable Long id) {
        return this.empleadoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Empleado createEmpleado(@RequestBody Empleado empleado) {
        return this.empleadoService.save(empleado);
    }

    @PutMapping("/{id}")
    public Empleado updateEmpleado(@PathVariable Long id, @RequestBody Empleado empleado) {
        Empleado empleadoExistente = empleadoService.findById(id).get();
        empleadoExistente.setNombre(empleado.getNombre());
        empleadoExistente.setEmail(empleado.getEmail());
        empleadoExistente.setPuesto(empleado.getPuesto());
        return this.empleadoService.save(empleadoExistente);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        try {
            empleadoService.findById(id);
            empleadoService.deleteById(id);
            return "Empleado borrado exitosamente";
        } catch (Exception e) {
            return "Empleado no encontrado";
        }
    }

}
