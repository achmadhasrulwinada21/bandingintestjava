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

import com.bandingintest.ahmad.models.Rent;
import com.bandingintest.ahmad.services.RentService;
import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class RentController {
	
	@Autowired
	RentService rentService;
	
	@GetMapping("/list/rents")
    @JsonView(DataTablesOutput.View.class)
	public DataTablesOutput<Rent> listAll(@Valid DataTablesInput input){
		return rentService.listAll(input);
	}
	
	@GetMapping("/rents")
	public Iterable<Rent> getAll(){
		return rentService.getAll();
	}
	
	@GetMapping("/rents/{id}")
	public Optional<Rent> getById(@PathVariable("id") Integer id){
		return rentService.getById(id);
	}
	
	@PostMapping("/rent")
	public Rent insert (@RequestBody Rent rent) {
		return rentService.insert(rent);
	}
	
	@PutMapping("/rent/{id}")
	public Rent update(@PathVariable("id") Integer id, @RequestBody Rent rent) {
		return rentService.update(id, rent);
	}
	
	@DeleteMapping("/rent/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		return rentService.delete(id);
	}

}
