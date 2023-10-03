package com.luscherbernardo.up.devops;

import com.luscherbernardo.up.devops.empleado.Empleado;
import com.luscherbernardo.up.devops.empleado.EmpleadoRepository;
import com.luscherbernardo.up.devops.service.EmpleadoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmpleadoServiceTest {
    @Mock
    private EmpleadoRepository empleadoRepository;

    @InjectMocks
    private EmpleadoServiceImpl empleadoService;

    @Test
    void findALL_debe_retornar_list_empleado() {
        // DADO
        Empleado empleado = new Empleado();
        // Cuando
        when(empleadoRepository.findAll()).thenReturn(List.of(empleado));
        List<Empleado> empleados = this.empleadoService.findAll();
        // Entonces
        assertEquals(1,empleados.size());
        verify(this.empleadoRepository).findAll();
    }

    @Test
    void save_debe_retornar_empleado(){
        // DADO
        Empleado empleado = new Empleado();
        // Cuando
        this.empleadoService.save(empleado);
        // Entonces
        verify(this.empleadoRepository).save(empleado);
    }
}
