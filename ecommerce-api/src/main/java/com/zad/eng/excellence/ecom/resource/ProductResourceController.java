package com.zad.eng.excellence.ecom.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zad.eng.excellence.ecom.entity.Product;
import com.zad.eng.excellence.ecom.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductResourceController { 
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProductDetails(){
		List<Product> products = productService.getAllProductDetails();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

}
