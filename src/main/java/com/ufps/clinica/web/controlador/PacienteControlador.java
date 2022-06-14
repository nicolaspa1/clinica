package com.ufps.clinica.web.controlador;

import com.ufps.clinica.domain.modelo.PacienteModelo;
import com.ufps.clinica.domain.servicio.interfaces.PacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/paciente")
public class PacienteControlador {

    //get -> listar todas las pacientes
    // post -> agregar una paciente
    // put -> actualizar paciente
    // delete -> eliminar paciente {id}
    @Autowired
    private PacienteServicio pacienteServicio;

    @GetMapping(value = "/buscarPorId/{id}")
    public ResponseEntity<? extends Map> obtenerPacientePorID(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            PacienteModelo p = pacienteServicio.obtenerPacientePorId(id);
            response.put("mensaje", "Paciente encontrado");
            response.put("paciente", p);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("mensaje", "Paciente no encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<? extends Object> obtenerPacientes() {
        List<PacienteModelo> pacientes = pacienteServicio.obtenerPacientes();
        return ResponseEntity.ok(pacientes);

    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<? extends Map> guardarPaciente(@RequestBody PacienteModelo pacienteModelo) {
        Map<String, Object> response = new HashMap<>();


        if (pacienteModelo != null) {
            PacienteModelo p = this.pacienteServicio.guardar(pacienteModelo);
            response.put("mensaje", "Paciente registrado de manera correcta");
            response.put("paciente", p);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            response.put("mensaje", "ha ocurrido un error al registrar el paciente");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<? extends Map> eliminarPaciente(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            pacienteServicio.eliminar(id);
            response.put("mensaje", "Se removio el paciente con id " + id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("mensaje", "No se removio el paciente con id " + id);
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);

        }

    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<? extends Map> actualizarPaciente(@RequestBody PacienteModelo pacienteModelo) {
        Map<String, Object> response = new HashMap<>();

        try {
            PacienteModelo m = pacienteServicio.actualizar(pacienteModelo);
            response.put("mensaje", "Se actualizo el paciente con id " + pacienteModelo.getIdPaciente());
            response.put("paciente", m);
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (Exception e) {
            response.put("mensaje", "No se actualizo el paciente con id " + pacienteModelo.getIdPaciente());
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);

        }

    }


}
