package com.bandingintest.ahmad.repositories;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import com.bandingintest.ahmad.models.Banner;

public interface BannerRepository extends DataTablesRepository<Banner, Integer> {
		Banner findByCategory(String category);
}
