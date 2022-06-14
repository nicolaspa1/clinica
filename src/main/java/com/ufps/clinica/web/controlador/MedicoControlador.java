package com.ufps.clinica.web.controlador;

import com.ufps.clinica.domain.modelo.MedicoModelo;
import com.ufps.clinica.domain.modelo.PacienteModelo;
import com.ufps.clinica.domain.servicio.interfaces.MedicoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/medico")
public class MedicoControlador {

    //get -> listar todas las medicos
    // post -> agregar una medico
    // put -> actualizar medico
    // delete -> eliminar medico {id}
    @Autowired
    private MedicoServicio medicoServicio;

    @GetMapping(value = "/buscarPorId/{id}")
    public ResponseEntity<? extends Map> obtenerMedicoPorID(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            MedicoModelo m = medicoServicio.obtenerMedicoPorId(id);
            response.put("mensaje", "Medico encontrado");
            response.put("medico", m);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("mensaje", "Medico no encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<? extends Object> obtenerPacientes() {
        List<MedicoModelo> medicos = medicoServicio.obtenerMedicos();
        return ResponseEntity.ok(medicos);

    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<? extends Map> guardarMedico(@RequestBody MedicoModelo medicoModelo) {
        Map<String, Object> response = new HashMap<>();


        if (medicoModelo != null) {
            MedicoModelo m = this.medicoServicio.guardar(medicoModelo);
            response.put("mensaje", "Medico registrado de manera correcta");
            response.put("medico", m);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            response.put("mensaje", "ha ocurrido un error al registrar el medico");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<? extends Map> eliminarMedico(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            medicoServicio.eliminar(id);
            response.put("mensaje", "Se removio el medico con id " + id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("mensaje", "No se removio al medico con id " + id);
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);

        }

    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<? extends Map> actualizarMedico(@RequestBody MedicoModelo medicoModelo) {
        Map<String, Object> response = new HashMap<>();

        try {
            MedicoModelo m = medicoServicio.actualizar(medicoModelo);
            response.put("mensaje", "Se actualizo el medico con id " + medicoModelo.getIdMedico());
            response.put("medico", m);
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (Exception e) {
            response.put("mensaje", "No se actualizo el medico con id " + medicoModelo.getIdMedico());
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);

        }

    }


}
