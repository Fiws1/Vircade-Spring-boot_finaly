package com.Proyect.Vircade.controller;

import com.Proyect.Vircade.modelo.*;
import com.Proyect.Vircade.service.CombustibleService;
import com.Proyect.Vircade.service.ConcesionarioService;
import com.Proyect.Vircade.service.Tipo_vehiculoService;
import com.Proyect.Vircade.service.VehiculoService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import static java.lang.System.out;

@Controller
@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @Autowired
    private Tipo_vehiculoService tipoVehiculoService;

    @Autowired
    private ConcesionarioService concesionario;

    @Autowired
    private CombustibleService combustible;

    @GetMapping("/Vehiculos")
    public String listarVehiculos(@RequestParam(defaultValue = "1") int page,
                                  @RequestParam(defaultValue = "10") int size, @NotNull Model modelo) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Vehiculo> paginaVehiculos = vehiculoService.listarVehiculos(pageable);

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("es", "CO")); // Para formato colombiano
        for (Vehiculo vehiculo : paginaVehiculos) {
            vehiculo.setPrecioFormateado(currencyFormat.format(vehiculo.getPrecio()));
        }

        Vehiculo vehiculo = new Vehiculo();
        List<Tipo_Vehiculo> listatipovehi = tipoVehiculoService.listarTodosLosTiposVehiculos();
        List<Concesionario> licon = concesionario.ListarConce();
        List<Combustible> licom = combustible.ListarCom();
        modelo.addAttribute("lisTip", listatipovehi);
        modelo.addAttribute("lisConce", licon);
        modelo.addAttribute("liscombu",licom);
        modelo.addAttribute("Vehiculo",vehiculo);
        modelo.addAttribute("i", "Vehiculos");

        modelo.addAttribute("Vehiculos", paginaVehiculos.getContent());
        modelo.addAttribute("currentPage", page);
        modelo.addAttribute("totalPages", paginaVehiculos.getTotalPages());

        return "view/vehiculo/vehiculo"; // nos retorna al archivo estudiantes
    }

    @PostMapping("/Vehiculosave")
    public String guardarVehiculos(Vehiculo Vehiculo,
                                   @NotNull Model modelo,
                                   @RequestParam("file") @NotNull MultipartFile imagen) {

        List<Tipo_Vehiculo> liistatipovehi = tipoVehiculoService.listarTodosLosTiposVehiculos();
        List<Concesionario> licon = concesionario.ListarConce();
        List<Combustible> licom = combustible.ListarCom();
        modelo.addAttribute("lisTip", liistatipovehi);
        modelo.addAttribute("lisConce", licon);
        modelo.addAttribute("liscombu",licom);
        modelo.addAttribute("Vehiculo",Vehiculo);
        modelo.addAttribute("i", "Vehiculos");

        if (!imagen.isEmpty()) {
            String nombreImagen = imagen.getOriginalFilename();
            Path directorioImagenes = Paths.get("src/main/resources/static/Images");
            String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();

            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "/" + nombreImagen);
                Files.write(rutaCompleta, bytesImg);

                Vehiculo.setImagen(nombreImagen);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        vehiculoService.guardarVe(Vehiculo);
        out.println("Vehiculo guardado con exito!");
        return "redirect:/Vehiculos";
    }

    @GetMapping("/Vehiculosedit/{id}")
    public String actualizarVehiculos(@PathVariable("id") int id, @NotNull Model modelo) {
        Vehiculo Vehiculo = vehiculoService.findByVehiculo(id);
        List<Tipo_Vehiculo> liistatipovehi = tipoVehiculoService.listarTodosLosTiposVehiculos();
        List<Concesionario> licon = concesionario.ListarConce();
        List<Combustible> licom = combustible.ListarCom();
        modelo.addAttribute("lisTip", liistatipovehi);
        modelo.addAttribute("lisConce", licon);
        modelo.addAttribute("liscombu",licom);
        modelo.addAttribute("Vehiculo",Vehiculo);
        modelo.addAttribute("i", "Vehiculos");
        out.println("Vehiculo modificada con exito!");
        return "view/Vehiculo/modificar";
    }

    @DeleteMapping("/Vehiculosde/{id}")
    public String eliminarVehiculos(@PathVariable("id") int id) {
        vehiculoService.eleminarVe(id);
        out.println("Vehiculo Eliminada con exito!");
        return "redirect:/Vehiculos";
    }
}