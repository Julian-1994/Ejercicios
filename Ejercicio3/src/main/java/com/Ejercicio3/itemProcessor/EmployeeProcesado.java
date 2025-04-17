package com.Ejercicio3.itemProcessor;
import java.util.Calendar;
import org.springframework.batch.item.ItemProcessor;
import com.Ejercicio3.model.Employee;

public class EmployeeProcesado implements ItemProcessor<Employee, Employee> {
	
	

    @Override
    public Employee process(Employee item) throws Exception {

        System.out.println("Procesando..." + item.getuserId());

        if (item.getTransactionDate()!=null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(item.getTransactionDate());
            calendar.add(Calendar.DATE, 1);
            item.setTransactionDate(calendar.getTime());
        }
        else {
            System.out.println("Se produjo un error al procesar el empleado con id= "+item.getuserId());
        }

        return item;
    }
}
 


