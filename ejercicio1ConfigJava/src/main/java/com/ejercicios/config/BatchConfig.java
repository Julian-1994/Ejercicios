package com.ejercicios.config;
import com.ejercicios.itemProcessor.validador;
import com.ejercicios.itemProcessor.employeeProcesado;
import com.ejercicios.itemReader.EmployeeItemReader;
import com.ejercicios.itemWriter.EmployeeWriter;
import com.ejercicios.model.Employee;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfig {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    public BatchConfig(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
    }

    @Bean
    public EmployeeItemReader employeeItemReader() {
        return new EmployeeItemReader();
    }

    @Bean
    public validador validator() {
        return new validador();
    }
    @Bean
    public ItemReader<Employee> cvsFileItemReader(EmployeeItemReader employeeItemReader) {
        return employeeItemReader.reader();
    }
    
    @Bean
    public ItemProcessor<Employee, Employee> itemProcessor() {
        // Crear el procesador de validación
        ValidatingItemProcessor<Employee> validatingItemProcessor = new ValidatingItemProcessor<>(validator());
        validatingItemProcessor.setFilter(true); // Omitir registros inválidos

        // Crear el procesador de empleado
        employeeProcesado employeeProcessado = new employeeProcesado();

        // Encadenar los procesadores
        return item -> {
            Employee validatedEmployee = validatingItemProcessor.process(item);
            if (validatedEmployee != null) {
                return employeeProcessado.process(validatedEmployee);
            }
            return null;
        };
    }

    @Bean
    public ItemWriter<Employee> mysqlItemWriter(JdbcTemplate jdbcTemplate) {
        return new EmployeeWriter(jdbcTemplate);
    }
    
  

    @Bean
    public Step step1(ItemReader<Employee> cvsFileItemReader,
                      ItemProcessor<Employee, Employee> itemProcessor,
                      ItemWriter<Employee> mysqlItemWriter) {
        return new StepBuilder("step1", jobRepository)
                .<Employee, Employee>chunk(10, transactionManager)
                .reader(cvsFileItemReader)
                .processor(itemProcessor)
                .writer(mysqlItemWriter)
                .build();
    }

    @Bean
    public Job miJob(Step step1) {
        return new JobBuilder("miJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(step1)
                .build();
    }
}