package com.Ejercicio5.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Ejercicio5.model.Empleado;


public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
	// No es necesario agregar métodos adicionales, ya que JpaRepository proporciona
	// métodos CRUD básicos.
	// Si necesitas consultas personalizadas, puedes definirlas aquí.

}
