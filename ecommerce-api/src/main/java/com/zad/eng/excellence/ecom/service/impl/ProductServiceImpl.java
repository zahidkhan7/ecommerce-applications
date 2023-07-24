package com.zad.eng.excellence.ecom.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zad.eng.excellence.ecom.dao.ProductRepository;
import com.zad.eng.excellence.ecom.entity.Product;
import com.zad.eng.excellence.ecom.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProductDetails() {

		return productRepository.findAll();
	}

}
