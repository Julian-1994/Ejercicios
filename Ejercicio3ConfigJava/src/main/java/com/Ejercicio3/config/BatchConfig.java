package com.Ejercicio3.config;

import com.Ejercicio3.itemProcessor.Validador;
import com.Ejercicio3.itemProcessor.EmployeeProcesado;
import com.Ejercicio3.itemReader.CustomReader;
import com.Ejercicio3.itemWriter.CustomWriter;
import com.Ejercicio3.model.Employee;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Arrays;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Bean
    @StepScope
    public Validador validator() {
        return new Validador();
    }

    @Bean
    @StepScope
    public EmployeeProcesado customItemProcessor() {
        return new EmployeeProcesado();
    }

    @Bean
    @StepScope
    public CustomWriter itemWriter() {
        return new CustomWriter();
    }

    @Bean
    @StepScope
    public CustomReader itemReader() {
        return new CustomReader();
    }
    
    @Bean
    @StepScope
    public CompositeItemProcessor<Employee, Employee> itemProcessor() {
        CompositeItemProcessor<Employee, Employee> processor = new CompositeItemProcessor<>();
        processor.setDelegates(Arrays.asList(validatingItemProcessor(), customItemProcessor()));
        return processor;
    }

    @Bean
    @StepScope
    public ValidatingItemProcessor<Employee> validatingItemProcessor() {
        ValidatingItemProcessor<Employee> processor = new ValidatingItemProcessor<>();
        processor.setFilter(true);
        processor.setValidator(validator());
        return processor;
    }
    
    @Bean
    public Job miJob() {
        return new JobBuilder("miJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(step1())
                .build();
    }

    @Bean
    public Step step1() {
        return new StepBuilder("step1", jobRepository)
                .<Employee, Employee>chunk(10, transactionManager)
                .reader(itemReader())
                .processor(itemProcessor())
                .writer(itemWriter())
                .build();
    }
}