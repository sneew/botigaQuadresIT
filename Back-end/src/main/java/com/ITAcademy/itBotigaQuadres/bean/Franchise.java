package com.ITAcademy.itBotigaQuadres.bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "franchise")
public class Franchise {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private String franchiseName;

	public Franchise() {
		super();
	}

	public Franchise(String franchiseName) {
	
		this.franchiseName = franchiseName;
	}

	public Franchise(Long id2) {
		this.id = id2;
	}


	public Long getId(Long id2) {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFranchiseName() {
		return franchiseName;
	}

	public void setFranchiseName(String franchiseName) {
		this.franchiseName = franchiseName;
	}

}
