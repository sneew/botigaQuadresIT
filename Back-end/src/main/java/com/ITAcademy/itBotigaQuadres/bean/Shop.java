package com.ITAcademy.itBotigaQuadres.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "shop")
public class Shop {
	
	private @Id @GeneratedValue Long id;
	private String shopName;
	private int shopCapacity;
	
	@ManyToOne
    @JoinColumn(name="franchise_id")
	private Franchise franchise;
	
	@OneToMany(mappedBy = "shop")
	private List<Painting> paintings;
	
	public Shop() {
		// TODO Auto-generated constructor stub
	}

	public Shop(String shopName, int shopCapacity) {
		super();
		this.shopName = shopName;
		this.shopCapacity = shopCapacity;
	}



	public List<Painting> getPaintings() {
		return paintings;
	}

	public void setPaintings(List<Painting> paintings) {
		this.paintings = paintings;
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
