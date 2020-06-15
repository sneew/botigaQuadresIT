package com.ITAcademy.itBotigaQuadres.loader;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ITAcademy.itBotigaQuadres.bean.Franchise;
import com.ITAcademy.itBotigaQuadres.bean.Painting;
import com.ITAcademy.itBotigaQuadres.bean.Shop;
import com.ITAcademy.itBotigaQuadres.repository.FranchiseRepository;
import com.ITAcademy.itBotigaQuadres.repository.PaintingRepository;
import com.ITAcademy.itBotigaQuadres.repository.ShopRepository;


@Configuration
public class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(FranchiseRepository fRepository, ShopRepository sRepository, PaintingRepository pRepository) {
		List<Franchise> fs = fRepository.findAll();
		boolean exist = false;
		for(Franchise f : fs) {
			if (f.getFranchiseName().equals("White Collar")) {
				exist = true;
			}
		}
		if(!exist) {
			Franchise f1 = new Franchise("White Collar");
			Shop s1 = new Shop("Botiga 1", 80, f1);
			Painting p1 = new Painting("Obra 1", "Autor 1", s1);
			return args -> {System.out.println("Preloading Data to memoryDatabase");
				fRepository.save(f1);
				sRepository.save(s1);
				pRepository.save(p1);
				System.out.println("Data loaded");
			};
		}else {
			return args -> {System.out.println("Data loaded");};
		}
	}
}
