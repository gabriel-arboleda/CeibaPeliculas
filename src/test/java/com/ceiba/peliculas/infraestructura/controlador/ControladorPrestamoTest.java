package com.ceiba.peliculas.infraestructura.controlador;

import com.ceiba.peliculas.aplicacion.comando.ComandoCliente;
import com.ceiba.peliculas.aplicacion.comando.ComandoPrestamo;
import com.ceiba.peliculas.infraestructura.mockFactory.ClienteFactory;
import com.ceiba.peliculas.infraestructura.mockFactory.PrestamoFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration
@TestPropertySource("/test-application.properties")
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
@Sql(scripts = {"classpath:data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class ControladorPrestamoTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void consultaPrestamoPorCliente() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/prestamo/{docIdentidad}", 123)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].idPrestamo").value(1));
    }

    @Test
    public void guardarPrestamo() throws Exception {
        ComandoPrestamo comandoPrestamo = new PrestamoFactory().buildComando();
        mockMvc.perform(MockMvcRequestBuilders
                .post("/prestamo")
                .content(objectMapper.writeValueAsString(comandoPrestamo))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        mockMvc.perform(MockMvcRequestBuilders
                .get("/prestamo/{docIdentidad}",321)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].idPrestamo").value(2));
    }

    @Test
    public void eliminarPrestamo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/prestamo/{idPrestamo}", 1))
                .andExpect(status().isOk());
    }
}
