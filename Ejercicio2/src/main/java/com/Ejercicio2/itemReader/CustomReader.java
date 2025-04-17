package com.Ejercicio2.itemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import com.Ejercicio2.model.Employee;
import javax.sql.DataSource;

public class CustomReader extends JdbcCursorItemReader<Employee> {

    public CustomReader(DataSource dataSource) {
        // Set the DataSource provided by Spring configuration
        setDataSource(dataSource);
        
        // Set the SQL query to select all employees
        setSql("SELECT userId, userName, transactionDate, transactionAmount FROM employee");
        
        // Use a BeanPropertyRowMapper to map the ResultSet to the Employee object
        // The column names in the SQL query should match the field names in the Employee class
        setRowMapper(new BeanPropertyRowMapper<>(Employee.class));
    }
}
	



