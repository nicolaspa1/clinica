package com.ufps.clinica.web.controlador;

import com.ufps.clinica.domain.modelo.CitaModelo;
import com.ufps.clinica.domain.servicio.interfaces.CitaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/cita")
public class CitaControlador {

    //get -> listar todas las citas
    // post -> agregar una cita
    // put -> actualizar cita
    // delete -> eliminar cita {id}
    @Autowired
    private CitaServicio citaServicio;

    @GetMapping(value = "/buscarPorId/{id}")
    public ResponseEntity<CitaModelo> obtenerCitaPorID(@PathVariable Long id){
        CitaModelo citaModelo = null;
        citaModelo = citaServicio.obtenerCitaPorId(id);
        return new ResponseEntity<>(citaModelo, HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<? extends Map> guardarCita(@RequestBody CitaModelo citaModelo){
        Map<String,Object> response = new HashMap<>();
        CitaModelo citaModelo1 = this.citaServicio.obtenerCitaPorId(citaModelo.getIdCita());
        if (citaModelo1 == null){
            this.citaServicio.guardar(citaModelo);
            response.put("mensaje","Cita creada de manera correcta");
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
        }else {
            response.put("mensaje","ha ocurrido un error al crear el usuario");
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping()
    public ResponseEntity<CitaModelo> eliminarCita(@PathVariable Long id){
        citaServicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<CitaModelo> actualizarCita(@RequestBody CitaModelo citaModelo){
        citaServicio.actualizar(citaModelo);
        return new ResponseEntity<>(citaModelo,HttpStatus.CREATED);
    }



}
