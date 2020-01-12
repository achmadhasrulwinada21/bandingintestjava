package com.bandingintest.ahmad.repositories;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import com.bandingintest.ahmad.models.WebsiteSetting;

public interface WebsiteSettingRepository extends DataTablesRepository<WebsiteSetting, Integer> {

}
