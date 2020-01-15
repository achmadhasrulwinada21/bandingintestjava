package com.bandingintest.ahmad.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bandingintest.ahmad.exception.ResourceNotFoundException;
import com.bandingintest.ahmad.models.Statistic;
import com.bandingintest.ahmad.repositories.StatisticRepository;

@Service("statisticService")
public class StatisticService {
	
	@Autowired
	StatisticRepository statisticRepository;
	
	public Iterable<Statistic> getAll(){
		return statisticRepository.findAll();
	}
	
	public  DataTablesOutput<Statistic> listAll(DataTablesInput input){
		return statisticRepository.findAll(input);
	}
	
//	public Iterable<Statistic> insert(List<Statistic> statistic) {
//		return statisticRepository.saveAll(statistic);
//	}
	
	public Statistic insert(Statistic statistic) {
		return statisticRepository.save(statistic);
	}
	
	public Optional<Statistic> getById(Integer id){
		return statisticRepository.findById(id);
		}
	
	public Statistic update(Integer id, Statistic statistic) {
		Statistic sc = statisticRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Data not found", "id", id));
		sc.setTitle(statistic.getTitle());
		sc.setDescription(statistic.getDescription());
		sc.setStatistic(statistic.getStatistic());
		Statistic update = statisticRepository.save(sc);
		return update;
		
	}
	
	public ResponseEntity<?> delete(Integer id){
		statisticRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
