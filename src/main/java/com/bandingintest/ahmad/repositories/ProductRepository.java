package com.bandingintest.ahmad.repositories;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import com.bandingintest.ahmad.models.Product;

public interface ProductRepository extends DataTablesRepository<Product, Integer>{

}
