package com.ITAcademy.itBotigaQuadres.bean;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "franchise")
public class Franchise {
	private @Id @GeneratedValue Long id;
	private String franchiseName;
	
	@OneToMany(mappedBy = "franchise")
	private List<Shop> shops;

	public Franchise() {
		// TODO Auto-generated constructor stub
	}

	public Franchise(String franchiseName) {
		super();
		this.franchiseName = franchiseName;
	}

	public List<Shop> getShops() {
		return shops;
	}

	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}

	public Long getId() {
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
