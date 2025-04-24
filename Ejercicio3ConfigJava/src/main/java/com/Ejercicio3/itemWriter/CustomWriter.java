package com.Ejercicio3.itemWriter;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.Ejercicio3.model.Employee;
import javax.sql.DataSource;

@Component
public class CustomWriter implements ItemWriter<Employee> {

	@Autowired
    private final JdbcTemplate jdbcTemplate;

    public CustomWriter() {
		this.jdbcTemplate = null;
	}
    
    public CustomWriter(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


	@Override
	public void write(Chunk<? extends Employee> chunk) throws Exception {
		for (Employee item : chunk) {
			int updated = jdbcTemplate.update("DELETE FROM employee WHERE userId = ?", item.getuserId());
			if (updated > 0) {
				System.out.println("Deleted employee with ID: " + item.getuserId());
			}
		}
		
	}
}