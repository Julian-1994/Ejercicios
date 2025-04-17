package com.Ejercicio6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Ejercicio6.model.Empleado;
import com.Ejercicio6.repository.EmpleadoRepository;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadosController {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping
    public List<Empleado> getAllEmpleados() {
        // Implementa el método findAll en EmpleadoRepository si no existe
        return empleadoRepository.findAll();
    }

    @PostMapping
    public Empleado createEmpleado(@RequestBody Empleado empleado) {
        empleadoRepository.save(empleado);
        return empleado;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> getEmpleadoById(@PathVariable int id) {
        Empleado empleado = empleadoRepository.findById((int) id);
        if (empleado == null) {
            throw new ResourceNotFoundException("Empleado no encontrado");
        }
        return ResponseEntity.ok(empleado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> updateEmpleado(@PathVariable int id, @RequestBody Empleado empleadoDetails) {
        Empleado empleado = empleadoRepository.findById((int) id);
        if (empleado == null) {
            throw new ResourceNotFoundException("Empleado no encontrado");
        }

        empleado.setNombre(empleadoDetails.getNombre());
        empleado.setFuncion(empleadoDetails.getFuncion());
        empleado.setFechaContratacion(empleadoDetails.getFechaContratacion());

        empleadoRepository.update(empleado);
        return ResponseEntity.ok(empleado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable int id) {
        Empleado empleado = empleadoRepository.findById((int) id);
        if (empleado == null) {
            throw new ResourceNotFoundException("Empleado no encontrado");
        }

        empleadoRepository.delete(empleado);
        return ResponseEntity.noContent().build();
    }
}