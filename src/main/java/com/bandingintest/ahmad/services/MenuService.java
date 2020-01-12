package com.bandingintest.ahmad.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bandingintest.ahmad.exception.ResourceNotFoundException;
import com.bandingintest.ahmad.models.Menu;
import com.bandingintest.ahmad.repositories.MenuRepository;



@Service("menuService")
public class MenuService {
	@Autowired
	MenuRepository menuRepository;
	
	public Iterable<Menu> getAll(){
		return menuRepository.findAll();
	}
	
	public  DataTablesOutput<Menu> listAll(DataTablesInput input){
		return menuRepository.findAll(input);
	}
	
	public Menu insert(Menu menu) {
		return menuRepository.save(menu);
	}
	
	public Optional<Menu> getById(Integer id){
		return menuRepository.findById(id);
	}
	
	public Menu update(Integer id, Menu menu) {
		Menu mn = menuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Data not found", "id", id));
		mn.setMenu_name(menu.getMenu_name());
		mn.setMenu_link(menu.getMenu_link());
		Menu update = menuRepository.save(mn);
		return update;
	}
	
	public ResponseEntity<?> delete(Integer id){
		menuRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
}
