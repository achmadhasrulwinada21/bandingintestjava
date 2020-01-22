package com.bandingintest.ahmad.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bandingintest.ahmad.exception.ResourceNotFoundException;
import com.bandingintest.ahmad.models.Rent;
import com.bandingintest.ahmad.repositories.RentRepository;

@Service("rentService")
public class RentService {
	
	@Autowired
	RentRepository rentRepository;
	
	public Iterable<Rent> getAll(){
		return rentRepository.findAll();
	}
	
	public  DataTablesOutput<Rent> listAll(DataTablesInput input){
		return rentRepository.findAll(input);
	}
	
	public Rent insert(Rent rent) {
		return rentRepository.save(rent);
	}
	
	public Optional<Rent> getById(Integer id){
		return rentRepository.findById(id);
		}
	
	public Rent update(Integer id, Rent rent) {
		Rent rt = rentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Data not found", "id", id));
		rt.setName_equipment(rent.getName_equipment());
		rt.setImage(rent.getImage());
		rt.setHarga_awal(rent.getHarga_awal());
		rt.setHarga_akhir(rent.getHarga_akhir());
		rt.setRental_rules(rent.getRental_rules());
		Rent update = rentRepository.save(rt);
		return update;
		
	}
	
	public ResponseEntity<?> delete(Integer id){
		rentRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
