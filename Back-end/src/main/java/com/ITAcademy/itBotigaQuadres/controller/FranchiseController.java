package com.ITAcademy.itBotigaQuadres.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.ITAcademy.itBotigaQuadres.repository.FranchiseRepository;

@RestController
@CrossOrigin(origins = "http://localhost")
public class FranchiseController {
	private final FranchiseRepository repository;
	
		public FranchiseController (FranchiseRepository repository) {
			this.repository = repository;
		}
	
		

}
