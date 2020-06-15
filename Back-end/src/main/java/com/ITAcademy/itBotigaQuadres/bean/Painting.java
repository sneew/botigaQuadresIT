package com.ITAcademy.itBotigaQuadres.bean;

import java.util.Date;

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
@Table(name = "painting")
public class Painting {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private String paintingName;
	private String authorName;
	private int paintingPrice;
	private Date entryDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="shop_id")
	@JsonIgnore
	private Shop shop;
	
	public Painting() {
		introData();
	}

	public Painting(String paintingName, String authorName, Shop shop) {
		super();
		this.paintingName = paintingName;
		this.authorName = authorName;
		this.shop = shop;
		
		introData();
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPaintingName() {
		return paintingName;
	}

	public void setPaintingName(String paintingName) {
		this.paintingName = paintingName;
	}

	public int getPaintingPrice() {
		return paintingPrice;
	}

	public void setPaintingPrice(int paintingPrice) {
		this.paintingPrice = paintingPrice;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	
	private void introData() {
		this.entryDate = new Date();
	}
}
