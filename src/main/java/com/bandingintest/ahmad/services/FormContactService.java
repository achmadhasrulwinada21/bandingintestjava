package com.bandingintest.ahmad.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bandingintest.ahmad.models.FormContact;
import com.bandingintest.ahmad.repositories.FormContactRepository;

@Service("formcontactService")
public class FormContactService {

	@Autowired
	FormContactRepository formcontactRepository;
	
	public Iterable<FormContact> getAll(){
		return formcontactRepository.findAll();
	}
	
	public  DataTablesOutput<FormContact> listAll(DataTablesInput input){
		return formcontactRepository.findAll(input);
	}
	
	public FormContact insert(FormContact formcontact) {
		return formcontactRepository.save(formcontact);
	}
	
	public Optional<FormContact> getById(Integer id){
		return formcontactRepository.findById(id);
	}
		
	public ResponseEntity<?> delete(Integer id){
		formcontactRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
