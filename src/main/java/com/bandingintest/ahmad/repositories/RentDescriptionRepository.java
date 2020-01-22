package com.bandingintest.ahmad.repositories;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import com.bandingintest.ahmad.models.RentDescription;


public interface RentDescriptionRepository extends DataTablesRepository<RentDescription, Integer> {

}
