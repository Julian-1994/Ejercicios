package com.Ejercicio3.repository;
import com.Ejercicio3.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    List<Employee> findByTransactionAmountGreaterThan(double amount);
}