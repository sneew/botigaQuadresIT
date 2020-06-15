package com.ITAcademy.itBotigaQuadres.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ITAcademy.itBotigaQuadres.bean.Painting;
import com.ITAcademy.itBotigaQuadres.bean.Shop;

public interface PaintingRepository extends JpaRepository<Painting, Long> {
	
	List<Painting> findAllByShopId(Long id);
	
}
