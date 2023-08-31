package com.zad.eng.excellence.ecom.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zad.eng.excellence.ecom.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findByNameContaining(String name);
	
	
	
}
