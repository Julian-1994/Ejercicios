package com.ejercicios.itemReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;
import com.ejercicios.model.Employee;
/**
 * Esta clase se encarga de mapear los campos del archivo CSV a un objeto Employee.
 * Implementa la interfaz FieldSetMapper de Spring Batch.
 */
public class EmployeeFieldSetMapper implements FieldSetMapper<Employee> {

    @Override
    public Employee mapFieldSet(FieldSet fieldSet) throws BindException {

        try {
            // instanciamos el objeto empleado
            Employee employee = new Employee();

            // configurando los valores del objeto empleado usando el reader del xml
            employee.setUserName(fieldSet.readString(0));
            employee.setUserId(fieldSet.readString(1));
            String dateString = fieldSet.readString(2);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            employee.setTransactionDate(sdf.parse(dateString));
            employee.setTransactionAmount(fieldSet.readInt(3));
            return employee;

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }
}