package com.ejercicios.itemProcessor;

import com.ejercicios.model.Employee;
import org.springframework.batch.item.ItemProcessor;
import java.util.Calendar;

public class employeeProcesado implements ItemProcessor<Employee, Employee> {


    @Override
    public Employee process(Employee item) throws Exception {

        System.out.println("Procesando..." + item.getUserId());

        if (item.getTransactionDate()!=null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(item.getTransactionDate());
            calendar.add(Calendar.DATE, 1);
            item.setTransactionDate(calendar.getTime());
        }
        else {
            System.out.println("Se produjo un error al procesar el empleado con id= "+item.getUserId());
        }

        return item;
    }
}
