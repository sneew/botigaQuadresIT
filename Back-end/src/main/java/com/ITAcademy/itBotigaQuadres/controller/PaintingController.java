package com.ITAcademy.itBotigaQuadres.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.ITAcademy.itBotigaQuadres.repository.PaintingRepository;

@RestController
@CrossOrigin(origins = "http://localhost")
public class PaintingController {
	private final PaintingRepository repository;
	
		public PaintingController(PaintingRepository repository) {
			this.repository = repository;
		}

}
