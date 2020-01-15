package com.bandingintest.ahmad.repositories;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import com.bandingintest.ahmad.models.Statistic;

public interface StatisticRepository extends DataTablesRepository<Statistic, Integer>{

}
