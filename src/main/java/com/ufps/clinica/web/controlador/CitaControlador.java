package com.ufps.clinica.web.controlador;

import com.ufps.clinica.domain.modelo.CitaModelo;
import com.ufps.clinica.domain.servicio.interfaces.CitaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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
    public ResponseEntity<? extends Map> obtenerCitaPorID(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            CitaModelo m = citaServicio.obtenerCitaPorId(id);
            response.put("mensaje", "Cita encontrada");
            response.put("cita", m);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("mensaje", "Cita no encontrada");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<? extends Object> obtenerPacientes() {
        List<CitaModelo> citas = citaServicio.obtenerCitas();
        return ResponseEntity.ok(citas);

    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<? extends Map> guardarCita(@RequestBody CitaModelo citaModelo) {
        Map<String, Object> response = new HashMap<>();


        if (citaModelo != null) {
            CitaModelo m = this.citaServicio.guardar(citaModelo);
            response.put("mensaje", "Cita registrada de manera correcta");
            response.put("cita", m);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            response.put("mensaje", "Ha ocurrido un error al registrar la cita");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<? extends Map> eliminarCita(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            citaServicio.eliminar(id);
            response.put("mensaje", "Se removio la cita con id " + id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("mensaje", "No se removio la cita con id " + id);
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);

        }

    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<? extends Map> actualizarCita(@RequestBody CitaModelo citaModelo) {
        Map<String, Object> response = new HashMap<>();

        try {
            CitaModelo m = citaServicio.actualizar(citaModelo);
            response.put("mensaje", "Se actualizo la cita con id " + citaModelo.getIdCita());
            response.put("cita", m);
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (Exception e) {
            response.put("mensaje", "No se actualizo la cita con id " + citaModelo.getIdCita());
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);

        }

    }


}
