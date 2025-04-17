package com.Ejercicio7.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;
import com.Ejercicio7.model.PersonalPC;
import com.Ejercicio7.repository.PersonalPCDao;

@Service
public class PersonalPCService {

	
	    @Autowired
	    private PersonalPCDao personalPCDao;

	    public PersonalPC createPersonalPC(PersonalPC personalPC) {
	        return personalPCDao.save(personalPC);
	    }

	    public Optional<PersonalPC> getPersonalPCById(Integer id) {
	        return personalPCDao.findById(id);
	    }

	    public List<PersonalPC> getAllPersonalPCs() {
	        return personalPCDao.findAll();
	    }

	    public PersonalPC updatePersonalPC(Integer id, PersonalPC personalPCDetails) {
	        PersonalPC personalPC = personalPCDao.findById(id)
	                .orElseThrow(() -> new ResourceAccessException("PersonalPC not found"));
	        personalPC.setRamMemory(personalPCDetails.getRamMemory());
	        personalPC.setCpu(personalPCDetails.getCpu());
	        personalPC.setGraphicCard(personalPCDetails.getGraphicCard());
	        personalPC.setCpuFreq(personalPCDetails.getCpuFreq());
	        personalPC.setBrand(personalPCDetails.getBrand());
	        personalPC.setModel(personalPCDetails.getModel());
	        personalPC.setHasScreen(personalPCDetails.getHasScreen());
	        return personalPCDao.save(personalPC);
	    }

	    public void deletePersonalPC(Integer id) {
	        PersonalPC personalPC = personalPCDao.findById(id)
	                .orElseThrow(() -> new ResourceAccessException("PersonalPC not found"));
	        personalPCDao.delete(personalPC);
	    }
	}

