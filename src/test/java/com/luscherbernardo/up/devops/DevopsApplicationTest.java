package com.luscherbernardo.up.devops;

import com.luscherbernardo.up.devops.empleado.Empleado;
import com.luscherbernardo.up.devops.empleado.EmpleadoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DataJpaTest
// do not replace the testcontainer data source
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
public class DevopsApplicationTest {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            "postgres:16"
    );

    @Test
    @Order(value = 1)
    void testConnectionToDatabase() {
        Assertions.assertNotNull(empleadoRepository);

    }

    @Test
    @Order(value = 2)
    void findall_debe_retornar_lista_empleados(){
        // Cuando
        List<Empleado> empleado = this.empleadoRepository.findAll();
        // Entonces
        assertEquals(4,empleado.size());
    }

    @Test
    @Order(value = 3)
    void findbyID_debe_retornar_empleado(){
        //Cuando
        Optional<Empleado> empleado = this.empleadoRepository.findById(2L);
        // Entonces
        assertTrue(empleado.isPresent());
    }

    @Test
    @Order(value = 4)
    void save_debe_retornar_nuevo_empleado() {
        // Given
        Empleado neuvoEmpleado = new Empleado();
        neuvoEmpleado.setNombre("TEST#");
        neuvoEmpleado.setEmail("@TEST.COM");
        neuvoEmpleado.setPuesto("PUESTO");
        // Cuando
        Empleado persistedEmployee = this.empleadoRepository.save(neuvoEmpleado);
        // Then
        assertNotNull(persistedEmployee);
        assertEquals("TEST#", persistedEmployee.getNombre());
    }

    @Test
    @Order(value = 5)
    void save_debe_actualizar_empleado(){
        // Dado
        Empleado existenteEmpleado = new Empleado();
        existenteEmpleado.setEmp_id(3L);
        existenteEmpleado.setNombre("UPDATE");
        existenteEmpleado.setEmail("@UPDATE.COM");
        existenteEmpleado.setPuesto("PUESTO_UPDATE");
        // Cuando
        Empleado updatedEmpleado = this.empleadoRepository.save(existenteEmpleado);
        // Entonces
        assertNotNull(updatedEmpleado);
        assertEquals("UPDATE", updatedEmpleado.getNombre());
        assertEquals("@UPDATE.COM", updatedEmpleado.getEmail());
        assertEquals("PUESTO_UPDATE", updatedEmpleado.getPuesto());
    }

    @Test
    void deleteByID_debe_retornar_empleado_borrado (){
        // Cuando
        this.empleadoRepository.deleteById(2L);
        Optional<Empleado> empleado = this.empleadoRepository.findById(2L);
        // Entonces
        assertFalse(empleado.isPresent());
    }



}
