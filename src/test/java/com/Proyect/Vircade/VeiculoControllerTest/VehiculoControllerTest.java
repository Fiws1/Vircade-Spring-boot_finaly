package com.Proyect.Vircade.VeiculoControllerTest;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.Proyect.Vircade.controller.VehiculoController;
import com.Proyect.Vircade.modelo.Vehiculo;
import com.Proyect.Vircade.service.CombustibleService;
import com.Proyect.Vircade.service.ConcesionarioService;
import com.Proyect.Vircade.service.Tipo_vehiculoService;
import com.Proyect.Vircade.service.VehiculoService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class VehiculoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private VehiculoService vehiculoService;

    @Mock
    private Tipo_vehiculoService tipoVehiculoService;

    @Mock
    private ConcesionarioService concesionarioService;

    @Mock
    private CombustibleService combustibleService;

    @InjectMocks
    private VehiculoController vehiculoController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(vehiculoController).build();
    }

    @Test
    void testListarVehiculos() throws Exception {
        List<Vehiculo> vehiculos = new ArrayList<>();
        Page<Vehiculo> page = new PageImpl<>(vehiculos);
        // Agregar vehículos de prueba a la lista
        when(vehiculoService.listarVehiculos(any())).thenReturn(page);
        when(tipoVehiculoService.listarTodosLosTiposVehiculos()).thenReturn(new ArrayList<>());
        when(concesionarioService.ListarConce()).thenReturn(new ArrayList<>());
        when(combustibleService.ListarCom()).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/Vehiculos"))
                .andExpect(status().isOk())
                .andExpect(view().name("view/vehiculo/vehiculo"))
                .andExpect(model().attributeExists("lisTip", "lisConce", "liscombu", "Vehiculo", "Vehiculos", "currentPage", "totalPages"));
    }

    @Test
    void testGuardarVehiculos() throws Exception {
        // Configura el vehículo según sea necesario

        mockMvc.perform(post("/Vehiculosave")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("nombre", "Vehículo de prueba") // Agrega los parámetros necesarios
                        .param("tipoCita", "Tipo de prueba")
                        .param("file", "imagen.jpg")) // Simula la carga de un archivo
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/Vehiculos"));

        verify(vehiculoService).guardarVe(any(Vehiculo.class)); // Verifica que se llame al servicio
    }
}
