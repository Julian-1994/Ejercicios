package com.Ejercicio3.itemReader;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import com.Ejercicio3.model.Employee;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.Iterator;
import java.util.List;

@Component
public class CustomReader implements ItemReader<Employee> {

	//  se utiliza para inyectar un EntityManager gestionado por el contenedor en un bean de Spring.
	//El EntityManager es la interfaz principal utilizada en JPA para interactuar con el contexto de persistencia
	//y realizar operaciones en la base de datos, como consultas, inserciones, actualizaciones y eliminaciones.
	//Cuando se utiliza @PersistenceContext, el contenedor se encarga de gestionar el ciclo de vida del EntityManager y de asociarlo con una transacción cuando sea necesario.
    @PersistenceContext 
    private EntityManager entityManager;

    private Iterator<Employee> employeeIterator;
    
// Este método se invoca después de que el bean ha sido construido e inyectado con todas las dependencias necesarias.
    //Se utiliza para realizar cualquier inicialización necesaria, como cargar datos o configurar recursos.
    // En este caso, se utiliza para inicializar el iterador de empleados.
    
    @PostConstruct 
    public void initialize() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);
        criteriaQuery.select(employeeRoot)
                .where(criteriaBuilder.greaterThan(employeeRoot.get("transactionAmount"), 2000));

        List<Employee> employees = entityManager.createQuery(criteriaQuery).getResultList();
        this.employeeIterator = employees.iterator();
    }

    @Override
    public Employee read() {
        if (employeeIterator != null && employeeIterator.hasNext()) {
            return employeeIterator.next();
        } else {
            return null;
        }
    }
}