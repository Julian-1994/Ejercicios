package com.ejercicios.itemWriter;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;
import com.ejercicios.model.Employee;

public class EmployeeWriter implements ItemWriter<Employee> {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeWriter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


	@Override
	public void write(Chunk<? extends Employee> chunk) throws Exception {
		   for (Employee employee : chunk) {
	            jdbcTemplate.update(
	                "INSERT INTO employee (userName, userId, transactionDate, transactionAmount) VALUES (?, ?, ?, ?)",
	                employee.getUserName(), employee.getUserId(), employee.getTransactionDate(), employee.getTransactionAmount()
	            );
		
	}
}
}
