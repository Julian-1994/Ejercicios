package com.ejercicios.ejercicio1;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Ejercicio1Application {

	public static void main(String[] args) {

		SpringApplication.run(Ejercicio1Application.class, args);
		// Se crea el contexto de la aplicación
		ApplicationContext context = new ClassPathXmlApplicationContext("job.xml");
		// Se crea el jobLauncher
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		// Se crea el job
		Job miJob = (Job) context.getBean("miJob");
		// Ejecutamos el job
		JobExecution execution;
		try {
			execution = jobLauncher.run(miJob, new JobParameters());
			System.out.println("miJob: estado = " + execution.getStatus());

		} catch (JobExecutionAlreadyRunningException e) {
			e.printStackTrace();

		} catch (JobRestartException e) {
			e.printStackTrace();

		} catch (JobInstanceAlreadyCompleteException e) {
			e.printStackTrace();

		} catch (JobParametersInvalidException e) {
			e.printStackTrace();
		}
	}


}
