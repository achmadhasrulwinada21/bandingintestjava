package com.bandingintest.ahmad.repositories;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import com.bandingintest.ahmad.models.Menu;

public interface MenuRepository extends DataTablesRepository<Menu, Integer> {

}
