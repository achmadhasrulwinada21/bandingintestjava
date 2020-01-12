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

import com.bandingintest.ahmad.models.WebsiteSetting;
import com.bandingintest.ahmad.services.WebsiteSettingService;
import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class WebsiteSettingController {
	
	@Autowired
	WebsiteSettingService websitesettingService;
	
	@GetMapping("/list/websettings")
    @JsonView(DataTablesOutput.View.class)
	public DataTablesOutput<WebsiteSetting> listAll(@Valid DataTablesInput input){
		return websitesettingService.listAll(input);
	}
	
	@GetMapping("/websettings")
	public Iterable<WebsiteSetting> getAll(){
		return websitesettingService.getAll();
	}
	
	@GetMapping("/websetting/{id}")
	public Optional<WebsiteSetting> getById(@PathVariable("id") Integer id){
		return websitesettingService.getById(id);
	}
	
	@PostMapping("/websetting")
	public WebsiteSetting insert (@RequestBody WebsiteSetting websitesetting) {
		return websitesettingService.insert(websitesetting);
	}
	
	@PutMapping("/websetting/{id}")
	public WebsiteSetting update(@PathVariable("id") Integer id, @RequestBody WebsiteSetting websitesetting) {
		return websitesettingService.update(id, websitesetting);
	}
	
	@DeleteMapping("/websetting/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		return websitesettingService.delete(id);
	}


}
