package com.Ejercicio2.itemWriter;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;
import com.Ejercicio2.model.Employee;
import javax.sql.DataSource;

public class CustomWriter implements ItemWriter<Employee> {

    private JdbcTemplate jdbcTemplate;

    public CustomWriter(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
	@Override
	public void write(Chunk<? extends Employee> item) throws Exception {
        // La lista de empleados no se utiliza ya que la consulta eliminará todos los registros
        jdbcTemplate.update("DELETE FROM employee");
		
	}



	}
