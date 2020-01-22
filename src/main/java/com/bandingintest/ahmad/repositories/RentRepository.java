package com.bandingintest.ahmad.repositories;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import com.bandingintest.ahmad.models.Rent;

public interface RentRepository extends DataTablesRepository<Rent, Integer>{

}
