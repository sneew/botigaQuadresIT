package com.ITAcademy.itBotigaQuadres.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ITAcademy.itBotigaQuadres.bean.Painting;
import com.ITAcademy.itBotigaQuadres.bean.Shop;
import com.ITAcademy.itBotigaQuadres.exception.PaintingFullException;
import com.ITAcademy.itBotigaQuadres.exception.PaintingNotFoundException;
import com.ITAcademy.itBotigaQuadres.exception.ShopNotFoundException;
import com.ITAcademy.itBotigaQuadres.repository.PaintingRepository;
import com.ITAcademy.itBotigaQuadres.repository.ShopRepository;

import net.bytebuddy.implementation.bytecode.Throw;

@RestController
@CrossOrigin(origins = "http://localhost")
public class PaintingController {
	
	@Autowired
	private ShopRepository sRepository;
	
	private final PaintingRepository repository;
	
		
		
		public PaintingController(PaintingRepository repository) {
			this.repository = repository;
		}
		
		@GetMapping("/shops/{id}/paintings")
		List<Painting> findAll(@PathVariable Long id){
			return repository.findAllByShopId(id);
		}
		
		@PostMapping("/shops/{id}/paintings")
		Painting newPainting(@RequestBody Painting newPainting, @PathVariable Long id) {
			Shop shop = sRepository.findById(id).orElseThrow(() -> new ShopNotFoundException(id));
			shop.setId(id);
			List<Painting> pList = repository.findAllByShopId(id);
			if( pList.size() < shop.getShopCapacity()) {
				newPainting.setShop(shop);
				return repository.save(newPainting);
			}else {
				throw new PaintingFullException();
			}
			
		}
		
		@GetMapping("/shops/{id}/paintings/{id}")
		Painting one(@PathVariable Long id) {
			return repository.findById(id).orElseThrow(() -> new PaintingNotFoundException(id));
		}
		
		@PutMapping("/paintings/{id}")
		Painting replacePainting(@RequestBody Painting newPainting, @PathVariable Long id) {
			return repository.findById(id).map(painting -> {
				painting.setPaintingName(newPainting.getPaintingName());
				painting.setAuthorName(newPainting.getAuthorName());
				return repository.save(painting);
			}).orElseGet(() -> {
				newPainting.setId(id);
		        return repository.save(newPainting);
			});
		}

		@DeleteMapping("/shops/{id}/paintings")
		void deletePainting(@PathVariable Long id) {;
			List<Painting> pList = repository.findAllByShopId(id);
			for (Painting p : pList) {
				repository.deleteById(p.getId());
			}
			
		}
}
