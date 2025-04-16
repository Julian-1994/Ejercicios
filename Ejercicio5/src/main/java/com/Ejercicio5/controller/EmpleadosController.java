package com.Ejercicio5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Ejercicio5.model.Empleado;
import com.Ejercicio5.repository.EmpleadoRepository;
import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadosController {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping
    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    @PostMapping
    public Empleado createEmpleado(@RequestBody Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> getEmpleadoById(@PathVariable int id) {
        Empleado empleado = empleadoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado"));
        return ResponseEntity.ok(empleado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> updateEmpleado(@PathVariable int id, @RequestBody Empleado empleadoDetails) {
        Empleado empleado = empleadoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado"));

        empleado.setNombre(empleadoDetails.getNombre());
        empleado.setPuestoTrabajo(empleadoDetails.getPuestoTrabajo());
        empleado.setFechaContratacion(empleadoDetails.getFechaContratacion());

        Empleado updatedEmpleado = empleadoRepository.save(empleado);
        return ResponseEntity.ok(updatedEmpleado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable int id) {
        Empleado empleado = empleadoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado"));

        empleadoRepository.delete(empleado);
        return ResponseEntity.noContent().build();
    }
}