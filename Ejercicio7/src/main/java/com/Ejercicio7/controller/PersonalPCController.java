package com.Ejercicio7.controller;
import com.Ejercicio7.model.PersonalPC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.Ejercicio7.service.PersonalPCService;

	@RestController
	@RequestMapping("/api/personalpcs")
	public class PersonalPCController {

	    @Autowired
	    private PersonalPCService personalPCService;

	    @PostMapping
	    public ResponseEntity<PersonalPC> createPersonalPC(@RequestBody PersonalPC personalPC) {
	        return ResponseEntity.ok(personalPCService.createPersonalPC(personalPC));
	    }

	    @GetMapping("/")
	    public String home() {
	        return "Welcome to the PersonalPC application!";
	    }
	    
	    @GetMapping("/{id}")
	    public ResponseEntity<PersonalPC> getPersonalPCById(@PathVariable Integer id) {
	        return personalPCService.getPersonalPCById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @GetMapping
	    public List<PersonalPC> getAllPersonalPCs() {
	        return personalPCService.getAllPersonalPCs();
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<PersonalPC> updatePersonalPC(@PathVariable Integer id, @RequestBody PersonalPC personalPCDetails) {
	        return ResponseEntity.ok(personalPCService.updatePersonalPC(id, personalPCDetails));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletePersonalPC(@PathVariable Integer id) {
	        personalPCService.deletePersonalPC(id);
	        return ResponseEntity.noContent().build();
	    }
	}


