package com.bandingintest.ahmad.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.bandingintest.ahmad.exception.ResourceNotFoundException;
import com.bandingintest.ahmad.models.WebsiteSetting;
import com.bandingintest.ahmad.repositories.WebsiteSettingRepository;

@Service("websitesettingService")
public class WebsiteSettingService {
	
	@Autowired
	WebsiteSettingRepository websitesettingRepository;
	
	public Iterable<WebsiteSetting> getAll(){
		return websitesettingRepository.findAll();
	}
	
	public  DataTablesOutput<WebsiteSetting> listAll(DataTablesInput input){
		return websitesettingRepository.findAll(input);
	}
	
	public WebsiteSetting getByCode(Integer code) {
		try {
			throw new ResourceNotFoundException("WebsiteSetting", "Code not found", code);
		}catch(Exception e) {
			return websitesettingRepository.findByCode(code);
		}
	}
	
	public WebsiteSetting insert(WebsiteSetting websitesetting) {
		return websitesettingRepository.save(websitesetting);
	}
	
	public Optional<WebsiteSetting> getById(Integer id){
		return websitesettingRepository.findById(id);
	}
	
	public WebsiteSetting update(Integer code, WebsiteSetting websitesetting) {
		WebsiteSetting ws = websitesettingRepository.findByCode(code);
		if(ws != null) {
		ws.setWebsite_name(websitesetting.getWebsite_name());
		ws.setLogo_fb(websitesetting.getLogo_fb());
		ws.setLogo_twitter(websitesetting.getLogo_twitter());
		ws.setLogo_instagram(websitesetting.getLogo_instagram());
		ws.setCopyright(websitesetting.getCopyright());
		ws.setNo_telp(websitesetting.getNo_telp());
		ws.setNo_fax(websitesetting.getNo_fax());
		ws.setEmail(websitesetting.getEmail());
		ws.setCity(websitesetting.getCity());
		ws.setAddress(websitesetting.getAddress());
		ws.setCode(websitesetting.getCode());
		WebsiteSetting update = websitesettingRepository.save(ws);
		return update;
		}else {
			throw new ResourceNotFoundException("WebsiteSetting", "Code not found", ws.getCode());
		}
	}
	
	public ResponseEntity<?> delete(Integer id){
		websitesettingRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}


}
