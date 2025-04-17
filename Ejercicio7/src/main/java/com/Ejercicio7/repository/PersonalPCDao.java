package com.Ejercicio7.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Ejercicio7.model.PersonalPC;

public interface PersonalPCDao extends JpaRepository<PersonalPC, Integer> {
	// No additional methods are needed for basic CRUD operations
	// JpaRepository provides methods like save(), findById(), findAll(), deleteById(), etc.
}
