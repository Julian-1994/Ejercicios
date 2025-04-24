package com.Ejercicio2;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Ejercicio2Application {

    public static void main(String[] args) {
        // Iniciar la aplicación Spring Boot
        SpringApplication.run(Ejercicio2Application.class, args);

        // Cargar el contexto de Spring utilizando job.xml
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("job.xml");

        // Obtener el JobLauncher y el Job definidos en el contexto
        JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        Job job = context.getBean("miJob", Job.class);

        try {
            // Ejecutar el trabajo con parámetros vacíos (o configurar si es necesario)
            JobExecution execution = jobLauncher.run(job, new JobParameters());
            System.out.println("Job Status : " + execution.getStatus());
            System.out.println("Job completed");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Job failed");
        } finally {
            // Cerrar el contexto para liberar recursos
            context.close();
        }
    }
}

