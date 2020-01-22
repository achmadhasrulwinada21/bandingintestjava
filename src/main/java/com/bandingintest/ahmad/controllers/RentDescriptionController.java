package com.bandingintest.ahmad.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bandingintest.ahmad.models.RentDescription;
import com.bandingintest.ahmad.services.RentDescriptionService;
import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class RentDescriptionController {

	@Autowired
	RentDescriptionService rentdescriptionService;
	
	@GetMapping("/list/rentdesciptions")
    @JsonView(DataTablesOutput.View.class)
	public DataTablesOutput<RentDescription> listAll(@Valid DataTablesInput input){
		return rentdescriptionService.listAll(input);
	}
	
	@GetMapping("/rentdesciptions")
	public Iterable<RentDescription> getAll(){
		return rentdescriptionService.getAll();
	}
	
	@GetMapping("/rentdesciptions/{id}")
	public Optional<RentDescription> getById(@PathVariable("id") Integer id){
		return rentdescriptionService.getById(id);
	}
	
	@PostMapping("/rentdesciption")
	public RentDescription insert (@RequestBody RentDescription rent) {
		return rentdescriptionService.insert(rent);
	}
	
	@PutMapping("/rentdesciption/{id}")
	public RentDescription update(@PathVariable("id") Integer id, @RequestBody RentDescription rent) {
		return rentdescriptionService.update(id, rent);
	}
	
	@DeleteMapping("/rentdesciption/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		return rentdescriptionService.delete(id);
	}

	
}
