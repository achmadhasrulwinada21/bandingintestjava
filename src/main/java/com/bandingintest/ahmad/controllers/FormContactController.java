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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bandingintest.ahmad.models.FormContact;
import com.bandingintest.ahmad.services.FormContactService;
import com.fasterxml.jackson.annotation.JsonView;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class FormContactController {

	@Autowired
	FormContactService formcontactservice;
	
	@GetMapping("/list/formcontacts")
    @JsonView(DataTablesOutput.View.class)
	public DataTablesOutput<FormContact> listAll(@Valid DataTablesInput input){
		return formcontactservice.listAll(input);
	}
	
	@GetMapping("/formcontacts")
	public Iterable<FormContact> getAll(){
		return formcontactservice.getAll();
	}
	
	@GetMapping("/formcontact/{id}")
	public Optional<FormContact> getById(@PathVariable("id") Integer id){
		return formcontactservice.getById(id);
	}
	
	@PostMapping("/formcontact")
	public FormContact insert (@RequestBody FormContact formcontact) {
		return formcontactservice.insert(formcontact);
	}
	
	@DeleteMapping("/formcontact/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		return formcontactservice.delete(id);
	}
	
}
