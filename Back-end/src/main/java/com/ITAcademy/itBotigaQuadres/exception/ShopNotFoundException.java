package com.ITAcademy.itBotigaQuadres.exception;


public class ShopNotFoundException extends RuntimeException {

	public ShopNotFoundException(Long id) {
		super("Could not find shop " + id);
	}
}
