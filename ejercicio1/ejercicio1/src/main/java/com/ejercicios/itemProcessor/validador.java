package com.ejercicios.itemProcessor;

import com.ejercicios.model.Employee;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;

public class validador implements Validator<Employee> {

    @Override
    public void validate(Employee em) throws ValidationException {
        System.out.println("Voy a validar a "+em.getUserId());
        try {
            Integer idInt = Integer.parseInt(em.getUserId());
            if (idInt<0) {
                manageError(em, "Employee id cannot be negative!");
                throw new ValidationException("Employee id cannot be negative!");
            }
        } catch (NumberFormatException e) {
            manageError(em, "Employee id must be a number!");
            throw new ValidationException("Employee id must be a number!");
        }

    }

    private void manageError(Employee em, String text) {
        System.out.println("El empleado de id="+em.getUserId() +" ha tenido error ('"+text+"') y aquí lo tratamos");
    }

}

