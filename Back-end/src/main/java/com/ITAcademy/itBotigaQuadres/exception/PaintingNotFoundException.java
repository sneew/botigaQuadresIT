package com.ITAcademy.itBotigaQuadres.exception;


public class PaintingNotFoundException extends RuntimeException {

	public PaintingNotFoundException(Long id) {
		super("Could not find painting " + id);
	}
}
