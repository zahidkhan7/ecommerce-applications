package com.zad.eng.excellence.ecom.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zad.eng.excellence.ecom.model.ProductResponse;
import com.zad.eng.excellence.ecom.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductResourceController { 
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<ProductResponse>> getAllProductDetails(){
		List<ProductResponse> productResponse = productService.getAllProductDetails();
		return new ResponseEntity<List<ProductResponse>>(productResponse, HttpStatus.OK);
	}
	
	@GetMapping("/{prodId}")
	public ResponseEntity<ProductResponse> getProductDetails(@PathVariable String prodId){
		ProductResponse productResponse = productService.getProductDetails(prodId);
		return new ResponseEntity<ProductResponse>(productResponse, HttpStatus.OK);
	}
	
	
	@GetMapping("/findByCategoryId")
	public ResponseEntity<List<ProductResponse>> getProductDetailsByCategory(@RequestParam String categoryId){
		List<ProductResponse> productResponse = productService.getAllProductByProductCategory(categoryId);
		return new ResponseEntity<List<ProductResponse>>(productResponse, HttpStatus.OK);
	}
	
	@GetMapping("/search/findByNameContaining")
	public ResponseEntity<List<ProductResponse>> getProductsByNameContaining(@RequestParam String name){
		List<ProductResponse> productResponse = productService.searchProductByName(name);
		return new ResponseEntity<List<ProductResponse>>(productResponse, HttpStatus.OK);
	}
	


}
