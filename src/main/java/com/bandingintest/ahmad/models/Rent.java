package com.bandingintest.ahmad.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "rental_rules")
@EntityListeners(AuditingEntityListener.class)
public class Rent implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(DataTablesOutput.View.class)
	@Column(name = "id", nullable = false, unique = true)
    private int id;
	
	@Column(name = "name_equipment", length = 120)
    @JsonView(DataTablesOutput.View.class)
    private String name_equipment;
	
	@Column(name = "harga_awal", length = 120)
    @JsonView(DataTablesOutput.View.class)
    private String harga_awal;
	
	@Column(name = "harga_akhir", length = 120)
    @JsonView(DataTablesOutput.View.class)
    private String harga_akhir;
	
	@Column(name = "image", columnDefinition="TEXT")
    @JsonView(DataTablesOutput.View.class)
    private String image;
	
	@Column (name= "rental_rules", columnDefinition="TEXT", nullable = true)
	@JsonView (DataTablesOutput.View.class)
	private String rental_rules;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName_equipment() {
		return name_equipment;
	}

	public void setName_equipment(String name_equipment) {
		this.name_equipment = name_equipment;
	}

	public String getHarga_awal() {
		return harga_awal;
	}

	public void setHarga_awal(String harga_awal) {
		this.harga_awal = harga_awal;
	}

	public String getHarga_akhir() {
		return harga_akhir;
	}

	public void setHarga_akhir(String harga_akhir) {
		this.harga_akhir = harga_akhir;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getRental_rules() {
		return rental_rules;
	}

	public void setRental_rules(String rental_rules) {
		this.rental_rules = rental_rules;
	}
}
