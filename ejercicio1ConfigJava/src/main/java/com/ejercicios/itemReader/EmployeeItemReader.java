package com.ejercicios.itemReader;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.core.io.ClassPathResource;
import com.ejercicios.model.Employee;

public class EmployeeItemReader {

    public FlatFileItemReader<Employee> reader() {
        return new FlatFileItemReaderBuilder<Employee>()
                .name("employeeItemReader")
                .resource(new ClassPathResource("employee.csv"))
                .delimited()
                .names(new String[]{"userName", "userId", "transactionDate", "transactionAmount"})
                .lineMapper(new DefaultLineMapper<Employee>() {{
                    setLineTokenizer((LineTokenizer) new DelimitedLineTokenizer() {{
                        setNames("userName", "userId", "transactionDate", "transactionAmount");
                    }});
                    setFieldSetMapper(new EmployeeFieldSetMapper());
                }})
                .build();
    }
}