package com.Ejercicio3.repository;
import com.Ejercicio3.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeDAO {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findMinAmount(double amount) {
        return employeeRepository.findByTransactionAmountGreaterThan(amount);
    }

    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }


	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
}