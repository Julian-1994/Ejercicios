package com.Ejercicio3.itemProcessor;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import com.Ejercicio3.model.Employee;

public class Validador implements Validator<Employee> {
	
	  public void validate(Employee em) throws ValidationException {
	        System.out.println("Voy a validar a "+em.getuserId());
	        try {
	            Integer idInt = Integer.parseInt(em.getuserId());
	            if (idInt<0) {
	                manageError(em, "Employee id no puede ser negativo!");
	                throw new ValidationException("Employee id no puede ser negativo!");
	            }
	        } catch (NumberFormatException e) {
	            manageError(em, "Employee id debe ser un numero!");
	            throw new ValidationException("Employee id debe ser un numero!");
	        }

	    }

	    private void manageError(Employee em, String text) {
	        System.out.println("El empleado de id="+em.getuserId() +" ha tenido error ('"+text+"') y aquí lo tratamos");
	    }

}



