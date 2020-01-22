package com.bandingintest.ahmad.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bandingintest.ahmad.exception.ResourceNotFoundException;
import com.bandingintest.ahmad.models.RentDescription;
import com.bandingintest.ahmad.repositories.RentDescriptionRepository;


@Service("rentdescriptionService")
public class RentDescriptionService {
	
	@Autowired
	RentDescriptionRepository rentdescriptionRepository;
	
	public Iterable<RentDescription> getAll(){
		return rentdescriptionRepository.findAll();
	}
	
	public  DataTablesOutput<RentDescription> listAll(DataTablesInput input){
		return rentdescriptionRepository.findAll(input);
	}
	
	public RentDescription insert(RentDescription rent) {
		return rentdescriptionRepository.save(rent);
	}
	
	public Optional<RentDescription> getById(Integer id){
		return rentdescriptionRepository.findById(id);
		}
	
	public RentDescription update(Integer id, RentDescription rent) {
		RentDescription rt = rentdescriptionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Data not found", "id", id));
		rt.setTitle(rent.getTitle());
		rt.setDescription(rent.getDescription());
		rt.setImage(rent.getImage());
		RentDescription update = rentdescriptionRepository.save(rt);
		return update;
		
	}
	
	public ResponseEntity<?> delete(Integer id){
		rentdescriptionRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
