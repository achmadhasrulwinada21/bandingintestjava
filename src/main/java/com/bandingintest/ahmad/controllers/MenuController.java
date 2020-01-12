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

import com.bandingintest.ahmad.models.Menu;
import com.bandingintest.ahmad.services.MenuService;
import com.fasterxml.jackson.annotation.JsonView;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class MenuController {
	
	@Autowired
	MenuService menuService;
	
	@GetMapping("/list/menus")
    @JsonView(DataTablesOutput.View.class)
	public DataTablesOutput<Menu> listAll(@Valid DataTablesInput input){
		return menuService.listAll(input);
	}
	
	@GetMapping("/menus")
	public Iterable<Menu> getAll(){
		return menuService.getAll();
	}
	
	@GetMapping("/menu/{id}")
	public Optional<Menu> getById(@PathVariable("id") Integer id){
		return menuService.getById(id);
	}
	
	@PostMapping("/menu")
	public Menu insert (@RequestBody Menu menu) {
		return menuService.insert(menu);
	}
	
	@PutMapping("/menu/{id}")
	public Menu update(@PathVariable("id") Integer id, @RequestBody Menu menu) {
		return menuService.update(id, menu);
	}
	
	@DeleteMapping("/menu/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		return menuService.delete(id);
	}
}
