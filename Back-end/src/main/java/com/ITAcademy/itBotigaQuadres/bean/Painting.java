package com.ITAcademy.itBotigaQuadres.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "painting")
public class Painting {
	
	private @Id @GeneratedValue Long id;
	private String paintingName;
	private String authorName;
	private int paintingPrice;
	private Date entryDate;
	
	@ManyToOne
    @JoinColumn(name="shop_id")
	private Shop shop;
	
	public Painting(String paintingName, String authorName) {
		super();
		this.paintingName = paintingName;
		this.authorName = authorName;
		this.entryDate = new Date();
	}

	public Painting() {
		// TODO Auto-generated constructor stub
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
	
}
