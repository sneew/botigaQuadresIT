package com.ITAcademy.itBotigaQuadres.bean;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "shop")
public class Shop {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String shopName;
	private int shopCapacity;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="franchise_id")
	@JsonIgnore
	private Franchise franchise;
	
	public Shop() {
		// TODO Auto-generated constructor stub
	}
	
	public Shop(String shopName, int shopCapacity, Franchise franchise) {
		super();
		this.shopName = shopName;
		this.shopCapacity = shopCapacity;
		this.franchise = franchise;
	}

	public Franchise getFranchise() {
		return franchise;
	}

	public void setFranchise(Franchise franchise) {
		this.franchise = franchise;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public int getShopCapacity() {
		return shopCapacity;
	}

	public void setShopCapacity(int shopCapacity) {
		this.shopCapacity = shopCapacity;
	}

}
