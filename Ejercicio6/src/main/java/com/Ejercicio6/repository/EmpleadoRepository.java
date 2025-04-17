package com.Ejercicio6.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.Ejercicio6.model.Empleado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class EmpleadoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Empleado findById(int id) {
        return entityManager.find(Empleado.class, id);
    }

    @Transactional
    public void save(Empleado empleado) {
        entityManager.persist(empleado);
    }

    @Transactional
    public void update(Empleado empleado) {
        entityManager.merge(empleado);
    }

    @Transactional
    public void delete(Empleado empleado) {
        entityManager.remove(entityManager.contains(empleado) ? empleado : entityManager.merge(empleado));
    }

    public List<Empleado> findAll() {
        TypedQuery<Empleado> query = entityManager.createQuery("SELECT e FROM Empleado e", Empleado.class);
        return query.getResultList();
    }
}