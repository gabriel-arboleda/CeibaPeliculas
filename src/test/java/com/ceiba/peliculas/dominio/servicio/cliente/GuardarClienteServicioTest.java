package com.ceiba.peliculas.dominio.servicio.cliente;

import com.ceiba.peliculas.dominio.modelo.Cliente;
import com.ceiba.peliculas.dominio.repositorio.IRepositorioCliente;
import com.ceiba.peliculas.infraestructura.mockFactory.ClienteFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
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

        Mockito.when(repositorioCliente.guardarCliente(any(Cliente.class))).thenReturn(cliente);

        Cliente clienteCreado = spyGuardarClienteServicio.guardarCliente(cliente);

        assertEquals(cliente, clienteCreado);
        verify(repositorioCliente).guardarCliente(any(Cliente.class));
    }

}
