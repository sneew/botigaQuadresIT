package com.ITAcademy.itBotigaQuadres.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ITAcademy.itBotigaQuadres.bean.Franchise;
import com.ITAcademy.itBotigaQuadres.bean.Shop;
import com.ITAcademy.itBotigaQuadres.exception.ShopNotFoundException;
import com.ITAcademy.itBotigaQuadres.repository.ShopRepository;

@RestController
@CrossOrigin(origins = "http://localhost")
public class ShopController {
	private final ShopRepository repository;

		public ShopController(ShopRepository repository) {
			this.repository = repository;
			
		}

		@GetMapping("/shops")
		List<Shop> all(){
			return repository.findAll();
		}
		
		@PostMapping("/franchises/{id}/shops")
		Shop newShop(@RequestBody Shop newShop, @PathVariable Long id) {
			Franchise f = new Franchise();
			f.setId(id);
			newShop.setFranchise(f);
			return repository.save(newShop);
		}
		
		@GetMapping("/shops/{id}")
		Shop one(@PathVariable Long id) {
			return repository.findById(id).orElseThrow(() -> new ShopNotFoundException(id));
		}

		
}
