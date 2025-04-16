package com.Ejercicio5.model;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPLEADOS")
public class Empleado {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 
	    private int id;
	    private String nombre;
	    private String funcion;
	    private Date fechaContratacion;
	    

		public Empleado() {
			super();
		}
	    
		public Empleado(int id, String nombre, String funcion, Date fechaContratacion) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.funcion = funcion;
			this.fechaContratacion = fechaContratacion;		
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
		
		public String getPuestoTrabajo() {
			return funcion;
		}
		
		public void setPuestoTrabajo(String funcion) {
			this.funcion = funcion;
		}
		
	    @Override
		public int hashCode() {
			return Objects.hash(fechaContratacion, funcion, id, nombre);
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
			return Objects.equals(fechaContratacion, other.fechaContratacion) && Objects.equals(funcion, other.funcion)
					&& id == other.id && Objects.equals(nombre, other.nombre);
		}

		
		public Date getFechaContratacion() {
			return fechaContratacion;
		}
		
		public void setFechaContratacion(Date fechaContratacion) {
			this.fechaContratacion = fechaContratacion;
		}

		@Override
		public String toString() {
			return "Empleado [id=" + id + ", nombre=" + nombre + ", funcion=" + funcion + ", fechaContratacion="
					+ fechaContratacion + "]";
		}

}