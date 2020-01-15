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
@Table(name = "statistic")
@EntityListeners(AuditingEntityListener.class)

public class Statistic implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(DataTablesOutput.View.class)
	@Column(name = "id", nullable = false, unique = true)
    private int id;
	
	@Column(name = "title", length = 120)
    @JsonView(DataTablesOutput.View.class)
    private String title;
	
	@Column (name= "description", columnDefinition="TEXT")
	@JsonView (DataTablesOutput.View.class)
	private String description;
	
	@Column (name= "statistic", columnDefinition="TEXT", nullable = true)
	@JsonView (DataTablesOutput.View.class)
	private String statistic;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatistic() {
		return statistic;
	}

	public void setStatistic(String statistic) {
		this.statistic = statistic;
	}

}
