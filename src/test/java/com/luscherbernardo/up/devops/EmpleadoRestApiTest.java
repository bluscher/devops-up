package com.luscherbernardo.up.devops;

import com.luscherbernardo.up.devops.empleado.EmpleadoController;
import com.luscherbernardo.up.devops.empleado.EmpleadoRepository;
import com.luscherbernardo.up.devops.service.EmpleadoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmpleadoController.class)
public class EmpleadoRestApiTest {

    @MockBean
    private EmpleadoService empleadoService;
    @MockBean
    private EmpleadoRepository empleadoRepository;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void debe_retornar_lista_empleado() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/empleados")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
