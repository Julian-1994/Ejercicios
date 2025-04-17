package com.Ejercicio6.model;

import java.util.Date;
import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPLEADOS")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empleado_seq")
    @SequenceGenerator(name = "empleado_seq", sequenceName = "EMPLEADO_SEQ", allocationSize = 1)
    private int id;
    private String nombre;
    private String funcion;
    private Date fecha_Contratacion;

    public Empleado() {
        super();
    }

    public Empleado(int id, String nombre, String funcion, Date fechaContratacion) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.funcion = funcion;
        this.fecha_Contratacion = fechaContratacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public Date getFechaContratacion() {
        return fecha_Contratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fecha_Contratacion = fechaContratacion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fecha_Contratacion, funcion, id, nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Empleado other = (Empleado) obj;
        return Objects.equals(fecha_Contratacion, other.fecha_Contratacion) && Objects.equals(funcion, other.funcion)
                && id == other.id && Objects.equals(nombre, other.nombre);
    }

    @Override
    public String toString() {
        return "Empleado [id=" + id + ", nombre=" + nombre + ", funcion=" + funcion + ", fechaContratacion="
                + fecha_Contratacion + "]";
    }
}