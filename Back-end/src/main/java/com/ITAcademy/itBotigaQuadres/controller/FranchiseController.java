package com.ITAcademy.itBotigaQuadres.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ITAcademy.itBotigaQuadres.bean.Franchise;
import com.ITAcademy.itBotigaQuadres.exception.FranchiseNotFoundException;
import com.ITAcademy.itBotigaQuadres.repository.FranchiseRepository;

@RestController
@CrossOrigin(origins = "http://localhost")
public class FranchiseController {
	private final FranchiseRepository repository;
	
		public FranchiseController (FranchiseRepository repository) {
			this.repository = repository;
		}
	
		@GetMapping("/franchises")
		List<Franchise> all(){
			return repository.findAll();
		}
		
		@PostMapping("/franchises")
		Franchise newFranchise(@RequestBody Franchise newFranchise) {
			return repository.save(newFranchise);
		}
		
		@GetMapping("/franchises/{id}")
		Franchise one(@PathVariable Long id) {
			return repository.findById(id).orElseThrow(() -> new FranchiseNotFoundException(id));
		}
		
		@PutMapping("/franchises/{id}")
		Franchise replaceFranchise(@RequestBody Franchise newFranchise, @PathVariable Long id) {
			return repository.findById(id).map(franchise -> {
				franchise.setFranchiseName(newFranchise.getFranchiseName());
				return repository.save(franchise);
			}).orElseGet(() -> {
				newFranchise.setId(id);
		        return repository.save(newFranchise);
			});
		}

		@DeleteMapping("/franchises/{id}")
		void deleteFranchise(@PathVariable Long id) {
			repository.deleteById(id);
		}

}
