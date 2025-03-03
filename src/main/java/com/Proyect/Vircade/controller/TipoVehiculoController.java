package com.Proyect.Vircade.controller;

import com.Proyect.Vircade.modelo.Tipo_Vehiculo;
import com.Proyect.Vircade.service.Tipo_vehiculoService;
import com.Proyect.Vircade.service.TipovehiculoServicio;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.System.*;

@Controller
@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
public class TipoVehiculoController {

    @Autowired
    private Tipo_vehiculoService tipoVehiculoService;

    @Autowired
    private TipovehiculoServicio servicio;

    @GetMapping("/tipovehiculos")
    public String listartipovehiculos(@NotNull Model modelo) {
        List<Tipo_Vehiculo> listadotipoVehiculos = tipoVehiculoService.listarTodosLosTiposVehiculos();
        Tipo_Vehiculo tipo_vehiculo = new Tipo_Vehiculo();
        modelo.addAttribute("tipo_vehiculo",tipo_vehiculo);
        modelo.addAttribute("i", "Lista de Tipos de vehiculos");
        modelo.addAttribute("tipovehiculos", listadotipoVehiculos);
        return "view/tipoVehiculo/tipoVehiculo"; // nos retorna al archivo estudiantes
    }

    @PostMapping("/tipoVehiculosave")
    public String guardartipovehiculos(Tipo_Vehiculo tipo_vehiculo, @NotNull Model modelo) {
        servicio.guardarTiposVehiculos(tipo_vehiculo);
        modelo.addAttribute("tipo_vehiculo",tipo_vehiculo );
        out.println("Tipo de vehiculo guardado con exito!");
        return "redirect:/tipovehiculos";
    }

    @GetMapping("/tipovehiculosedit/{id}")
    public String actualizartipovehiculos(@PathVariable("id") int id, @NotNull Model modelo) {
        Tipo_Vehiculo tipo_vehiculo = servicio.obtenerTiposVehiculosPorId(id);
        modelo.addAttribute("tipo_vehiculo",tipo_vehiculo );
        out.println("Tipo de vehiculo se a modificado con exito!");
        return "/view/tipoVehiculo/modificar";
    }

    @DeleteMapping("/tipovehiculosde/{id}")
    public String eliminartipovehiculos(@PathVariable("id") int id) {
        servicio.eliminarTiposVehiculos(id);
        out.println("Tipo de vehiculo Eliminado con exito!");
        return "redirect:/tipovehiculos";
    }
}