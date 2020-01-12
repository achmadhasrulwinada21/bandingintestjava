package com.bandingintest.ahmad.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bandingintest.ahmad.exception.ResourceNotFoundException;
import com.bandingintest.ahmad.models.Product;
import com.bandingintest.ahmad.repositories.ProductRepository;

@Service("productService")
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public Iterable<Product> getAll(){
		return productRepository.findAll();
	}
	
	public  DataTablesOutput<Product> listAll(DataTablesInput input){
		return productRepository.findAll(input);
	}
	
	public Product insert(Product product) {
		return productRepository.save(product);
	}
	
	public Optional<Product> getById(Integer id){
		return productRepository.findById(id);
	}
	
	public Product update(Integer id, Product product) {
		Product pc = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Data not found", "id", id));
		pc.setTitle(product.getTitle());
		pc.setDescription(product.getDescription());
		pc.setImage(product.getImage());
		Product update = productRepository.save(pc);
		return update;
	}
	
	public ResponseEntity<?> delete(Integer id){
		productRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
