package com.ceiba.CeibaPeliculas.dominio.servicio.cliente;

import com.ceiba.CeibaPeliculas.dominio.modelo.Cliente;
import com.ceiba.CeibaPeliculas.dominio.repositorio.IRepositorioCliente;
import com.ceiba.CeibaPeliculas.infraestructura.mockFactory.ClienteFactory;
import com.ceiba.CeibaPeliculas.infraestructura.modelo.ClienteEntidad;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class GuardarClienteServicioTest {

    private GuardarClienteServicio spyGuardarClienteServicio;
    private IRepositorioCliente repositorioCliente;

    @Before
    public void before(){
        repositorioCliente = Mockito.mock(IRepositorioCliente.class);
        spyGuardarClienteServicio = Mockito.spy(new GuardarClienteServicio(repositorioCliente));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void guardarClienteTest() {
        Cliente cliente = new ClienteFactory().buildCliente();
        ClienteEntidad clienteEntidad = new ClienteFactory().buildClienteEntidad();

        Mockito.when(repositorioCliente.saveAndFlush(any(ClienteEntidad.class))).thenReturn(clienteEntidad);

        Cliente clienteCreado = spyGuardarClienteServicio.guardarCliente(cliente);

        assertEquals(cliente, clienteCreado);
        verify(repositorioCliente).saveAndFlush(any(ClienteEntidad.class));
    }

}
