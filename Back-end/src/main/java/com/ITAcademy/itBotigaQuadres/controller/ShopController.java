package com.ITAcademy.itBotigaQuadres.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.ITAcademy.itBotigaQuadres.repository.ShopRepository;

@RestController
@CrossOrigin(origins = "http://localhost")
public class ShopController {
	private final ShopRepository repository;
		public ShopController(ShopRepository repository) {
			this.repository = repository;
		}

}
