package com.Ejercicio3.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Ejercicio3.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee,String> {
	
	// No es necesario añadir nada más, ya que JpaRepository ya proporciona métodos CRUD básicos
	// y la interfaz EmployeeRepository se encargará de la persistencia de los objetos Employee.
	// Puedes añadir métodos personalizados si es necesario, pero no son obligatorios.

}
