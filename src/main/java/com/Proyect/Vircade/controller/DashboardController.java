package com.Proyect.Vircade.controller;

import com.Proyect.Vircade.modelo.Concesionario;
import com.Proyect.Vircade.modelo.Tipo_Vehiculo;
import com.Proyect.Vircade.modelo.Vehiculo;
import com.Proyect.Vircade.service.CombustibleService;
import com.Proyect.Vircade.service.ConcesionarioService;
import com.Proyect.Vircade.service.TipovehiculoServicio;
import com.Proyect.Vircade.service.VehiculoService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

@Controller
public class DashboardController {

    @Autowired
    VehiculoService vehiculoService;

    @Autowired
    TipovehiculoServicio tipovehiculoService;

    @Autowired
    ConcesionarioService concesionarioService;

    @Autowired
    CombustibleService combustibleService;

    @GetMapping("/VehiculosDash")
    public String detalleVehiculo(@NotNull Model modelo) {
        List<Vehiculo> paginaVehiculos = vehiculoService.listarTodosLosTiposVehiculos();

        Vehiculo vehiculo = new Vehiculo();
        List<Tipo_Vehiculo> listatipovehi = tipovehiculoService.listarTodosLosTiposVehiculos();
        List<Concesionario> licon = concesionarioService.ListarConce();
        modelo.addAttribute("lisTip", listatipovehi);
        modelo.addAttribute("lisConce", licon);
        modelo.addAttribute("vehiculo",vehiculo);
        modelo.addAttribute("i", "Vehiculos");

        modelo.addAttribute("vehiculos", paginaVehiculos);

        return "view/Vehiculo/Vehiculo"; // nos retorna al archivo estudiantes
    }

    @GetMapping("/detalle")
    public String dertalle_vehiculos(@NotNull Model modelo) {
        List<Vehiculo> vehiculos = vehiculoService.listarTodosLosTiposVehiculos(); // Asegúrate de que este metodo devuelva todos los vehículos

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("es", "CO")); // Para formato colombiano
        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.setPrecioFormateado(currencyFormat.format(vehiculo.getPrecio()));
        }

        modelo.addAttribute("detalle", vehiculos); // Cambia "detalle" por el nombre que usarás en la vista
        modelo.addAttribute("titulo", "Nuevo vehiculo");
        return "view/Vehiculo/detalle";
    }
}
