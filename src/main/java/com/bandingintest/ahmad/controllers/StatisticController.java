package com.bandingintest.ahmad.controllers;

import java.util.List;
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

import com.bandingintest.ahmad.models.Statistic;
import com.bandingintest.ahmad.services.StatisticService;
import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class StatisticController {
	
	@Autowired
	StatisticService statisticService;
	
	@GetMapping("/list/statistics")
    @JsonView(DataTablesOutput.View.class)
	public DataTablesOutput<Statistic> listAll(@Valid DataTablesInput input){
		return statisticService.listAll(input);
	}
	
	@GetMapping("/statistics")
	public Iterable<Statistic> getAll(){
		return statisticService.getAll();
	}
	
	@GetMapping("/statistics/{id}")
	public Optional<Statistic> getById(@PathVariable("id") Integer id){
		return statisticService.getById(id);
	}
	
	@PostMapping("/statistic")
	public Statistic insert (@RequestBody Statistic statistic) {
		return statisticService.insert(statistic);
	}
	
	@PutMapping("/statistic/{id}")
	public Statistic update(@PathVariable("id") Integer id, @RequestBody Statistic statistic) {
		return statisticService.update(id, statistic);
	}
	
	@DeleteMapping("/statistic/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		return statisticService.delete(id);
	}
}
