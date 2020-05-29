package com.ITAcademy.itBotigaQuadres.loader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ITAcademy.itBotigaQuadres.bean.Franchise;
import com.ITAcademy.itBotigaQuadres.repository.FranchiseRepository;


@Configuration
public class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(FranchiseRepository repository) {
		return args -> {System.out.println("Preloading Data to memotyDatabase"); 
						repository.save(new Franchise("Whtie Collar"));
						System.out.println("Data loaded");
		};
	}
}
