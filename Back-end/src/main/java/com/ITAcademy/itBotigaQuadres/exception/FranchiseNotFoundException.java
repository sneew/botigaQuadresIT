package com.ITAcademy.itBotigaQuadres.exception;


public class FranchiseNotFoundException extends RuntimeException {

	public FranchiseNotFoundException(Long id) {
		super("Could not find franchise " + id);
	}
}
